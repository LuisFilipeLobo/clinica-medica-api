package br.com.center.medical.api.models.dto;

import br.com.center.medical.api.models.entities.Especialidade;
import br.com.center.medical.api.models.entities.Medico;

import java.io.Serializable;

/**
 * A DTO for the {@link br.com.center.medical.api.models.entities.Medico} entity
 */
public record GetMedicosDTO(Long id, String nome, String email, String crm,
                            Especialidade especialidade, Boolean ativo) implements Serializable {

    public GetMedicosDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getAtivo());
    }

}