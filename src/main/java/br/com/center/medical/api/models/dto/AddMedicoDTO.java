package br.com.center.medical.api.models.dto;

import br.com.center.medical.api.models.entities.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddMedicoDTO(

        @NotBlank
        @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s]+$", message = "Digite apenas letras")
        @Size(min = 2, message = "Nome deve conter ao menos 2 caracteres")
        String nome,

        @NotBlank
        @Pattern(regexp = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+", message = "Email inválido")
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{11}", message = "Deve conter 11 dígitos (DDD + número")
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{6}", message = "CRM deve conter 6 digitos")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        EnderecoDto endereco) {
}
