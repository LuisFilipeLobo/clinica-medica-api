package br.com.center.medical.api.repositories;

import br.com.center.medical.api.models.entities.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    // @Query("SELECT obj FROM Paciente obj ORDER BY obj.nome")
    Page<Paciente> findAll(Pageable paginado);

    @Modifying
    @Query("UPDATE Paciente p SET p.ativo = false WHERE p.id = :id")
    void desativarPaciente(Long id);

    @Modifying
    @Query("UPDATE Paciente p SET p.ativo = true WHERE p.id = :id")
    void ativarPaciente(Long id);

}