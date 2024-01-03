package ua.com.marketplace.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.marketplace.backend.model.User;
import ua.com.marketplace.backend.repository.UserRepository;
import ua.com.marketplace.backend.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User create(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists.");
        }
        return userRepository.save(user);
    }

    @Override
    public User readById(String id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("User with id " + id + " doesn't exist.");
        }
        return userRepository.findById(id).get();
    }

    @Override
    public User update(User user) {
        if (userRepository.findById(user.getId()).isEmpty()) {
            throw new IllegalArgumentException("User with id " + user.getId() + " doesn't exist.");
        }
        return userRepository.save(user);
    }

    @Override
    public void delete(String id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("User with id " + id + " doesn't exist.");
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
