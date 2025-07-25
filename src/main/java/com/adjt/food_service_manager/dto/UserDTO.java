package com.adjt.food_service_manager.dto;

import com.adjt.food_service_manager.enums.UserTypeEnum;
import com.adjt.food_service_manager.model.EnderecoModel;
import com.adjt.food_service_manager.model.EnderecoModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String login;
    private Date lastModified;
    private UserTypeEnum userTypeEnum;
    private EnderecoDTO endereco;


}