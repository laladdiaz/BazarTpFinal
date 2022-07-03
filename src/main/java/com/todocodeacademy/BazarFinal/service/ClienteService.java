
package com.todocodeacademy.BazarFinal.service;

import com.todocodeacademy.BazarFinal.modal.Cliente;
import com.todocodeacademy.BazarFinal.repository.IClienteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public List<Cliente> getClientes() {
       List<Cliente> listarCliente =clienteRepo.findAll();
       return listarCliente;
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente cli = clienteRepo.findById(id).orElse(null);
        return cli;
    }

    @Override
    public void editCliente(Long id_cliente, Long nuevoId, String nuevoNombre, String nuevoApellido, String nuevoDni) {
        Cliente cliente =  this.findCliente(id_cliente);
        if (nuevoId != null){                                        
            cliente.setId_cliente(nuevoId);
        }
        if (nuevoApellido != null){
            cliente.setApellido(nuevoApellido);
        }
        if (nuevoNombre != null){
            cliente.setNombre(nuevoNombre);
        }
        if (nuevoDni != null){
            cliente.setDni(nuevoDni);
        }
        
        this.saveCliente(cliente);
    }

    @Override
    public void editCliente(Cliente cli) {
        this.saveCliente(cli);
    }
    

       
}
