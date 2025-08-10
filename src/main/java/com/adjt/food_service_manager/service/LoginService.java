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
        try{
            Optional<UsuarioModel> usuarioModel = usuarioRepository.findByLogin(requestDTO.login());

            if(usuarioModel.isPresent()){
                UsuarioModel usuario = usuarioModel.get();

                if(usuario.getSenha().equals(requestDTO.senha())){
                    return new LoginResponseDTO(true, "Login ok. Bem vindo ao food-service-manager", usuario.getNome());

                }
            }
            return new LoginResponseDTO(false,"Login ou senha inválidos",null);

        }catch(Exception e){
            e.printStackTrace();
            return new LoginResponseDTO(false,"Erro interno ao processar login", null);
        }

    }
}