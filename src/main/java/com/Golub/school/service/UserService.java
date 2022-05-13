package com.Golub.school.service;

import com.Golub.school.entity.Role;
import com.Golub.school.entity.User;
import com.Golub.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User userBySecurityContext() {
        User user = new User();
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return user;
        } catch (NullPointerException ex) {
            return user;
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findUserById(int id) {
        return userRepository.findUserByIduser(id);
    }

    public void editUserRole(String role, int id) {
        User user = userRepository.findUserByIduser(id);

        user.setStatus(role);
        userRepository.save(user);
    }

    public void editUserActive(boolean active, int id) {
        User user = userRepository.findUserByIduser(id);

        user.setActive(active);
        userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
