package com.empresa.paro.entity;

import jakarta.persistence.*;

@Entity
public class Paro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identificador; // Identificador único (PK)

    private String sexo;       // Sexo del desempleado
    private String edad;       // Grupo de edad
    private String periodo;    // Periodo (por ejemplo, 2023-Q1)
    private double total;      // Total de desempleados

    // Relación ManyToOne: un registro de paro pertenece a una comunidad
    @ManyToOne
    @JoinColumn(name = "codigoComunidad", nullable = false)
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

