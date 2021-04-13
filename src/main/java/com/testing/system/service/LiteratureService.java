package com.testing.system.service;

import com.testing.system.model.Literature;
import com.testing.system.model.Question;

import java.util.List;

public interface LiteratureService {
    void save(Literature t);

    void delete(Literature t);

    List<Literature> findAll();

    Literature findById(int id);
}
