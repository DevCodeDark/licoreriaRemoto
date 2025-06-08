package com.sipsoft.licoreria.entity;

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
@Table(name = "unidad_medida")
@SQLDelete(sql = "UPDATE unidad_medida SET estadoUnidadMedida = 0 WHERE idUnidadMedida = ?")
@Where(clause = "estadoUnidadMedida = 1")
public class UnidadMedida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUnidadMedida;
    private String nombreUnidadMedida;
    private String abreviaturaUnidadMedida;
    private Integer estadoUnidadMedida = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;

    public UnidadMedida() {
    }

    public Integer getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getNombreUnidadMedida() {
        return nombreUnidadMedida;
    }

    public void setNombreUnidadMedida(String nombreUnidadMedida) {
        this.nombreUnidadMedida = nombreUnidadMedida;
    }

    public String getAbreviaturaUnidadMedida() {
        return abreviaturaUnidadMedida;
    }

    public void setAbreviaturaUnidadMedida(String abreviaturaUnidadMedida) {
        this.abreviaturaUnidadMedida = abreviaturaUnidadMedida;
    }

    public Integer getEstadoUnidadMedida() {
        return estadoUnidadMedida;
    }

    public void setEstadoUnidadMedida(Integer estadoUnidadMedida) {
        this.estadoUnidadMedida = estadoUnidadMedida;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "UnidadMedida [idUnidadMedida=" + idUnidadMedida + ", nombreUnidadMedida=" + nombreUnidadMedida
                + ", abreviaturaUnidadMedida=" + abreviaturaUnidadMedida + ", estadoUnidadMedida=" + estadoUnidadMedida
                + ", empresa=" + empresa + "]";
    }
}
