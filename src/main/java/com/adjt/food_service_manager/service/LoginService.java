package com.adjt.food_service_manager.service;

import com.adjt.food_service_manager.dto.LoginRequestDTO;
import com.adjt.food_service_manager.dto.LoginResponseDTO;
import com.adjt.food_service_manager.dto.TrocaSenhaRequestDTO;
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
            Optional<UsuarioModel> usuarioModel = usuarioRepository.findByLoginAndSenha(requestDTO.login(), requestDTO.senha());

            if(usuarioModel.isPresent()){
;
                return new LoginResponseDTO(true, "Login ok. Bem vindo ao food-service-manager",  usuarioModel.get().getNome());

            }
            return new LoginResponseDTO(false,"Login ou senha inválidos",null);

        }catch(Exception e){
            e.printStackTrace();
            return new LoginResponseDTO(false,"Erro interno ao processar login", null);
        }
    }


    public LoginResponseDTO trocarSenha(TrocaSenhaRequestDTO trocaSenhaRequestDTO){
        try{
            Optional<UsuarioModel> usuarioModel = usuarioRepository.findByLoginAndSenha(trocaSenhaRequestDTO.login(), trocaSenhaRequestDTO.senha());

            if(usuarioModel.isPresent()){

                UsuarioModel usuariologado = usuarioModel.get();
                usuariologado.setSenha(trocaSenhaRequestDTO.novaSenha());
                usuarioRepository.save(usuariologado);
                return new LoginResponseDTO(true, "Senha Alterada com sucesso",  usuarioModel.get().getNome());

            }
            return new LoginResponseDTO(false,"Login ou Senha Inválidos",null);

        }catch(Exception e){
            e.printStackTrace();
            return new LoginResponseDTO(false,"Erro interno ao processar alteração de senha", null);
        }
    }




}