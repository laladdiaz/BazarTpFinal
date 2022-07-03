package com.todocodeacademy.BazarFinal.service;

import com.todocodeacademy.BazarFinal.modal.Producto;
import com.todocodeacademy.BazarFinal.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public List<Producto> getProductos() {
       List<Producto> listarProductos =productoRepo.findAll();
       return listarProductos;
    }

    

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
         productoRepo.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        Producto producto = productoRepo.findById(id).orElse(null);
        return producto;
    }

    @Override
    public void editProducto(Long codigo_producto, Long nuevoCodigo, String nuevoNombre, String nuevaMarca, Double nuevoCosto, Double nuevaCantidad) {
        Producto producto = this.findProducto(codigo_producto);
        if (nuevoCodigo != null) {
            producto.setCodigo_producto(nuevoCodigo);
        }
        if (nuevoNombre != null) {
            producto.setNombre(nuevoNombre);
        }
        if (nuevaMarca != null) {
            producto.setMarca(nuevaMarca);
        }
        if (nuevoCosto != null) {
            producto.setCosto(nuevoCosto);
        }
        if (nuevaCantidad != null) {
            producto.setCantidad_disponible(nuevaCantidad);
        }
        
        this.saveProducto(producto);
    }

    @Override
    public List<Producto> getLowStock() {
        List<Producto> lista = this.getProductos();
        List<Producto> low = new ArrayList();
        for (Producto prod : lista) {
            if (prod.getCantidad_disponible() < 5) {
                low.add(prod);
            }

        }
        return low;
    }

    @Override
    public void editProducto(Producto pro) {
         this.saveProducto(pro);
    }
}
