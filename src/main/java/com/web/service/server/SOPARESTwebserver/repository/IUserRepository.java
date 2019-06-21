package com.web.service.server.SOPARESTwebserver.repository;


import com.web.service.server.SOPARESTwebserver.dto.JPAUser;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<JPAUser, Integer> {

}
