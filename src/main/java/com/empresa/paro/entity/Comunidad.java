package com.empresa.paro.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Comunidad {

    @Id
    private String codigo; // Código de la comunidad (PK)

    @Column(nullable = false)
    private String comunidad; // Nombre de la comunidad

    // Relación OneToMany: una comunidad puede tener múltiples registros de paro
    @OneToMany(mappedBy = "comunidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paro> paroList;

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

    public List<Paro> getParoList() {
        return paroList;
    }

    public void setParoList(List<Paro> paroList) {
        this.paroList = paroList;
    }
}
