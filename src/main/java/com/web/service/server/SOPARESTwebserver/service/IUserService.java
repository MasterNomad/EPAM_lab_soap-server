package com.web.service.server.SOPARESTwebserver.service;

import com.webservice.soap.User;

public interface IUserService {

    User createUser (User user);
    User readUser (int id);
    User updateUser (User user);
    boolean deleteUser (int id);
}
