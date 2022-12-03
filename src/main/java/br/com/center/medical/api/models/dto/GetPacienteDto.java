package br.com.center.medical.api.models.dto;

import br.com.center.medical.api.models.entities.Paciente;

import java.io.Serializable;

/**
 * A DTO for the {@link br.com.center.medical.api.models.entities.Paciente} entity
 */
public record GetPacienteDto(Long id, String nome, String email, String cpf) implements Serializable {

    public GetPacienteDto(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}