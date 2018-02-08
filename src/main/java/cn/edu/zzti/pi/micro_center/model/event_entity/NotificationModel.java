package cn.edu.zzti.pi.micro_center.model.event_entity;

public class NotificationModel extends AbstractEventModel {

    private String topic;
    private String message;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
