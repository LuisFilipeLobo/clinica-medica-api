package br.com.center.medical.api.services;

import br.com.center.medical.api.models.dto.AddMedicoDTO;
import br.com.center.medical.api.models.dto.ListagemMedicosDTO;
import br.com.center.medical.api.models.entities.Medico;
import br.com.center.medical.api.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public void adicionarMedico(AddMedicoDTO dados) {
        medicoRepository.save(new Medico(dados));
    }

    public Page<ListagemMedicosDTO> listarMedicos(Pageable paginado) {
        return medicoRepository.findAll(paginado).map(ListagemMedicosDTO::new);
    }

    public ListagemMedicosDTO buscarMedico(Long id) {
        Medico medico = medicoRepository.getReferenceById(id);

        return new ListagemMedicosDTO(medico);
    }

}
