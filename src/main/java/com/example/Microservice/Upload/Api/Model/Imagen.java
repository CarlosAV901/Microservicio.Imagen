package com.example.Microservice.Upload.Api.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "imagenes")
public class Imagen {
    @Id
    private String id;
    private String nombre;
    private byte[] datos;
    private String AutorGuid;

    //Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getDatos() {
        return datos;
    }

    public void setDatos(byte[] datos) {
        this.datos = datos;
    }

    public String getAutorGuid() {
        return AutorGuid;
    }

    public void setAutorGuid(String autorGuid) {
        AutorGuid = autorGuid;
    }
}
