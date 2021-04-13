package com.testing.system.service.JPAimpl;

import com.testing.system.model.User;
import com.testing.system.repository.JPA.UserRepository;
import com.testing.system.service.RoleService;
import com.testing.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleService roleService;

    private UserRepository userRepository;

    @Autowired
    public void setRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void save(User t, int roleId) {
        t.setRole(roleService.findById(roleId));
        String hashPassword = new BCryptPasswordEncoder().encode(t.getPassword());
        t.setPassword(hashPassword);
        userRepository.save(t);
    }

    @Transactional
    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    @Override
    public void delete(User t) {
        userRepository.delete(t);
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public User findById(int id) {
        return (User) userRepository.findById(id);
    }

}
