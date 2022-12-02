package br.com.center.medical.api.services;

import br.com.center.medical.api.models.dto.AddPacienteDto;
import br.com.center.medical.api.models.entities.Paciente;
import br.com.center.medical.api.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public void adicionarPaciente(AddPacienteDto dados){
        pacienteRepository.save(new Paciente(dados));
    }

}
