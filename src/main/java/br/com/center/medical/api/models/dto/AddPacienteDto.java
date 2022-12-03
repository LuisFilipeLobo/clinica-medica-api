package br.com.center.medical.api.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * A DTO for the {@link br.com.center.medical.api.models.entities.Paciente} entity
 */
public record AddPacienteDto(
        @NotBlank
        @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s]+$", message = "Digite apenas letras")
        @Size(min = 2, message = "Nome deve conter ao menos 2 caracteres")
        String nome,

        @NotBlank
        String email,

        @NotNull
        @Pattern(regexp = "\\d{8,}")
        String telefone,

        EnderecoDto endereco,

        @NotBlank
        String cpf
) implements Serializable {
}