package by.newsproject.techversion.model.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private int id;

    @Column(name = "u_login")
    private String login;

    @Column(name = "u_password")
    private String password;

    @Column(name = "u_email")
    private String email;

    @Column(name = "u_birthdate")
    private LocalDate birthDate;

    @Column(name = "u_gender")
    private String gender;

    @Column(name = "u_info")
    private String additionalInfo;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private Role role;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "user",
            cascade = {
                    CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    private List<News> newsList;

    private static final long serialVersionUID = -6232903305483032207L;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(birthDate, user.birthDate) && Objects.equals(gender, user.gender) && Objects.equals(additionalInfo, user.additionalInfo) && Objects.equals(role, user.role) && Objects.equals(newsList, user.newsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, birthDate, gender, additionalInfo, role, newsList);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", role=" + role +
                ", newsList=" + newsList +
                '}';
    }
}
