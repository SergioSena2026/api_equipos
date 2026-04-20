package com.sena.api.controller;

import com.sena.api.entity.Cliente;
import com.sena.api.entity.Equipo;
import com.sena.api.sevice.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController (ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente){
        return clienteService.guardar(cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @PutMapping("/{id}")
    public Cliente actualizar (@PathVariable Long id, @RequestBody Cliente clienteDetalles) {
        Cliente cliente = clienteService.buscarPorId(id);

        if (cliente != null) {
            cliente.setNombre(clienteDetalles.getNombre());
            cliente.setApellido(clienteDetalles.getApellido());
            cliente.setTelefono(clienteDetalles.getTelefono());
            return clienteService.guardar(cliente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        clienteService.eliminar(id);
    }

}
