package com.adjt.food_service_manager.service;

import java.util.List;
import java.util.Optional;
import com.adjt.food_service_manager.service.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.adjt.food_service_manager.model.UsuarioModel;
import com.adjt.food_service_manager.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioModel> listarTodos()
    {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> buscarPorId(Long id){
        return Optional.ofNullable(usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não Encontrado")));
    }

    @Transactional // indica que o método irá rodar dentro de uma transação do bd.
    public UsuarioModel save(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public void excluir(Long id){
        usuarioRepository.deleteById(id);
    }

    public Optional<UsuarioModel> update(Long id, UsuarioModel usuarioModel) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioModel.getNome());
                    usuario.setEmail(usuarioModel.getEmail());
                    usuario.setSenha(usuarioModel.getSenha());
                    usuario.setLogin(usuarioModel.getLogin());
                    usuario.setEndereco(usuarioModel.getEndereco());

                    return usuarioRepository.save(usuario);
                });
    }
    public Optional<UsuarioModel> buscarPorEmail(String email) {
        return Optional.ofNullable(usuarioRepository.findByEmail(email))
                .orElseThrow(() -> new ResourceNotFoundException("Usuario não Encontrado"));
    }

}
