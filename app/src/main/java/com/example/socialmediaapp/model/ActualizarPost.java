package com.example.socialmediaapp.model;

public class ActualizarPost {
    private String comentario;
    private String img;

    public ActualizarPost(String comentario, String img) {
        this.comentario = comentario;
        this.img = img;
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
}
