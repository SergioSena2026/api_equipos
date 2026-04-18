package com.sena.api.controller;

import com.sena.api.entity.Equipo;
import com.sena.api.sevice.EquipoService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {
    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService){
        this.equipoService = equipoService;
    }

    @PostMapping
    public Equipo crear(@RequestBody Equipo equipo){
        return equipoService.guardar(equipo);
    }
    @GetMapping
    public List<Equipo> listar (){
        return equipoService.listar();
    }

    @PutMapping("/{id}")
    public Equipo actualizar(@PathVariable Long id, @RequestBody Equipo equipoDetalles) {
        Equipo equipo = equipoService.buscarPorId(id);

        if (equipo != null) {
            equipo.setMarca(equipoDetalles.getMarca());
            equipo.setModelo(equipoDetalles.getModelo());
            equipo.setTipo(equipoDetalles.getTipo());
            equipo.setDescripcion_falla(equipoDetalles.getDescripcion_falla());
            equipo.setEstado(equipoDetalles.getEstado());
            return equipoService.guardar(equipo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        equipoService.eliminar(id);
    }
}
