package com.sipsoft.licoreria.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@Table(name = "compra")
@SQLDelete(sql = "UPDATE compra SET estadoCompra = 0 WHERE idCompra = ?")
@Where(clause = "estadoCompra = 1")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;
    private String guiaRemisionCompra;
    private Float precioTotalCompra;
    private LocalDate fechaCompra;
    private Float igv;
    private Integer estadoCompra = 1;
    private String tipoCompra;
    private Boolean activo;
    private LocalDateTime fechaActualizacion;
    private LocalDateTime fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProveedor", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idOrden", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private OrdenCompra ordenCompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoPago", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoPago tipoPago;

    public Compra() {
    }

    public Compra(Integer id){
        this.idCompra = id;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getGuiaRemisionCompra() {
        return guiaRemisionCompra;
    }

    public void setGuiaRemisionCompra(String guiaRemisionCompra) {
        this.guiaRemisionCompra = guiaRemisionCompra;
    }

    public Float getPrecioTotalCompra() {
        return precioTotalCompra;
    }

    public void setPrecioTotalCompra(Float precioTotalCompra) {
        this.precioTotalCompra = precioTotalCompra;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Float getIgv() {
        return igv;
    }

    public void setIgv(Float igv) {
        this.igv = igv;
    }

    public Integer getEstadoCompra() {
        return estadoCompra;
    }

    public void setEstadoCompra(Integer estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "Compra [idCompra=" + idCompra + ", guiaRemisionCompra=" + guiaRemisionCompra + ", precioTotalCompra="
                + precioTotalCompra + ", fechaCompra=" + fechaCompra + ", igv=" + igv + ", estadoCompra=" + estadoCompra
                + ", tipoCompra=" + tipoCompra + ", activo=" + activo + ", fechaActualizacion=" + fechaActualizacion
                + ", fechaRegistro=" + fechaRegistro + ", proveedor=" + proveedor + ", ordenCompra=" + ordenCompra
                + ", empresa=" + empresa + ", tipoPago=" + tipoPago + "]";
    }

    
}
