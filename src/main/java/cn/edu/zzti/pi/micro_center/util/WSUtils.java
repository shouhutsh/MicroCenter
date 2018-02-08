package cn.edu.zzti.pi.micro_center.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

public final class WSUtils {

    private static Logger logger = LoggerFactory.getLogger(WSUtils.class);

    public static void sendMessage(WebSocketSession session, String message) throws IOException {
        logger.info(String.format("WebSocket准备发送给id=%s的消息:%s！", session.getId(), message));
        session.sendMessage(new TextMessage(message));
    }
}
