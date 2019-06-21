package com.web.service.server.SOPARESTwebserver.endpoint;

import com.web.service.server.SOPARESTwebserver.service.IUserService;
import com.webservice.soap.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private final String NAMESPACE = "http://webservice.com/soap";
    @Autowired
    private IUserService userServiceH2;

    @PayloadRoot(namespace = NAMESPACE,
            localPart = "createUserRequest")
    @ResponsePayload
    public CRUUserResponse createUser(@RequestPayload CreateUserRequest request) {
        CRUUserResponse response = new CRUUserResponse();
        response.setUser(userServiceH2.createUser(request.getUser()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE,
            localPart = "readUserRequest")
    @ResponsePayload
    public CRUUserResponse readUser(@RequestPayload ReadUserRequest request) {
        CRUUserResponse response = new CRUUserResponse();
        response.setUser(userServiceH2.readUser(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE,
            localPart = "updateUserRequest")
    @ResponsePayload
    public CRUUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
        CRUUserResponse response = new CRUUserResponse();
        response.setUser(userServiceH2.updateUser(request.getUser()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE,
            localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {
        DeleteUserResponse response = new DeleteUserResponse();
        response.setStatus(userServiceH2.deleteUser(request.getId()));
        return response;
    }

}
