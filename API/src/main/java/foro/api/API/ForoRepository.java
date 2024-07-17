package foro.api.API;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ForoRepository extends JpaRepository<Modelo, Long> {

}