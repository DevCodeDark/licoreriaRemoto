package com.sipsoft.licoreria.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimientos_stock")
public class MovimientosStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimientoStock;
    private Integer cantidadMovimientoStock;
    private LocalDateTime fechaMovimientoStock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLote", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Lote lote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoMovimiento", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoMovimientosStock tipoMovimiento;

    public MovimientosStock() {
    }

    public Integer getIdMovimientoStock() {
        return idMovimientoStock;
    }

    public void setIdMovimientoStock(Integer idMovimientoStock) {
        this.idMovimientoStock = idMovimientoStock;
    }

    public Integer getCantidadMovimientoStock() {
        return cantidadMovimientoStock;
    }

    public void setCantidadMovimientoStock(Integer cantidadMovimientoStock) {
        this.cantidadMovimientoStock = cantidadMovimientoStock;
    }

    public LocalDateTime getFechaMovimientoStock() {
        return fechaMovimientoStock;
    }

    public void setFechaMovimientoStock(LocalDateTime fechaMovimientoStock) {
        this.fechaMovimientoStock = fechaMovimientoStock;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public TipoMovimientosStock getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimientosStock tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    @Override
    public String toString() {
        return "MovimientosStock [idMovimientoStock=" + idMovimientoStock + ", cantidadMovimientoStock="
                + cantidadMovimientoStock + ", fechaMovimientoStock=" + fechaMovimientoStock + ", lote=" + lote
                + ", tipoMovimiento=" + tipoMovimiento + "]";
    }
}
