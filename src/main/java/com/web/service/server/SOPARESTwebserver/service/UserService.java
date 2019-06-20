package com.web.service.server.SOPARESTwebserver.service;

import com.webservice.soap.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements IUserService {

    private Map<Integer, User> users;

    @PostConstruct
    public void initData() {
        users = new HashMap<>();

        User newUser = new User();
        newUser.setId(BigInteger.valueOf(1));
        newUser.setName("Ollie");
        newUser.setSurname("Blake");
        users.put(newUser.getId().intValue(), newUser);

        newUser.setId(BigInteger.valueOf(2));
        newUser.setName("Doris");
        newUser.setSurname("Barker");
        users.put(newUser.getId().intValue(), newUser);

        newUser.setId(BigInteger.valueOf(3));
        newUser.setName("Daryl");
        newUser.setSurname("Taylor");
        users.put(newUser.getId().intValue(), newUser);

        newUser.setId(BigInteger.valueOf(4));
        newUser.setName("Melanie");
        newUser.setSurname("Bowen");
        users.put(newUser.getId().intValue(), newUser);
    }

    @Override
    public boolean createUser(User user) {
        try {
            users.put(user.getId().intValue(), user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public User readUser(int id) {
        return users.get(id);
    }

    @Override
    public boolean updateUser(User user) {
        if (users.containsKey(user.getId().intValue())){
            users.put(user.getId().intValue(), user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        if (users.containsKey(id)){
            users.remove(id);
            return true;
        }
        return false;
    }
}
