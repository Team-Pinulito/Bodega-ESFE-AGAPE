package com.example.bodegaesfeagape.Logica_de_Negocio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Activo;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.ActivoBL;

@Controller
@RequestMapping("/activos")
public class ActivoController {

    @Autowired
    private ActivoBL activoBL;

    @GetMapping
    public List<Activo> obtenerTodos() {
        return activoBL.obtenerTodos();
    }

    @GetMapping("/paginados")
    public Page<Activo> buscarTodosPaginados(Pageable pageable) {
        return activoBL.buscarTodosPaginados(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activo> buscarPorId(@PathVariable Integer id) {
        Optional<Activo> activo = activoBL.buscarPorId(id);
        return activo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Activo> crearActivo(@RequestBody Activo activo) {
        Activo nuevoActivo = activoBL.crearOEditar(activo);
        return ResponseEntity.ok(nuevoActivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activo> editarActivo(@PathVariable Integer id, @RequestBody Activo activoDetalles) {
        return activoBL.buscarPorId(id)
                .map(activo -> {
                    activo.setNombre(activoDetalles.getNombre());
                    activo.setDescripcion(activoDetalles.getDescripcion());
                    activo.setEstante(activoDetalles.getEstante());
                    activo.setTipoActivo(activoDetalles.getTipoActivo());
                    activo.setCodigo(activoDetalles.getCodigo());
                    activo.setCodigoDeBarra(activoDetalles.getCodigoDeBarra());
                    Activo activoActualizado = activoBL.crearOEditar(activo);
                    return ResponseEntity.ok(activoActualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Integer id) {
        return activoBL.buscarPorId(id)
                .map(activo -> {
                    activoBL.eliminarPorId(id);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
