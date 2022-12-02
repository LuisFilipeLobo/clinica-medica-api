package br.com.center.medical.api.models.entities;

import br.com.center.medical.api.models.dto.AddPacienteDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_pacientes", schema = "public")
public class Paciente extends Usuario {

    @NotBlank
    private String cpf;

    public Paciente(AddPacienteDto dados) {
        this.setNome(dados.nome());
        this.setEmail(dados.email());
        this.setTelefone(dados.telefone());
        this.setCpf(dados.cpf());
        this.setAtivo(true);
        this.setEndereco(new Endereco(dados.endereco()));
    }

}