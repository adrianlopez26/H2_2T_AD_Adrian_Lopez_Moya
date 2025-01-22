// Paro.java
package com.empresa.paro.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "paro")
public class Paro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador;

    private String sexo;

    private String edad;

    private String periodo;

    @Column(name = "Total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "CodigoComunidad", referencedColumnName = "Codigo")
    private Comunidad comunidad;

    // Getters y setters
    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }
}