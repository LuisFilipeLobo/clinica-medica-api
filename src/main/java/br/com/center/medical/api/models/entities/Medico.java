package br.com.center.medical.api.models.entities;

import br.com.center.medical.api.models.dto.AddMedicoDTO;
import br.com.center.medical.api.models.dto.PutMedicoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity(name = "Medico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s]+$", message = "Digite apenas letras")
    @Size(min = 2, message = "Nome deve conter ao menos 2 caracteres")
    private String nome;

    // @Pattern(regexp = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+")
    @NotBlank
    private String email;

    @NotNull
    @Pattern(regexp = "\\d{8,}")
    private String telefone;
    @NotBlank
    @Pattern(regexp = "\\d{6}", message = "CRM deve conter 8 digitos")
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(AddMedicoDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarDados(PutMedicoDto dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }

        if (dados.endereco() != null) {
            this.endereco.atualizarEndereco(dados.endereco());
        }

    }

}
