package cn.edu.zzti.pi.micro_center.service.impl;

import cn.edu.zzti.pi.micro_center.exception.BizException;
import cn.edu.zzti.pi.micro_center.model.CommonRequest;
import cn.edu.zzti.pi.micro_center.model.EventType;
import cn.edu.zzti.pi.micro_center.model.Node;
import cn.edu.zzti.pi.micro_center.model.event_entity.*;
import cn.edu.zzti.pi.micro_center.service.EventHandlerProxy;
import cn.edu.zzti.pi.micro_center.service.NodeManagerService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
public class EventHandlerProxyImpl implements EventHandlerProxy {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private NodeManagerService nodeManagerService;

    @Override
    public boolean handlerEvent(WebSocketSession session, CommonRequest request) throws BizException {
        EventType type = EventType.byCode(request.getType());
        if(null == type) return false;

        AbstractEventModel event = JSONObject.parseObject(request.getData(), type.getClazz());
        switch (type) {
            case Notification:
                return nodeManagerService.notifyNodes(new Node(session), (NotificationModel) event);
            case Command:
                return nodeManagerService.sendCommand(new Node(session), (CommandModel) event);
            case Register:
                return nodeManagerService.nodeRegister(new Node(session), (RegisterModel) event);
            case Subscript:
                return nodeManagerService.subscript(new Node(session), (SubscriptModel) event);
            case Unsubscribe:
                return nodeManagerService.unsubscribe(new Node(session), (UnsubscribeModel) event);
            default:
                return false;
        }
    }
}
