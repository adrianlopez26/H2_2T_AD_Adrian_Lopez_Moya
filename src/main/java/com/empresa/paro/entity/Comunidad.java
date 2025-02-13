// Comunidad.java
package com.empresa.paro.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "comunidad")
public class Comunidad {

    @Id
    @Column(name = "Codigo")
    private String codigo;

    private String comunidad;

    @OneToMany(mappedBy = "comunidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paro> paros;

    // Getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public List<Paro> getParos() {
        return paros;
    }

    public void setParos(List<Paro> paros) {
        this.paros = paros;
    }
}