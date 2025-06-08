package com.sipsoft.licoreria.entity;

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
@Table(name = "multi_pago")
public class MultiPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMultiPago;
    private Float montoPagado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVenta", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Venta venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoPago", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoPago tipoPago;

    public MultiPago() {
    }

    public Integer getIdMultiPago() {
        return idMultiPago;
    }

    public void setIdMultiPago(Integer idMultiPago) {
        this.idMultiPago = idMultiPago;
    }

    public Float getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(Float montoPagado) {
        this.montoPagado = montoPagado;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "MultiPago [idMultiPago=" + idMultiPago + ", montoPagado=" + montoPagado + ", venta=" + venta
                + ", tipoPago=" + tipoPago + "]";
    }
}
