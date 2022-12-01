package br.com.center.medical.api.controllers;

import br.com.center.medical.api.models.dto.AddMedicoDTO;
import br.com.center.medical.api.models.dto.ListagemMedicosDTO;
import br.com.center.medical.api.services.MedicoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public void adicionarMedico(@RequestBody @Valid AddMedicoDTO dados) {
        medicoService.adicionarMedico(dados);
    }

    @GetMapping
    public Page<ListagemMedicosDTO> listarMedicos(Pageable paginado) {
        return medicoService.listarMedicos(paginado);
    }

}
