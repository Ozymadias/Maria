package message;

import javax.persistence.*;

@Entity
@Table(name = "content")
public class Message {
    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "test", nullable = false)
    private String text;

    public Message(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
