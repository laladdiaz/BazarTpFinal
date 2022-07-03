
package com.todocodeacademy.BazarFinal.repository;

import com.todocodeacademy.BazarFinal.modal.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Long> {
    
}
