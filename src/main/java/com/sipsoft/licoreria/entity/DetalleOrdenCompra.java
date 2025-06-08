package com.sipsoft.licoreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_orden_compra")
@SQLDelete(sql = "UPDATE detalle_orden_compra SET activo = 0 WHERE idDetalleOrden = ?")
@Where(clause = "activo = 1")
public class DetalleOrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleOrden;
    private Boolean activo = true;
    private Integer cantidadSolicitada;
    private String observacionesDetalle;
    private Float precioUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOrden", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private OrdenCompra ordenCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Producto producto;

    public DetalleOrdenCompra() {
    }

    public Integer getIdDetalleOrden() {
        return idDetalleOrden;
    }

    public void setIdDetalleOrden(Integer idDetalleOrden) {
        this.idDetalleOrden = idDetalleOrden;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(Integer cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public String getObservacionesDetalle() {
        return observacionesDetalle;
    }

    public void setObservacionesDetalle(String observacionesDetalle) {
        this.observacionesDetalle = observacionesDetalle;
    }

    public Float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleOrdenCompra [idDetalleOrden=" + idDetalleOrden + ", activo=" + activo + ", cantidadSolicitada="
                + cantidadSolicitada + ", observacionesDetalle=" + observacionesDetalle + ", precioUnitario="
                + precioUnitario + ", ordenCompra=" + ordenCompra + ", producto=" + producto + "]";
    }
}
