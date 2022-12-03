package br.com.center.medical.api.services;

import br.com.center.medical.api.models.dto.AddPacienteDto;
import br.com.center.medical.api.models.dto.GetPacienteDto;
import br.com.center.medical.api.models.dto.PutDadosDto;
import br.com.center.medical.api.models.entities.Paciente;
import br.com.center.medical.api.repositories.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public void adicionarPaciente(AddPacienteDto dados) {
        pacienteRepository.save(new Paciente(dados));
    }

    public Page<GetPacienteDto> listarPacientes(Pageable paginado) {
        return pacienteRepository.findAll(paginado).map(GetPacienteDto::new);
    }

    public void atualizarDadosPaciente(PutDadosDto dados) {
        Paciente paciente = pacienteRepository.getReferenceById(dados.id());

        paciente.atualizarDados(dados);
    }

    public void desativarPaciente(Long id) {
        pacienteRepository.desativarPaciente(id);
    }

    public void ativarPaciente(Long id) {
        pacienteRepository.ativarPaciente(id);
    }

}
