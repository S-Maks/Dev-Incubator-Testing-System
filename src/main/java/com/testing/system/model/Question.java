package com.testing.system.model;

import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    private String description;

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "testId")
    private Test test;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
    private List<Answer> answerList;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return questionId == question.questionId && Objects.equals(description, question.description) && Objects.equals(test, question.test);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, description, test);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", description='" + description + '\'' +
                ", test=" + test +
                '}';
    }
}
