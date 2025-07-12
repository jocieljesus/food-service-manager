package com.adjt.food_service_manager.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Embeddable
public class EnderecoModel {

    @NotBlank(message = "Logradouro é obrigatório")
    @Size(max = 100)
    private String logradouro;

    private  int numero;

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

}
