package br.com.center.medical.api.controllers;

import br.com.center.medical.api.models.dto.AddPacienteDto;
import br.com.center.medical.api.services.PacienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    @Transactional
    public void adicionarPaciente(@RequestBody @Valid AddPacienteDto dados) {
        pacienteService.adicionarPaciente(dados);
    }

}
