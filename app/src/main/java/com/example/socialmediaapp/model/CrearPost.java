package com.example.socialmediaapp.model;

public class CrearPost {
    private String comentario;
    private String img;
    private int usuario_id;

    public CrearPost(String comentario, String img, int usuario_id) {
        this.comentario = comentario;
        this.img = img;
        this.usuario_id = usuario_id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
}
