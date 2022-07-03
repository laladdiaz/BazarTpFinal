
package com.todocodeacademy.BazarFinal.service;

import com.todocodeacademy.BazarFinal.modal.Cliente;
import java.util.List;


public interface IClienteService {
    
    public List <Cliente> getClientes();
    
    public void saveCliente (Cliente cliente);
    
    public void deleteCliente (Long id);
    
    public Cliente findCliente (Long id);
    
     public void editCliente(Cliente cli);
    
    public void editCliente (Long id_cliente, Long nuevoId, String nuevoNombre, String nuevoApellido, String nuevoDni);
}
