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
@Table(name = "traslado")
@SQLDelete(sql = "UPDATE traslado SET estadoTraslado = 0 WHERE idTraslado = ?")
@Where(clause = "estadoTraslado = 1")
public class Traslado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTraslado;
    private LocalDateTime fechaTraslado;
    private Integer estadoTraslado = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAlmacenOrigen")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Almacen idAlmacenOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAlmacenDestino")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Almacen idAlmacenDestino;

    public Traslado() {
    }

    public Integer getIdTraslado() {
        return idTraslado;
    }

    public void setIdTraslado(Integer idTraslado) {
        this.idTraslado = idTraslado;
    }

    public LocalDateTime getFechaTraslado() {
        return fechaTraslado;
    }

    public void setFechaTraslado(LocalDateTime fechaTraslado) {
        this.fechaTraslado = fechaTraslado;
    }

    public Integer getEstadoTraslado() {
        return estadoTraslado;
    }

    public void setEstadoTraslado(Integer estadoTraslado) {
        this.estadoTraslado = estadoTraslado;
    }

    public Almacen getIdAlmacenOrigen() {
        return idAlmacenOrigen;
    }

    public void setIdAlmacenOrigen(Almacen idAlmacenOrigen) {
        this.idAlmacenOrigen = idAlmacenOrigen;
    }

    public Almacen getIdAlmacenDestino() {
        return idAlmacenDestino;
    }

    public void setIdAlmacenDestino(Almacen idAlmacenDestino) {
        this.idAlmacenDestino = idAlmacenDestino;
    }

    @Override
    public String toString() {
        return "Traslado [idTraslado=" + idTraslado + ", fechaTraslado=" + fechaTraslado + ", estadoTraslado="
                + estadoTraslado + ", idAlmacenOrigen=" + idAlmacenOrigen + ", idAlmacenDestino=" + idAlmacenDestino
                + "]";
    }
}
