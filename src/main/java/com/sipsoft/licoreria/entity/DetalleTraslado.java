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
@Table(name = "detalle_traslado")
public class DetalleTraslado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleTraslado;
    private Integer cantidadTraslado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTraslado", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Traslado traslado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLote", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Lote lote;

    public DetalleTraslado() {
    }

    public Integer getIdDetalleTraslado() {
        return idDetalleTraslado;
    }

    public void setIdDetalleTraslado(Integer idDetalleTraslado) {
        this.idDetalleTraslado = idDetalleTraslado;
    }

    public Integer getCantidadTraslado() {
        return cantidadTraslado;
    }

    public void setCantidadTraslado(Integer cantidadTraslado) {
        this.cantidadTraslado = cantidadTraslado;
    }

    public Traslado getTraslado() {
        return traslado;
    }

    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    @Override
    public String toString() {
        return "DetalleTraslado [idDetalleTraslado=" + idDetalleTraslado + ", cantidadTraslado=" + cantidadTraslado
                + ", traslado=" + traslado + ", lote=" + lote + "]";
    }
}
