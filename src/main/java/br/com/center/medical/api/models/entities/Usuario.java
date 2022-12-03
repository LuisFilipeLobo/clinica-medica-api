package br.com.center.medical.api.models.entities;

import br.com.center.medical.api.models.dto.PutDadosDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public abstract class Usuario {

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

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public void atualizarDados(PutDadosDto dados) {
        if (dados.nome() != null) {
            this.setNome(dados.nome());
        }

        if (dados.telefone() != null) {
            this.setTelefone(dados.telefone());
        }

        if (dados.endereco() != null) {
            this.setEndereco(new Endereco(dados.endereco()));
        }

    }

}
