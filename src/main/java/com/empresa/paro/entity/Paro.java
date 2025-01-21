package com.empresa.paro.entity;

import jakarta.persistence.*;

@Entity
public class Paro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identificador;

    @Column(name = "Sexo")
    private String sexo;

    @Column(name = "Edad")
    private String edad;

    @Column(name = "Periodo")
    private String periodo;

    @Column(name = "Total")
    private double total;

    @ManyToOne
    @JoinColumn(name = "CodigoComunidad", referencedColumnName = "Codigo")
    private Comunidad comunidad;

    // Getters y setters
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }
}
