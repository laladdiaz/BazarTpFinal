package com.todocodeacademy.BazarFinal.controller;

import com.todocodeacademy.BazarFinal.dto.TotalVentaDTO;
import com.todocodeacademy.BazarFinal.dto.VentaMayorDTO;
import com.todocodeacademy.BazarFinal.modal.Cliente;
import com.todocodeacademy.BazarFinal.modal.Producto;
import com.todocodeacademy.BazarFinal.modal.Venta;
import com.todocodeacademy.BazarFinal.service.IVentaService;
import java.time.LocalDate;
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
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private IVentaService ventaServ;

    @PostMapping("/crear")
    public String createVenta(@RequestBody Venta venta) {

        ventaServ.saveVenta(venta);

        return "Venta creado correctamente";

    }

    @GetMapping("/listar")
    public List<Venta> listVenta() {

        return ventaServ.getVentas();

    }

    @GetMapping("/buscar/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta) {

        return ventaServ.findVenta(codigo_venta);

    }

    @DeleteMapping("/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta) {

        ventaServ.deleteVenta(codigo_venta);

        return "Venta eliminado correctamente";

    }

    @PutMapping("/editar/{codigo_venta_original}")
    public Venta editVenta(@PathVariable Long codigo_venta_original,
            @RequestParam(required = false,name="id_venta") Long nuevoCodigo,
            @RequestParam(required = false,name="fecha") LocalDate nuevaFecha,
            @RequestParam(required = false,name="lista") List<Producto> nuevaLista,
            @RequestParam(required = false,name="id_cliente") Cliente nuevoCliente) {

        ventaServ.editVenta(codigo_venta_original, nuevoCodigo, nuevaFecha, nuevaLista, nuevoCliente);

        Venta venta = ventaServ.findVenta(nuevoCodigo);

        return venta;
    }
    
    @PutMapping ("/editar")
    public Venta editVenta(@RequestBody Venta ven) {
        ventaServ.editVenta(ven);
        return ventaServ.findVenta(ven.getCodigo_venta());
    }

    @GetMapping("/productos-venta/{codigo_venta}")
    public List<Producto> productosVenta(@PathVariable Long codigo_venta) {

        return ventaServ.productosVenta(codigo_venta);

    }

    @GetMapping("/ventas-diarias/{fecha}")
    public TotalVentaDTO ventasDiarias(@PathVariable String fecha) {

        return ventaServ.ventasDiarias(fecha);

    }

    @GetMapping("/venta-mayor")

    public VentaMayorDTO ventaMayor() {

        return ventaServ.ventaMayor();

    }

  
}
