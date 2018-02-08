package cn.edu.zzti.pi.micro_center.service;

import cn.edu.zzti.pi.micro_center.exception.BizException;
import cn.edu.zzti.pi.micro_center.model.Node;
import cn.edu.zzti.pi.micro_center.model.event_entity.*;

public interface NodeManagerService {

    boolean nodeOnline(Node node) throws BizException;

    boolean nodeOffline(Node node) throws BizException;

    boolean nodeRegister(Node node, RegisterModel model) throws BizException;

    boolean sendCommand(Node node, CommandModel model) throws BizException;

    boolean subscript(Node node, SubscriptModel model) throws BizException;

    boolean unsubscribe(Node node, UnsubscribeModel model) throws BizException;

    boolean notifyNodes(Node node, NotificationModel model) throws BizException;
}
