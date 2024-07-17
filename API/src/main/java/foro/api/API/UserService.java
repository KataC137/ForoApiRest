package foro.api.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {

    private final ForoRepository foroRepository;

    @Autowired
    public UserService(ForoRepository foroRepository) {
        this.foroRepository = foroRepository;
    }

    public Modelo guardarModelo(Modelo modelo) {

        return foroRepository.save(modelo);
    }

    public List<Modelo> obtenerTodosLosModelos() {
        return List.of();
    }

    public Optional<Modelo> obtenerModeloPorId(Long id) {
        return Optional.empty();
    }

    public void eliminarModeloPorId(Long id) {
    }

    public boolean esModeloReciente(Long id) {

        return false;
    }
}