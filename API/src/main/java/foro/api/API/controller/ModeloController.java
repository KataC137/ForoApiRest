package foro.api.API.controller;


import foro.api.API.Modelo;
import foro.api.API.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modelos")

public class ModeloController {

    private final UserService modeloService;

    @Autowired
    public ModeloController(UserService modeloService) {
        this.modeloService = modeloService;
    }

    // Endpoint para obtener todos los modelos
    @GetMapping
    public ResponseEntity<List<Modelo>> obtenerTodosLosModelos() {
        List<Modelo> modelos = modeloService.obtenerTodosLosModelos();
        return ResponseEntity.ok(modelos);
    }

    // Endpoint para obtener un modelo por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Modelo> obtenerModeloPorId(@PathVariable Long id) {
        Optional<Modelo> modelo = modeloService.obtenerModeloPorId(id);
        return modelo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para crear un nuevo modelo
    @PostMapping
    public ResponseEntity<Modelo> crearModelo(@RequestBody Modelo modelo) {
        Modelo nuevoModelo = modeloService.guardarModelo(modelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoModelo);
    }

    // Endpoint para eliminar un modelo por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarModelo(@PathVariable Long id) {
        modeloService.eliminarModeloPorId(id);
        return ResponseEntity.noContent().build();
    }

    // Ejemplo de un endpoint adicional que utiliza lógica de negocio de ModeloService
    @GetMapping("/{id}/es-reciente")
    public ResponseEntity<Boolean> esModeloReciente(@PathVariable Long id) {
        boolean esReciente = modeloService.esModeloReciente(id);
        return ResponseEntity.ok(esReciente);
    }
}


