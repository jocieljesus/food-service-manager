package com.adjt.food_service_manager.model;

import java.util.Date;

import com.adjt.food_service_manager.enums.UserTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String login;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private UserTypeEnum userTypeEnum;

    @Embedded
    private EnderecoModel endereco;


}



