package br.com.center.medical.api.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * A DTO for the {@link br.com.center.medical.api.models.entities.Endereco} entity
 */
public record EnderecoDto(
        @NotBlank
        @Size(min = 4)
        String logradouro,

        String numero,

        String complemento,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        @Pattern(regexp = "\\w{2}")
        String uf,

        @NotBlank
        @Pattern(regexp = "(^\\d{5})-?(\\d{3}$)", message = "CEP incorreto")
        String cep

) implements Serializable {
}