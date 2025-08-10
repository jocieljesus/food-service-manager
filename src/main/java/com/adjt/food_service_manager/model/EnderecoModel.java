package com.adjt.food_service_manager.model;

import com.adjt.food_service_manager.dto.EnderecoRequestDTO;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class EnderecoModel {


    private String logradouro;

    private  String numero;

    @NotBlank(message = "Bairro é obrigatório")
    @Size(max = 50)
    private String bairro;

    @NotBlank(message = "Cidade é obrigatória")
    @Size(max = 50)
    private String cidade;

    @NotBlank(message = "Estado é obrigatório")
    @Size(min = 2, max = 2, message = "Estado deve ter 2 letras (ex: SP)")
    private String estado;

    @NotBlank(message = "CEP é obrigatório")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 00000-000")
    private String cep;


    public EnderecoModel(EnderecoRequestDTO enderecoRequestDTO){

        this.logradouro = enderecoRequestDTO.logradouro();
        this.numero = enderecoRequestDTO.numero();
        this.bairro = enderecoRequestDTO.bairro();;
        this.cidade = enderecoRequestDTO.cidade();
        this.estado = enderecoRequestDTO.estado();
        this.cep = enderecoRequestDTO.cep();

    }


}
