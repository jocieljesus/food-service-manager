package com.adjt.food_service_manager.model;

import java.time.LocalDateTime;
import java.util.Date;

import com.adjt.food_service_manager.dto.UsuarioRequestDTO;
import com.adjt.food_service_manager.enums.TipoUsuarioEnum;
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
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String login;

    private String senha;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dtUltimaAlteracao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private TipoUsuarioEnum tipoUsuarioEnum;

    @Embedded
    private EnderecoModel endereco;

    public UsuarioModel(UsuarioRequestDTO usuarioRequestDTO){

        this.nome = usuarioRequestDTO.nome();
        this.email = usuarioRequestDTO.email();
        this.login = usuarioRequestDTO.login();
        this.senha = usuarioRequestDTO.senha();
        this.dtUltimaAlteracao = LocalDateTime.now();
        this.tipoUsuarioEnum = usuarioRequestDTO.tipoUsuarioEnum();
        this.endereco = new EnderecoModel(usuarioRequestDTO.endereco());

    }


}



