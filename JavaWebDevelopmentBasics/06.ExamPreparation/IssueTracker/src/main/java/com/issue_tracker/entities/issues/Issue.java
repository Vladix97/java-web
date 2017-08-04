package com.issue_tracker.entities.issues;

import com.issue_tracker.entities.priority.Priority;
import com.issue_tracker.entities.status.Status;
import com.issue_tracker.entities.users.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issues")
public class Issue {

    private Long id;

    private String name;

    private Priority priority;

    private Status status;

    private Date creationDate;

    private User author;

    public Issue() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name = "creation_date", updatable = false)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", updatable = false)
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
