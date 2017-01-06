package ru.juriasan.clothshop.services;

import ru.juriasan.clothshop.domain.User;

/**
 * Created by GiulioRM on 12/6/2016.
 */
public interface UserService {

    User get(String email);
    void update(User user);
    void create(User user);
}
