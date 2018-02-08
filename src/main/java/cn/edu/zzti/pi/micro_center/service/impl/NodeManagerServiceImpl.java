package cn.edu.zzti.pi.micro_center.service.impl;

import cn.edu.zzti.pi.micro_center.exception.BizException;
import cn.edu.zzti.pi.micro_center.model.Node;
import cn.edu.zzti.pi.micro_center.model.event_entity.*;
import cn.edu.zzti.pi.micro_center.service.NodeManagerService;
import cn.edu.zzti.pi.micro_center.util.MapUtils;
import cn.edu.zzti.pi.micro_center.util.WSUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NodeManagerServiceImpl implements NodeManagerService {

    private static final String NODE_ID_KEY = "NODE_ID_KEY";
    private static Map<String, WebSocketSession> orgSessionMap = new ConcurrentHashMap<>();
    private static Map<String, String> idMap = new ConcurrentHashMap<>();
    private static Map<String, RegisterModel> registerMap = new ConcurrentHashMap<>();
    private static Map<String, Set<String>> topicMap = new ConcurrentHashMap<>();

    @Override
    public boolean nodeOnline(Node node) throws BizException {
        orgSessionMap.put(node.getSession().getId(), node.getSession());
        return true;
    }

    @Override
    public boolean nodeOffline(Node node) throws BizException {
        orgSessionMap.remove(node.getSession().getId());
        return true;
    }

    @Override
    public boolean nodeRegister(Node node, RegisterModel model) throws BizException {
        WebSocketSession session = node.getSession();
        session.getAttributes().put(NODE_ID_KEY, model.getNodeId());
        idMap.put(model.getNodeId(), session.getId());
        registerMap.put(model.getNodeId(), model);
        return true;
    }

    @Override
    public boolean sendCommand(Node node, CommandModel model) throws BizException {
        try {
            WebSocketSession session = node.getSession();
            String fromNodeId = (String) session.getAttributes().get(NODE_ID_KEY);
            String id = idMap.get(model.getNodeId());
            if (!idMap.containsKey(fromNodeId)) {
                id = model.getNodeId();
            }
            if (orgSessionMap.containsKey(id)) {
                WSUtils.sendMessage(orgSessionMap.get(id), model.getCommand());
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new BizException("发送命令失败！", e);
        }
    }

    @Override
    public boolean subscript(Node node, SubscriptModel model) throws BizException {
        WebSocketSession session = node.getSession();
        String fromNodeId = (String) session.getAttributes().get(NODE_ID_KEY);
        MapUtils.putSet(topicMap, model.getTopic(), fromNodeId);
        return true;
    }

    @Override
    public boolean unsubscribe(Node node, UnsubscribeModel model) throws BizException {
        WebSocketSession session = node.getSession();
        String fromNodeId = (String) session.getAttributes().get(NODE_ID_KEY);
        topicMap.get(model.getTopic()).remove(fromNodeId);
        return true;
    }

    @Override
    public boolean notifyNodes(Node node, NotificationModel model) throws BizException {
        CommandModel command = new CommandModel();
        command.setCommand(model.getMessage());
        for (String nodeId : topicMap.get(model.getTopic())) {
            command.setNodeId(nodeId);
            sendCommand(node, command);
        }
        return true;
    }
}
