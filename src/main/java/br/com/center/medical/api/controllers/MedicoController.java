package br.com.center.medical.api.controllers;

import br.com.center.medical.api.models.dto.AddMedicoDTO;
import br.com.center.medical.api.services.MedicoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/medicos")
public class MedicoController {

    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public void adicionarMedico(@RequestBody @Valid AddMedicoDTO dados) {
        medicoService.adicionarMedico(dados);
    }

}
