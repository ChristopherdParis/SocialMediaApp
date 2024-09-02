package com.example.socialmediaapp.model;

public class LoginResponse {
    private boolean status;
    private int usuario_id;

    public LoginResponse(boolean status, int usuario_id) {
        this.status = status;
        this.usuario_id = usuario_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
}
