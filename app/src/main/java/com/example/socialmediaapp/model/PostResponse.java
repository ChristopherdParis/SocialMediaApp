package com.example.socialmediaapp.model;

import java.util.List;

public class PostResponse {
    private boolean status;
    private List<Post> publicaciones;

    public PostResponse(boolean status, List<Post> publicaciones) {
        this.status = status;
        this.publicaciones = publicaciones;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Post> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Post> publicaciones) {
        this.publicaciones = publicaciones;
    }
}
