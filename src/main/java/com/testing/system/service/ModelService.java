package com.testing.system.service;

import com.testing.system.model.Question;
import org.springframework.ui.Model;

public interface ModelService {
    void setModelToStartTest(Model model, int questionsSize, Question question);
}
