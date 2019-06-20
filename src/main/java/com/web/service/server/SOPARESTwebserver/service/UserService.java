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

        User ollie = new User();
        ollie.setId(BigInteger.valueOf(1));
        ollie.setName("Ollie");
        ollie.setSurname("Blake");
        users.put(ollie.getId().intValue(), ollie);

        User doris = new User();
        doris.setId(BigInteger.valueOf(2));
        doris.setName("Doris");
        doris.setSurname("Barker");
        users.put(doris.getId().intValue(), doris);

        User daryl = new User();
        daryl.setId(BigInteger.valueOf(3));
        daryl.setName("Daryl");
        daryl.setSurname("Taylor");
        users.put(daryl.getId().intValue(), daryl);

        User melanie = new User();
        melanie.setId(BigInteger.valueOf(4));
        melanie.setName("Melanie");
        melanie.setSurname("Bowen");
        users.put(melanie.getId().intValue(), melanie);
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
