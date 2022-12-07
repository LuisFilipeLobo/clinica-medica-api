package br.com.center.medical.api.models.entities;


import br.com.center.medical.api.models.dto.EnderecoDto;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Endereco {
    @NotBlank
    @Size(min = 2, message = "Deve conter ao menos 2 caracteres")
    private String logradouro;

    private String numero;

    private String complemento;

    @NotBlank
    @Size(min = 2, message = "Deve conter ao menos 2 caracteres")
    private String bairro;

    @NotBlank
    @Size(min = 2, message = "Deve conter ao menos 2 caracteres")
    private String cidade;

    @NotBlank
    @Pattern(regexp = "\\w{2}", message = "Digite somente a sigla do Estado (Ex: CE)")
    private String uf;

    @NotBlank
    @Pattern(regexp = "(^\\d{5})-?(\\d{3}$)", message = "CEP incorreto")
    private String cep;


    public Endereco(EnderecoDto dados) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.cep = dados.cep();
    }

    public void atualizarEndereco(EnderecoDto dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }

        if (dados.numero() != null) {
            this.numero = dados.numero();
        }

        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }

        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }

        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }

        if (dados.uf() != null) {
            this.uf = dados.uf();
        }

        if (dados.cep() != null) {
            this.cep = dados.cep();
        }

    }

}
