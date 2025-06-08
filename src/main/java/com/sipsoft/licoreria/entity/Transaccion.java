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
@Table(name = "transaccion")
@SQLDelete(sql = "UPDATE transaccion SET estado = 0 WHERE idTransaccion = ?")
@Where(clause = "estado = 1")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTransaccion;
    private String motivoTransaccion;
    private Float montoTransaccion;
    private String tipo;
    private Integer estado = 1;
    private LocalDateTime fechaTransaccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoPago", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoPago tipoPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCaja", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Caja caja;

    public Transaccion() {
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getMotivoTransaccion() {
        return motivoTransaccion;
    }

    public void setMotivoTransaccion(String motivoTransaccion) {
        this.motivoTransaccion = motivoTransaccion;
    }

    public Float getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(Float montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    @Override
    public String toString() {
        return "Transaccion [idTransaccion=" + idTransaccion + ", motivoTransaccion=" + motivoTransaccion
                + ", montoTransaccion=" + montoTransaccion + ", tipo=" + tipo + ", estado=" + estado
                + ", fechaTransaccion=" + fechaTransaccion + ", tipoPago=" + tipoPago + ", usuario=" + usuario
                + ", caja=" + caja + "]";
    }
}
