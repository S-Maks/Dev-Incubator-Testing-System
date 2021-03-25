package com.testing.system.service.impl;

import com.testing.system.model.Question;
import com.testing.system.service.ModelService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ModelServiceImpl implements ModelService {

    @Override
    public void setModelToStartTest(Model model, int questionsSize, Question question) {
        model.addAttribute("isLast", questionsSize == 1 ? 1 : 0);
        model.addAttribute("question", question);
    }
}
