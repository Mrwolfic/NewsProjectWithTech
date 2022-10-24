package by.newsproject.techversion.model.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "news")
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    private int id;
    @NotEmpty (message = "Cannot be empty")
    @Column(name = "n_title")
    private String title;

    @NotEmpty (message = "Cannot be empty")
    @Column(name = "n_brief")
    private String brief;
    @NotEmpty (message = "Cannot be empty")
    @Column(name = "n_content")
    private String content;

    @Column(name = "n_dateofcreation")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateOfCreation;

    @Column(name = "n_status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "n_user_u_id")
    private User user;

    private static final long serialVersionUID = 4274837091720137495L;

    public News() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id && Objects.equals(title, news.title) && Objects.equals(brief, news.brief) && Objects.equals(content, news.content) && Objects.equals(dateOfCreation, news.dateOfCreation) && Objects.equals(user, news.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, brief, content, dateOfCreation, user);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", user=" + user +
                '}';
    }
}
