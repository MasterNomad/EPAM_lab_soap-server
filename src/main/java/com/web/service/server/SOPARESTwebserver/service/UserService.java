package com.web.service.server.SOPARESTwebserver.service;

import com.webservice.soap.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements IUserService {

    private Map<Integer, User> users;

    @PostConstruct
    public void initData() {
        users = new HashMap<>();

        User ollie = new User();
        ollie.setId(1);
        ollie.setName("Ollie");
        ollie.setSurname("Blake");
        users.put(ollie.getId(), ollie);

        User doris = new User();
        doris.setId(2);
        doris.setName("Doris");
        doris.setSurname("Barker");
        users.put(doris.getId(), doris);

        User daryl = new User();
        daryl.setId(3);
        daryl.setName("Daryl");
        daryl.setSurname("Taylor");
        users.put(daryl.getId(), daryl);

        User melanie = new User();
        melanie.setId(4);
        melanie.setName("Melanie");
        melanie.setSurname("Bowen");
        users.put(melanie.getId(), melanie);
    }

    @Override
    public User createUser(User user) {
        try {
            users.put(user.getId(), user);
        } catch (Exception e) {
            return null;
        }
        return user;
    }

    @Override
    public User readUser(int id) {
        return users.get(id);
    }

    @Override
    public User updateUser(User user) {
        return users.replace(user.getId(), user);
    }

    @Override
    public boolean deleteUser(int id) {
        if (users.containsKey(id)) {
            users.remove(id);
            return true;
        }
        return false;
    }
}
