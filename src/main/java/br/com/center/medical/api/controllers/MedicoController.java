package br.com.center.medical.api.controllers;

import br.com.center.medical.api.models.dto.AddMedicoDTO;
import br.com.center.medical.api.models.dto.GetMedicosDTO;
import br.com.center.medical.api.models.dto.PutDadosDto;
import br.com.center.medical.api.services.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<GetMedicosDTO> adicionarMedico(@Validated @RequestBody AddMedicoDTO dados) {
        return medicoService.adicionarMedico(dados);
    }

    @GetMapping
    public Page<GetMedicosDTO> listarMedicos(Pageable paginado) {
        return medicoService.listarMedicos(paginado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMedicosDTO> buscarMedico(@PathVariable Long id) {
        return medicoService.buscarMedico(id);
    }

    @PutMapping()
    @Transactional
    public void atualizarMedico(@Validated @RequestBody PutDadosDto dados) {
        medicoService.atualizarMedico(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<GetMedicosDTO> desativarMedico(@PathVariable Long id) {
        return medicoService.desativarMedico(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<GetMedicosDTO> ativarMedico(@PathVariable Long id) {
        return medicoService.ativarMedico(id);
    }

}
