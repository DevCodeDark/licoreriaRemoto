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
@Table(name = "proveedor_categoria")
public class ProveedorCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedorCategoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProveedor", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria categoria;

    public ProveedorCategoria() {
    }

    public Integer getIdProveedorCategoria() {
        return idProveedorCategoria;
    }

    public void setIdProveedorCategoria(Integer idProveedorCategoria) {
        this.idProveedorCategoria = idProveedorCategoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ProveedorCategoria [idProveedorCategoria=" + idProveedorCategoria + ", proveedor=" + proveedor
                + ", categoria=" + categoria + "]";
    }
}
