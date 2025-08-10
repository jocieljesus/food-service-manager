package com.adjt.food_service_manager.controller;


import com.adjt.food_service_manager.dto.LoginRequestDTO;
import com.adjt.food_service_manager.dto.LoginResponseDTO;
import com.adjt.food_service_manager.dto.TrocaSenhaRequestDTO;
import com.adjt.food_service_manager.service.LoginService;
import com.adjt.food_service_manager.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {



    private LoginService loginService;

    public AutenticacaoController(LoginService loginService) {
        this.loginService = loginService;
    }

    @Operation(summary = "Realizar Login na aplicação")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request){
        LoginResponseDTO responseDTO = loginService.autenticar(request);
        if(responseDTO.autenticado()){
            return ResponseEntity.ok(responseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDTO);
        }
    }

    @Operation(summary = "Alterar Senha de Usuário")
    @PostMapping("/alterarsenha")
    public ResponseEntity<LoginResponseDTO> alterarSenhaDeUsuario(@RequestBody TrocaSenhaRequestDTO request){
        LoginResponseDTO responseDTO = loginService.trocarSenha(request);
        if(responseDTO.autenticado()){
            return ResponseEntity.ok(responseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDTO);
        }
    }


}
