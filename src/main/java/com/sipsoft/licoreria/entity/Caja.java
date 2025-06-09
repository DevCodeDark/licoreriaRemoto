package com.sipsoft.licoreria.entity;

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
@Table(name = "caja")
@SQLDelete(sql = "UPDATE caja SET estadoCaja = 0 WHERE idCaja = ?")
@Where(clause = "estadoCaja = 1")
public class Caja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCaja;
    private String numCaja;
    private Float montoinicialCaja;
    private Float montofinalCaja;
    private LocalDateTime fechaaperturaCaja;
    private LocalDateTime fechacierreCaja;
    private Integer estadoCaja = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSucursal")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Sucursal sucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuarioApertura")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuarioApertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuarioCierre")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuarioCierre;

    public Caja() {
    }

    public Caja(Integer id) {
        this.idCaja = id;
    }

    public Integer getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(Integer idCaja) {
        this.idCaja = idCaja;
    }

    public String getNumCaja() {
        return numCaja;
    }

    public void setNumCaja(String numCaja) {
        this.numCaja = numCaja;
    }

    public Float getMontoinicialCaja() {
        return montoinicialCaja;
    }

    public void setMontoinicialCaja(Float montoinicialCaja) {
        this.montoinicialCaja = montoinicialCaja;
    }

    public Float getMontofinalCaja() {
        return montofinalCaja;
    }

    public void setMontofinalCaja(Float montofinalCaja) {
        this.montofinalCaja = montofinalCaja;
    }

    public LocalDateTime getFechaaperturaCaja() {
        return fechaaperturaCaja;
    }

    public void setFechaaperturaCaja(LocalDateTime fechaaperturaCaja) {
        this.fechaaperturaCaja = fechaaperturaCaja;
    }

    public LocalDateTime getFechacierreCaja() {
        return fechacierreCaja;
    }

    public void setFechacierreCaja(LocalDateTime fechacierreCaja) {
        this.fechacierreCaja = fechacierreCaja;
    }

    public Integer getEstadoCaja() {
        return estadoCaja;
    }

    public void setEstadoCaja(Integer estadoCaja) {
        this.estadoCaja = estadoCaja;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Usuario getUsuarioApertura() {
        return usuarioApertura;
    }

    public void setUsuarioApertura(Usuario usuarioApertura) {
        this.usuarioApertura = usuarioApertura;
    }

    public Usuario getUsuarioCierre() {
        return usuarioCierre;
    }

    public void setUsuarioCierre(Usuario usuarioCierre) {
        this.usuarioCierre = usuarioCierre;
    }

    @Override
    public String toString() {
        return "Caja [idCaja=" + idCaja + ", numCaja=" + numCaja + ", montoinicialCaja=" + montoinicialCaja
                + ", montofinalCaja=" + montofinalCaja + ", fechaaperturaCaja=" + fechaaperturaCaja
                + ", fechacierreCaja=" + fechacierreCaja + ", estadoCaja=" + estadoCaja + ", sucursal=" + sucursal
                + ", usuarioApertura=" + usuarioApertura + ", usuarioCierre=" + usuarioCierre + "]";
    }

    
}
