package br.com.center.medical.api.services;

import br.com.center.medical.api.models.dto.AddMedicoDTO;
import br.com.center.medical.api.models.dto.GetMedicosDTO;
import br.com.center.medical.api.models.dto.PutDadosDto;
import br.com.center.medical.api.models.entities.Medico;
import br.com.center.medical.api.repositories.MedicoRepository;
import br.com.center.medical.api.services.execptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public ResponseEntity<GetMedicosDTO> adicionarMedico(AddMedicoDTO dados) {
        Medico medico = new Medico(dados);

        medicoRepository.save(medico);

        GetMedicosDTO dto = new GetMedicosDTO(medico);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    public Page<GetMedicosDTO> listarMedicos(Pageable paginado) {
        return medicoRepository.findAll(paginado).map(GetMedicosDTO::new);
    }

    public ResponseEntity<GetMedicosDTO> buscarMedico(Long id) {
        Medico medico = medicoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(HttpStatus.NOT_FOUND, "ID " + id + " não encontrado")
        );

        return ResponseEntity.ok().body(new GetMedicosDTO(medico));
    }

    public void atualizarMedico(PutDadosDto dados) {
        Medico medico = medicoRepository.findById(dados.id()).orElseThrow(
                () -> new EntityNotFoundException(HttpStatus.NOT_FOUND, "ID " + dados.id() + " não encontrado")
        );

        medico.atualizarDados(dados);
    }

    public ResponseEntity<GetMedicosDTO> desativarMedico(Long id) {
        Medico med = medicoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(HttpStatus.NOT_FOUND, "ID " + id + " não encontrado")
        );

        medicoRepository.desativarMedico(id);
        
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<GetMedicosDTO> ativarMedico(Long id) {
        medicoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(HttpStatus.NOT_FOUND, "ID " + id + " não encontrado")
        );

        medicoRepository.ativarMedico(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
