package cl.bci.user.adapter.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@RequiredArgsConstructor
public class UserEntity {

    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String phone;

    @Column
    private String token;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date created;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date modified;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date lastLogin;

    @Column
    private Boolean isActive;

}
