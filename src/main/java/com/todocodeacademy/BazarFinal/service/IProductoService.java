
package com.todocodeacademy.BazarFinal.service;

import com.todocodeacademy.BazarFinal.modal.Producto;
import java.util.List;


public interface IProductoService {
    
    public List <Producto> getProductos();
    
    public void saveProducto (Producto producto);
    
    public void deleteProducto (Long id);
    
    public Producto findProducto (Long id);
    
    public void editProducto ( Long codigo_producto, Long nuevoCodigo, String nuevoNombre, String nuevaMarca, Double nuevoCosto,  Double nuevaCantidad);
    
    public void editProducto(Producto pro);
    
    public List <Producto> getLowStock ();
}
