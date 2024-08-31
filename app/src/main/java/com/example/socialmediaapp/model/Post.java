package com.example.socialmediaapp.model;

import java.util.Date;
import java.util.List;

public class Post {
    private int post_id;
    private String comentario;
    private String path_img;
    private String created_at;
    private int usuario_id;
    private String nombre;
    private String email;

    public Post(int post_id, String comentario, String path_img, String created_at, int usuario_id, String nombre, String email) {
        this.post_id = post_id;
        this.comentario = comentario;
        this.path_img = path_img;
        this.created_at = created_at;
        this.usuario_id = usuario_id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getPath_img() {
        return path_img;
    }

    public void setPath_img(String path_img) {
        this.path_img = path_img;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
