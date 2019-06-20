package com.web.service.server.SOPARESTwebserver.endpoint;

import com.web.service.server.SOPARESTwebserver.service.UserService;
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
    private UserService userService;

    @PayloadRoot(namespace = NAMESPACE,
            localPart = "createUserRequest")
    @ResponsePayload
    public CreateUserResponse createUser(@RequestPayload CreateUserRequest request) {
        CreateUserResponse response = new CreateUserResponse();
        response.setStatus(userService.createUser(request.getUser()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE,
            localPart = "readUserRequest")
    @ResponsePayload
    public ReadUserResponse readUser(@RequestPayload ReadUserRequest request) {
        ReadUserResponse response = new ReadUserResponse();
        response.setUser(userService.readUser(request.getId().intValue()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE,
            localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
        UpdateUserResponse response = new UpdateUserResponse();
        response.setStatus(userService.updateUser(request.getUser()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE,
            localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {
        DeleteUserResponse response = new DeleteUserResponse();
        response.setStatus(userService.deleteUser(request.getId().intValue()));
        return response;
    }

}
