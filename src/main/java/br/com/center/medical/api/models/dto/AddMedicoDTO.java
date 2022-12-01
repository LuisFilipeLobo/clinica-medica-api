package br.com.center.medical.api.models.dto;

import br.com.center.medical.api.models.entities.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record AddMedicoDTO(
        @NotBlank @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s]+$", message = "Digite apenas letras")
        @Size(min = 2, message = "Nome deve conter ao menos 2 caracteres")
        String nome,

        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{6}", message = "CRM deve conter 8 digitos")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        EnderecoDto endereco) {
}
