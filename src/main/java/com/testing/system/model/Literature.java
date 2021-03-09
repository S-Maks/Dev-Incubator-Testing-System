package com.testing.system.model;


import javax.persistence.*;

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

}
