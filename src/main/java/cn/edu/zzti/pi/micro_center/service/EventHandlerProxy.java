package cn.edu.zzti.pi.micro_center.service;

import cn.edu.zzti.pi.micro_center.exception.BizException;
import cn.edu.zzti.pi.micro_center.model.CommonRequest;
import org.springframework.web.socket.WebSocketSession;

public interface EventHandlerProxy {

    boolean handlerEvent(WebSocketSession session, CommonRequest request) throws BizException;
}
