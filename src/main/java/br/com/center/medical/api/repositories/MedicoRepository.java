package br.com.center.medical.api.repositories;

import br.com.center.medical.api.models.entities.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAll(Pageable paginado);

    @Modifying
    @Query("UPDATE Medico m SET m.ativo = false WHERE m.id = :id")
    void desativarMedico(Long id);

    @Modifying
    @Query("UPDATE Medico m SET m.ativo = true WHERE m.id = :id")
    void ativarMedico(Long id);

}