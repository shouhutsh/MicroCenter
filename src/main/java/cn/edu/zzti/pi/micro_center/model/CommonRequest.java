package cn.edu.zzti.pi.micro_center.model;

public class CommonRequest extends BaseModel {

    private String type;
    private String data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
