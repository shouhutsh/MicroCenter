package cn.edu.zzti.pi.micro_center.service.impl;

import cn.edu.zzti.pi.micro_center.model.CommonRequest;
import cn.edu.zzti.pi.micro_center.model.Node;
import cn.edu.zzti.pi.micro_center.service.EventHandlerProxy;
import cn.edu.zzti.pi.micro_center.service.NodeManagerService;
import cn.edu.zzti.pi.micro_center.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketHandlerImpl extends TextWebSocketHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EventHandlerProxy eventHandlerProxy;
    @Autowired
    private NodeManagerService nodeManagerService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info(String.format("WebSocket建立连接！id=%s", session.getId()));
        nodeManagerService.nodeOnline(new Node(session));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String event = message.getPayload();
        logger.info(String.format("WebSocket接收到id=%s的消息:%s！", session.getId(), event));
        CommonRequest request = JsonUtils.parseObject(event, CommonRequest.class);
        eventHandlerProxy.handlerEvent(session, request);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        logger.error(String.format("WebSocket异常！id=%s, message=%s", session.getId(), exception.getMessage()), exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        nodeManagerService.nodeOffline(new Node(session));
        logger.info(String.format("WebSocket关闭连接！id=%s", session.getId()));
    }
}
