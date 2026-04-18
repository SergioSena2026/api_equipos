package com.sena.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private String tipo;
    private String descripcion_falla;
    private String estado;

    //MÉTODOS GET
    public Long getId() {return this.id;}
    public String getMarca() {return this.marca;}
    public String getModelo() {return this.modelo;}
    public String getTipo() {return this.tipo;}
    public String getDescripcion_falla() {return this.descripcion_falla;}
    public String getEstado() {return this.estado;}

    //MÉTODOS SET
    public void setId(Long id) {this.id = id;}
    public void setMarca(String marca) {this.marca = marca;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    public void setDescripcion_falla(String descripcion_falla) {this.descripcion_falla = descripcion_falla;}
    public void setEstado(String estado) {this.estado = estado;}
}
