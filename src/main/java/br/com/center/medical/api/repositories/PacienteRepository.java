package br.com.center.medical.api.repositories;

import br.com.center.medical.api.models.entities.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    // @Query("SELECT obj FROM Paciente obj ORDER BY obj.nome")
    Page<Paciente> findAll(Pageable paginado);

}