package com.todocodeacademy.BazarFinal.controller;

import com.todocodeacademy.BazarFinal.modal.Producto;
import com.todocodeacademy.BazarFinal.service.IProductoService;
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
@RequestMapping("/productp")
public class ProductoController {
      @Autowired
    private IProductoService productoServ;
    
    @PostMapping("/crear")
    public String createProducto(@RequestBody Producto producto) {
        
        productoServ.saveProducto(producto);
        
        return "Producto creado correctamente";
        
    }
    
    @GetMapping("/listar")
    public List<Producto> listProductos() {
        
        return productoServ.getProductos();
        
    }
   
    @GetMapping("/buscar/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto) {
        
        return productoServ.findProducto(codigo_producto);
        
    }
    
    @DeleteMapping("/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto) {
        
        productoServ.deleteProducto(codigo_producto);
        
        return "Producto eliminado correctamente";
        
    }
    
    @PutMapping("editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto,
            @RequestParam(required = false, name="id_codigo") Long nuevoCodigo,
            @RequestParam(required = false,name="nombre") String nuevoNombre,
            @RequestParam(required = false,name="marca") String nuevaMarca,
            @RequestParam(required = false,name="costo") Double nuevoCosto,
            @RequestParam(required = false,name="cantidad") Double nuevaCantidad)
    {
        
        productoServ.editProducto(codigo_producto, nuevoCodigo, nuevoNombre,nuevaMarca, nuevoCosto, nuevaCantidad);
        
        Producto producto = productoServ.findProducto(nuevoCodigo);
        
        return producto;
    }
     @PutMapping ("/editar")
    public Producto editProducto(@RequestBody Producto pro) {
        productoServ.editProducto(pro);
        return productoServ.findProducto(pro.getCodigo_producto());
    }
    
    
    
    @GetMapping ("/listar-bajo-stock")
    public List <Producto> listarBajoStock(){
        
        return productoServ.getLowStock();
        
    }
    
    
    
}
