package br.com.center.medical.api.controllers;

import br.com.center.medical.api.models.dto.AddPacienteDto;
import br.com.center.medical.api.models.dto.GetPacienteDto;
import br.com.center.medical.api.models.dto.PutDadosDto;
import br.com.center.medical.api.services.PacienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<GetPacienteDto> listarPacientes(@PageableDefault(sort = "nome") Pageable paginado) {
        return pacienteService.listarPacientes(paginado);
    }

    @PutMapping
    @Transactional
    public void atualizarDadosPaciente(@RequestBody @Valid PutDadosDto dados){
        pacienteService.atualizarDadosPaciente(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void desativarPaciente(@PathVariable Long id) {
        pacienteService.desativarPaciente(id);
    }

}