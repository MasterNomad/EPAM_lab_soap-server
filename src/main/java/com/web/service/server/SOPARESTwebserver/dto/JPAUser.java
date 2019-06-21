package com.web.service.server.SOPARESTwebserver.dto;

import com.webservice.soap.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@ToString
public class JPAUser extends User {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    protected int id;

    @Column(name = "name", length = 64, nullable = false)
    protected String name;

    @Column(name = "surname", length = 64, nullable = false)
    protected String surname;

    public JPAUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
    }
}
