package com.sipsoft.licoreria.entity;

import java.time.LocalDateTime;

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
@Table(name = "notificaciones")
@SQLDelete(sql = "UPDATE notificaciones SET estadoNotificacion = 0 WHERE idNotificacion = ?")
@Where(clause = "estadoNotificacion = 1")
public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotificacion;
    private LocalDateTime fechaNotificacion;
    private String mensaje;
    private Integer estadoNotificacion = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idContratoProveedor", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ContratoProveedor contratoProveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoNotificacion", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoNotificaciones tipoNotificacion;

    public Notificaciones() {
    }

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public LocalDateTime getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(LocalDateTime fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getEstadoNotificacion() {
        return estadoNotificacion;
    }

    public void setEstadoNotificacion(Integer estadoNotificacion) {
        this.estadoNotificacion = estadoNotificacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ContratoProveedor getContratoProveedor() {
        return contratoProveedor;
    }

    public void setContratoProveedor(ContratoProveedor contratoProveedor) {
        this.contratoProveedor = contratoProveedor;
    }

    public TipoNotificaciones getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(TipoNotificaciones tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    @Override
    public String toString() {
        return "Notificaciones [idNotificacion=" + idNotificacion + ", fechaNotificacion=" + fechaNotificacion
                + ", mensaje=" + mensaje + ", estadoNotificacion=" + estadoNotificacion + ", producto=" + producto
                + ", contratoProveedor=" + contratoProveedor + ", tipoNotificacion=" + tipoNotificacion + "]";
    }
}
