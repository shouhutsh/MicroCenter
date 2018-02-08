package cn.edu.zzti.pi.micro_center.model.event_entity;

public class RegisterModel extends AbstractEventModel {

    private String nodeId;
    private String usage;
    private String description;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
