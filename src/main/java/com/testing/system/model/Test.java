package com.testing.system.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testId;
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topicId")
    private Topic topic;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Question> questions;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return testId == test.testId && name.equals(test.name) && description.equals(test.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testId, name, description);
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
