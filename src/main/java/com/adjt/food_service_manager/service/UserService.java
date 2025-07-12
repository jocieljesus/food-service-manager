package com.adjt.food_service_manager.service;

import com.adjt.food_service_manager.model.UserModel;
import com.adjt.food_service_manager.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserModel> findById(Long id){
        return userRepository.findById(id);
    }

    @Transactional // indica que o método irá rodar dentro de uma transação do bd.
    public UserModel save(UserModel user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
