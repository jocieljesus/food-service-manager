package com.adjt.food_service_manager.controller;

import java.util.List;

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

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @Operation(summary = "Cadastrar um novo usuário")
    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@RequestBody @Valid UsuarioModel usuarioModel) {
        UsuarioModel novo = usuarioService.save(usuarioModel);
        return new ResponseEntity<>(novo, HttpStatus.CREATED);
    }
    @Operation(summary = "Listar todos os Usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioModel>> listarUsuarios() {
        List<UsuarioModel> usuarios = usuarioService.listarTodos();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    @Operation(summary = "Buscar Usuario por ID")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Buscar Usuario por Email")
    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioModel> buscarPorEmail(@PathVariable String email) {
        return usuarioService.buscarPorEmail(email)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @Operation(summary = "Atualizar Usuarios")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atualizarUsuarios(@PathVariable Long id,
                                                   @RequestBody @Valid UsuarioModel usuarioModel) {
        return usuarioService.update(id, usuarioModel)
                .map(usuarioAtualizado -> new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Excluir um Usuario por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuarios(@PathVariable Long id) {
        usuarioService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}