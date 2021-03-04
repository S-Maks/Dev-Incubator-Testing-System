package com.testing.system.model;


import javax.persistence.*;

@Entity
@Table(name="literature")
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int literatureId;
    String description;

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
}
