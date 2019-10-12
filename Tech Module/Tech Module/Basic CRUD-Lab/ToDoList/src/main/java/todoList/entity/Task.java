package todoList.entity;

import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Table(name="tasks")
@Entity
public class Task {
    public Task(Integer id, String title, String comments) {
        this.id = id;
        this.title = title;
        this.comments = comments;
    }
    public Task(){

    }

    private Integer id;
    private String title;
    private String comments;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(columnDefinition = "text",nullable = false)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
