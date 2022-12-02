package br.com.center.medical.api.models.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Endereco {
    @NotBlank
    @Size(min = 4)
    private String logradouro;

    private String numero;

    private String complemento;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    @Pattern(regexp = "\\w{2}")
    private String uf;

    @NotBlank
    @Pattern(regexp = "(^\\d{5})-?(\\d{3}$)", message = "CEP incorreto")
    private String cep;

}
