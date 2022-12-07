package br.com.center.medical.api.models.entities;

import br.com.center.medical.api.models.dto.AddMedicoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Medico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_medicos", schema = "public")
public class Medico extends Usuario {

    @NotBlank
    @Pattern(regexp = "\\d{6}", message = "CRM deve conter 6 digitos")
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    public Medico(AddMedicoDTO dados) {
        this.setNome(dados.nome());
        this.setEmail(dados.email());
        this.setTelefone(dados.telefone());
        this.setEndereco(new Endereco(dados.endereco()));
        this.setAtivo(true);
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
    }

}
