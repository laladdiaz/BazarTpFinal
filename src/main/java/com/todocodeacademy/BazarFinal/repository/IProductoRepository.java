
package com.todocodeacademy.BazarFinal.repository;

import com.todocodeacademy.BazarFinal.modal.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository <Producto, Long>{
    
}
