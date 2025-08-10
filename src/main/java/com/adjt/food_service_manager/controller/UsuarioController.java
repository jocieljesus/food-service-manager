package com.adjt.food_service_manager.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.adjt.food_service_manager.dto.LoginRequestDTO;
import com.adjt.food_service_manager.dto.LoginResponseDTO;
import com.adjt.food_service_manager.dto.UsuarioRequestDTO;
import com.adjt.food_service_manager.dto.UsuarioResponseDTO;
import com.adjt.food_service_manager.mapper.UsuarioMapper;
import com.adjt.food_service_manager.service.LoginService;
import com.adjt.food_service_manager.service.exceptions.ResourceNotFoundException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import com.adjt.food_service_manager.model.UsuarioModel;
import com.adjt.food_service_manager.service.UsuarioService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    private final UsuarioService usuarioService;
    private LoginService loginService;

    public UsuarioController(UsuarioService usuarioService, LoginService loginService) {
        this.usuarioService = usuarioService;
        this.loginService = loginService;
    }
    @Operation(summary = "Cadastrar um novo usuário")
    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO) {

        logger.info("POST -> /cadastrar/"+ usuarioRequestDTO.email());

        UsuarioModel novoUsuario = UsuarioMapper.toEntity(usuarioRequestDTO);
        return new ResponseEntity<>(UsuarioMapper.toResponseDTO(usuarioService.save(novoUsuario)), HttpStatus.CREATED);
    }
    @Operation(summary = "Listar todos os Usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {

        logger.info("GET -> /listar/");

        List<UsuarioResponseDTO> usuarios = usuarioService.listarTodos()
                .stream().map(UsuarioMapper::toResponseDTO).collect(Collectors.toList());;
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    @Operation(summary = "Buscar Usuario por ID")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {

        logger.info("GET -> /{id} "+ id);

        return usuarioService.buscarPorId(id)
                .map(usuario -> new ResponseEntity<>(UsuarioMapper.toResponseDTO(usuario), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Buscar Usuario por Email")
    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorEmail(@PathVariable String email) {

        logger.info("GET -> /email/{email} "+ email);

        return usuarioService.buscarPorEmail(email)
                .map(usuario -> new ResponseEntity<>(UsuarioMapper.toResponseDTO(usuario), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @Operation(summary = "Atualizar Usuarios")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuarios(@PathVariable Long id,
                                                   @RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO) {

        logger.info("PUT -> /{id} "+ id + " " + usuarioRequestDTO.login());

        return usuarioService.update(id, UsuarioMapper.toEntity(usuarioRequestDTO))
                .map(usuarioAtualizado -> new ResponseEntity<>(UsuarioMapper.toResponseDTO(usuarioAtualizado), HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado"));
    }

    @Operation(summary = "Excluir um Usuario por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuarios(@PathVariable Long id) {

        logger.info("DELETE -> /{id} "+ id );

        usuarioService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Verificar autenticação")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request){
        LoginResponseDTO responseDTO = loginService.autenticar(request);
        if(responseDTO.autenticado()){
            return ResponseEntity.ok(responseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDTO);
        }
    }

}
