package br.com.center.medical.api.services;

import br.com.center.medical.api.models.dto.AddPacienteDto;
import br.com.center.medical.api.models.dto.GetPacienteDto;
import br.com.center.medical.api.models.dto.PutDadosDto;
import br.com.center.medical.api.models.entities.Paciente;
import br.com.center.medical.api.repositories.PacienteRepository;
import br.com.center.medical.api.services.execptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public ResponseEntity<GetPacienteDto> adicionarPaciente(AddPacienteDto dados) {
        Paciente p = new Paciente(dados);
        pacienteRepository.save(new Paciente(dados));


        GetPacienteDto dto = new GetPacienteDto(p);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    public Page<GetPacienteDto> listarPacientes(Pageable paginado) {
        return pacienteRepository.findAll(paginado).map(GetPacienteDto::new);
    }

    public void atualizarDadosPaciente(PutDadosDto dados) {
        Paciente paciente = pacienteRepository.findById(dados.id()).orElseThrow(
                () -> new EntityNotFoundException(HttpStatus.NOT_FOUND, "Usuário não encontrado")
        );

        paciente.atualizarDados(dados);
    }

    public void desativarPaciente(Long id) {
        pacienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(HttpStatus.NOT_FOUND, "Usuário não encontrado")
        );

        pacienteRepository.desativarPaciente(id);
    }

    public void ativarPaciente(Long id) {
        pacienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(HttpStatus.NOT_FOUND, "Usuário não encontrado")
        );

        pacienteRepository.ativarPaciente(id);
    }

}
