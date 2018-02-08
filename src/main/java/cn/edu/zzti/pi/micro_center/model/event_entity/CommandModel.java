package cn.edu.zzti.pi.micro_center.model.event_entity;

public class CommandModel extends AbstractEventModel {

    private String nodeId;
    private String command;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
