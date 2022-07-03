
package com.todocodeacademy.BazarFinal.repository;

import com.todocodeacademy.BazarFinal.modal.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository <Venta, Long>{
    
}
