package ru.juriasan.clothshop.services;

import ru.juriasan.clothshop.database.repository.UserRepository;
import ru.juriasan.clothshop.domain.User;

/**
 * Created by GiulioRM on 12/27/2016.
 */
public class UserServiceImpl implements UserService {
    UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public User get(String email) {
        return repository.get(email);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public void create(User user) {
        repository.create(user);
    }
}
