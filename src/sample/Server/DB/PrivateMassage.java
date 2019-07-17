package sample.Server.DB;

public class PrivateMassage {
    private Integer user_id_sender;
    private Integer user_id_receiver;
    private String text;
    private String date;
    private  Integer id;

    public void setUser_id_sender(Integer user_id_sender) {
        this.user_id_sender = user_id_sender;
    }

    public Integer getUser_id_sender() {
        return user_id_sender;
    }

    @Override
    public String toString() {
        return "PrivateMassage{" +
                "user_id_sender=" + user_id_sender +
                ", user_id_receiver=" + user_id_receiver +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", id=" + id +
                '}';
    }

    public Integer getUser_id_receiver() {
        return user_id_receiver;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

    public void setUser_id_receiver(Integer user_id_receiver) {
        this.user_id_receiver = user_id_receiver;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}