package com.todocodeacademy.BazarFinal.service;

import com.todocodeacademy.BazarFinal.dto.TotalVentaDTO;
import com.todocodeacademy.BazarFinal.dto.VentaMayorDTO;
import com.todocodeacademy.BazarFinal.modal.Cliente;
import com.todocodeacademy.BazarFinal.modal.Producto;
import com.todocodeacademy.BazarFinal.modal.Venta;
import com.todocodeacademy.BazarFinal.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;

    @Autowired
    private IProductoService productoService;

    @Override
    public List<Venta> getVentas() {
        List<Venta> ventas = ventaRepo.findAll();
        return ventas;
    }

    @Override
    public void saveVenta(Venta venta) {
        venta.setTotal(0.0);
        for (Producto prod : venta.getListaProductos()) {
            Producto aux = productoService.findProducto(prod.getCodigo_producto());
            venta.setTotal(venta.getTotal() + aux.getCosto());
        }

        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public Venta findVenta(Long id) {
        Venta venta = ventaRepo.findById(id).orElse(null);
        return venta;
    }

    @Override
    public void editVenta(Long codigo_venta, Long nuevoCodigo, LocalDate nuevaFecha, List<Producto> nuevaListaProductos, Cliente nuevoCliente) {
        Venta venta = this.findVenta(codigo_venta);
        if (nuevoCodigo != null) {
            venta.setCodigo_venta(nuevoCodigo);
        }
        if (nuevaFecha != null) {
            venta.setFecha_venta(nuevaFecha);
        }
        if (nuevaListaProductos != null) {
            venta.setListaProductos(nuevaListaProductos);
        }
        if (nuevoCliente != null) {
            venta.setUnCliente(nuevoCliente);
        }
        this.saveVenta(venta);
    }

    @Override
    public List<Producto> productosVenta(Long id) {
        Venta venta = this.findVenta(id);
        List<Producto> lista = venta.getListaProductos();
        return lista;
    }

   
    @Override
    public TotalVentaDTO ventasDiarias(String fecha) {
        List<Venta> ventas = this.getVentas();
        LocalDate fechaParseada;
        TotalVentaDTO totalVenta = new TotalVentaDTO();
        fechaParseada = LocalDate.parse(fecha);
        totalVenta.setFecha(fechaParseada);
        for (Venta venta : ventas) {
            if (venta.getFecha_venta().isEqual(fechaParseada)) {
                totalVenta.setMonto(totalVenta.getMonto() + venta.getTotal());
                totalVenta.setCantidad(totalVenta.getCantidad() + 1);
            }

        }
        return totalVenta;

    }

    @Override
    public VentaMayorDTO ventaMayor() {
          Venta aux = new Venta();
        VentaMayorDTO ventaMayorDTO = new VentaMayorDTO();
        List<Venta> ventas = this.getVentas();
        Double total = ventas.get(0).getTotal();       
        for (Venta venta : ventas) {
            if (venta.getTotal() >= total) {
                total = venta.getTotal();                     
                aux = venta;                                  
            }
        }
        ventaMayorDTO.setCodigo_venta(aux.getCodigo_venta());
        ventaMayorDTO.setMonto(aux.getTotal());
        total = cantidadProductos(aux);                 
        ventaMayorDTO.setCantidad_productos(total);
        ventaMayorDTO.setApellido_cliente(aux.getUnCliente().getApellido());
        ventaMayorDTO.setNombre_cliente(aux.getUnCliente().getNombre());
        
        
        return ventaMayorDTO;
    }
    
    public Double cantidadProductos(Venta venta){
        List <Producto>  listaProductos = venta.getListaProductos();
        Double cantidad = 0.0;
        for (Producto listaProducto : listaProductos) {
            cantidad= cantidad + 1;
        }
        return cantidad;
    }

    @Override
    public void editVenta(Venta ven) {
        this.saveVenta(ven);
    }

   

}
