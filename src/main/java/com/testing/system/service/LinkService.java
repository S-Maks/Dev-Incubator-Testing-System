package com.testing.system.service;

import com.testing.system.model.Link;

import java.util.List;

public interface LinkService {
    void save(Link t);

    void delete(Link t);

    List<Link> findAll();

    Link findById(int id);
}
