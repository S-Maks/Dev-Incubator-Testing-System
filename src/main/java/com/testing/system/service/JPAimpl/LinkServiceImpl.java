package com.testing.system.service.JPAimpl;

import com.testing.system.model.Link;
import com.testing.system.repository.JPA.LinkRepository;
import com.testing.system.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {

    LinkRepository linkRepository;

    @Autowired
    public void setLinkRepository(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    @Transactional
    @Override
    public void save(Link t) {
        linkRepository.save(t);
    }

   /* @Transactional
    @Override
    public void update(Link t) {
        linkRepository.update(t);
    }*/

    @Override
    public void delete(Link t) {
        linkRepository.delete(t);
    }

    @Transactional
    @Override
    public List<Link> findAll() {
        return linkRepository.findAll();
    }

    @Transactional
    @Override
    public Link findById(int id) {
        return (Link) linkRepository.findById(id).get();
    }
}
