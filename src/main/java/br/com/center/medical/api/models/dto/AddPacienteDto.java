package br.com.center.medical.api.models.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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
        @Pattern(regexp = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+", message = "Email inválido")
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{11}", message = "Deve conter 11 dígitos (DDD + número)")
        String telefone,

        @Valid
        EnderecoDto endereco,

        @NotBlank
        @Pattern(regexp = "^\\d{3}.?\\d{3}.?\\d{3}\\-?\\d{2}$", message = "CFP inválido")
        String cpf
) implements Serializable {
}