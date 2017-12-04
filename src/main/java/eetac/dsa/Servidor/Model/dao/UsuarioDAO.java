package eetac.dsa.Servidor.Model.dao;

import eetac.dsa.Servidor.Controlador.Objetos.OrdenParametro;

public class UsuarioDAO {

    @OrderFields(indice = 0)
    private String nombre;
    @OrderFields(indice = 1)
    private String password;
    @OrderFields(indice = 2)
    private int x;
    @OrderFields(indice = 3)
    private int y;
    @OrderFields(indice = 4)
    private boolean genero;


    public UsuarioDAO() {
    }

    @OrderMethods(indice = 0)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OrderMethods(indice = 1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OrderMethods(indice = 2)
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @OrderMethods(indice = 3)
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @OrderMethods(indice = 4)
    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
}
