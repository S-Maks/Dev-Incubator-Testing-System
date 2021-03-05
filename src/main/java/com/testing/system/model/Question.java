package com.testing.system.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "testId")
    private Test test;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Statistic> statisticSet;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Answer> answerSet;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Literature> literatureSet;

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

    public Set<Statistic> getStatisticSet() {
        return statisticSet;
    }

    public void setStatisticSet(Set<Statistic> statisticSet) {
        this.statisticSet = statisticSet;
    }

    public Set<Answer> getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(Set<Answer> answerSet) {
        this.answerSet = answerSet;
    }

    public Set<Literature> getLiteratureSet() {
        return literatureSet;
    }

    public void setLiteratureSet(Set<Literature> literatureSet) {
        this.literatureSet = literatureSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return questionId == question.questionId && Objects.equals(description, question.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, description);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", description='" + description + '\'' +
                '}';
    }
}
