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
@Table(name = "serie_comprobante")
@SQLDelete(sql = "UPDATE serie_comprobante SET estadoSerie = 0 WHERE idSerie = ?")
@Where(clause = "estadoSerie = 1")
public class SerieComprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSerie;
    private String numSerie;
    private Integer estadoSerie = 1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoComprobante")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoComprobante tipoComprobante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresa empresa;

    public SerieComprobante() {
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public Integer getEstadoSerie() {
        return estadoSerie;
    }

    public void setEstadoSerie(Integer estadoSerie) {
        this.estadoSerie = estadoSerie;
    }

    public TipoComprobante getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(TipoComprobante tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "SerieComprobante [idSerie=" + idSerie + ", numSerie=" + numSerie + ", estadoSerie=" + estadoSerie
                + ", tipoComprobante=" + tipoComprobante + ", empresa=" + empresa + "]";
    }
}
