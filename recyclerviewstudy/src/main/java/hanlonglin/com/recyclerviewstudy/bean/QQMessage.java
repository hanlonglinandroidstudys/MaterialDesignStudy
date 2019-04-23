package hanlonglin.com.recyclerviewstudy.bean;

public class QQMessage {
    int imgId;
    String fromName;
    String content;
    String popMes;

    public QQMessage(int imgId, String fromName, String content, String popMes) {
        this.imgId = imgId;
        this.fromName = fromName;
        this.content = content;
        this.popMes = popMes;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPopMes() {
        return popMes;
    }

    public void setPopMes(String popMes) {
        this.popMes = popMes;
    }
}
