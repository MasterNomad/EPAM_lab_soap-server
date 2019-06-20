package com.web.service.server.SOPARESTwebserver.service;

import com.webservice.soap.User;

public interface IUserService {

    boolean createUser (User user);
    User readUser (int id);
    boolean updateUser (User user);
    boolean deleteUser (int id);
}
