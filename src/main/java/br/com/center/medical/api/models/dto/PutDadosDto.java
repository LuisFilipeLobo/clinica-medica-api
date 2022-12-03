package br.com.center.medical.api.models.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * A DTO for the {@link br.com.center.medical.api.models.entities.Medico} entity
 */
public record PutDadosDto(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDto endereco
) implements Serializable {
}