package br.com.center.medical.api.controllers;

import br.com.center.medical.api.models.dto.AddMedicoDTO;
import br.com.center.medical.api.models.dto.GetMedicosDTO;
import br.com.center.medical.api.models.dto.PutDadosDto;
import br.com.center.medical.api.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public void adicionarMedico(@RequestBody @Valid AddMedicoDTO dados) {
        medicoService.adicionarMedico(dados);
    }

    @GetMapping
    public Page<GetMedicosDTO> listarMedicos(Pageable paginado) {
        return medicoService.listarMedicos(paginado);
    }

    @GetMapping("/{id}")
    public GetMedicosDTO buscarMedico(@PathVariable Long id) {
        return medicoService.buscarMedico(id);
    }

    @PutMapping()
    @Transactional
    public void atualizarMedico(@RequestBody @Valid PutDadosDto dados) {
        medicoService.atualizarMedico(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void desativarMedico(@PathVariable Long id) {
        medicoService.desativarMedico(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public void ativarMedico(@PathVariable Long id) {
        medicoService.ativarMedico(id);
    }

}
