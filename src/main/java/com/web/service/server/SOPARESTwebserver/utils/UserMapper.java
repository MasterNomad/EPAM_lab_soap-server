package com.web.service.server.SOPARESTwebserver.utils;

import com.webservice.soap.User;

public class UserMapper {

    static public void mapUser (User target, User source) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
    }

}
