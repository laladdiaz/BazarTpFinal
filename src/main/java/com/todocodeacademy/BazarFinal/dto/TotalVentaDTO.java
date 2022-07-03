
package com.todocodeacademy.BazarFinal.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class TotalVentaDTO {
    private LocalDate fecha;
    private Double monto = 0.0;
    private int cantidad = 0;

    public TotalVentaDTO() {
    }

    public TotalVentaDTO(LocalDate fecha,Double monto, int cantidad) {
        this.fecha = fecha;
        this.monto = monto;
        this.cantidad= cantidad;
    }
    
    
}
