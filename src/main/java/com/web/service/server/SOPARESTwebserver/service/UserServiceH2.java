package com.web.service.server.SOPARESTwebserver.service;

import com.web.service.server.SOPARESTwebserver.dto.JPAUser;
import com.web.service.server.SOPARESTwebserver.repository.IUserRepository;
import com.web.service.server.SOPARESTwebserver.utils.UserMapper;
import com.webservice.soap.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceH2 implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @PostConstruct
    public void initData() {
        JPAUser ollie = new JPAUser();
        ollie.setName("Anton");
        ollie.setSurname("Blake");
        userRepository.save(ollie);

        JPAUser doris = new JPAUser();
        doris.setName("Doris");
        doris.setSurname("Barker");
        userRepository.save(doris);

        JPAUser daryl = new JPAUser();
        daryl.setName("Daryl");
        daryl.setSurname("Taylor");
        userRepository.save(daryl);

        JPAUser melanie = new JPAUser();
        melanie.setName("Melanie");
        melanie.setSurname("Bowen");
        userRepository.save(melanie);
    }

    @Override
    public User createUser(User user) {
        JPAUser jpaUser = new JPAUser(user);
        userRepository.save(jpaUser);
        return user;
    }

    @Override
    public User readUser(int id) {
        JPAUser jpaUser = userRepository.findById(id).orElse(null);
        User user = new User();
        if (jpaUser != null) {
            UserMapper.mapUser(user, jpaUser);
        }
        return user;
    }

    @Override
    public User updateUser(User user) {
        JPAUser jpaUser = new JPAUser(user);
        if (userRepository.existsById(jpaUser.getId())) {
            userRepository.save(jpaUser);
            return user;
        }
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
