package cn.edu.zzti.pi.micro_center.model;

import org.springframework.web.socket.WebSocketSession;

public final class Node {

    private final WebSocketSession session;

    public Node(WebSocketSession session) {
        this.session = session;
    }

    public WebSocketSession getSession() {
        return session;
    }
}
