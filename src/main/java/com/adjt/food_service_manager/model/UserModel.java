package com.adjt.food_service_manager.model;

import com.adjt.food_service_manager.entities.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String login;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @Embedded
    private Endereco endereco;


}



