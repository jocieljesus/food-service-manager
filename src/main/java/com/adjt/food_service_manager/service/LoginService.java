package com.adjt.food_service_manager.service;

import com.adjt.food_service_manager.dto.LoginRequestDTO;
import com.adjt.food_service_manager.dto.LoginResponseDTO;
import com.adjt.food_service_manager.model.UsuarioModel;
import com.adjt.food_service_manager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public LoginResponseDTO autenticar(LoginRequestDTO requestDTO){
        Optional<UsuarioModel> usuarioModel = usuarioRepository.findByLogin(requestDTO.getLogin());

        if(usuarioModel.isPresent()){
            UsuarioModel usuario = usuarioModel.get();

            if(usuario.getSenha().equals(requestDTO.getSenha())){
                return new LoginResponseDTO(true, "Login ok. Bem vindo ao food-service-manager", usuario.getNome());

            }
        }
        return new LoginResponseDTO(false,"Login ou senha inválidos",null);
    }
}
