package com.todocodeacademy.BazarFinal.controller;

import com.todocodeacademy.BazarFinal.modal.Cliente;
import com.todocodeacademy.BazarFinal.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteServ;

    @PostMapping("/crear")
    public String createCliente(@RequestBody Cliente cliente) {

        clienteServ.saveCliente(cliente);

        return "Cliente creado";

    }

    @GetMapping("/listar")
    public List<Cliente> listClientes() {

        return clienteServ.getClientes();

    }
    @GetMapping("/buscar/{id}")
    public Cliente findCliente(@PathVariable Long id) {

        return clienteServ.findCliente(id);

    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteCliente(@PathVariable Long id) {

       clienteServ.deleteCliente(id);

        return "Cliente eliminado";
    }

    @PutMapping("/editar/{id_original}")
    public Cliente editCliente(@PathVariable Long id_original,
            @RequestParam(required = false,name="id_cliente") Long nuevoId,
            @RequestParam(required = false,name="nombre") String nuevoNombre,
            @RequestParam(required = false,name="apellido") String nuevoApellido,
            @RequestParam(required = false,name="dni") String nuevoDni) {

       clienteServ.editCliente(id_original, nuevoId, nuevoNombre, nuevoApellido, nuevoDni);

        Cliente cliente = clienteServ.findCliente(nuevoId);

        return cliente;
    }
    
     @PutMapping ("/editar")
    public Cliente editPersona(@RequestBody Cliente cli) {
        clienteServ.editCliente(cli);
        
        return clienteServ.findCliente(cli.getId_cliente());
    }
    

}
