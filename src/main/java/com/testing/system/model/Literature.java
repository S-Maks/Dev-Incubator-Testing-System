package com.testing.system.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="literature")
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int literatureId;

    String description;

    @OneToOne(optional = false, cascade = CascadeType.ALL, mappedBy = "literature")
    private Link link;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    public int getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(int literatureId) {
        this.literatureId = literatureId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Literature that = (Literature) o;
        return literatureId == that.literatureId &&
                description.equals(that.description) &&
                Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(literatureId, description, link);
    }
}
