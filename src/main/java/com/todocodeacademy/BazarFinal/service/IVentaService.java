package com.todocodeacademy.BazarFinal.service;

import com.todocodeacademy.BazarFinal.dto.TotalVentaDTO;
import com.todocodeacademy.BazarFinal.dto.VentaMayorDTO;
import com.todocodeacademy.BazarFinal.modal.Cliente;
import com.todocodeacademy.BazarFinal.modal.Producto;
import com.todocodeacademy.BazarFinal.modal.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();

    public void saveVenta(Venta venta);

    public void deleteVenta(Long id);

    public Venta findVenta(Long id);

    public void editVenta(Long codigo_venta, Long nuevoCodigo, LocalDate nuevaFecha, List<Producto> nuevaListaProductos, Cliente nuevoCliente);

    public void editVenta(Venta ven);

    public List<Producto> productosVenta(Long id);

    public TotalVentaDTO ventasDiarias(String fecha);

    public VentaMayorDTO ventaMayor();

}
