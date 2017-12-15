package eetac.dsa.Servidor.Model.jsonpojo;

import eetac.dsa.Servidor.Model.dao.UsuarioDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsuarioJSON
{
    private ObjetoJSON[] inventario;
    private MonstruoJSON[] monstruo;
    private ArrayList<ObjetoJSON> inventariol;
    private ArrayList<MonstruoJSON> monstruosl;
    private String nombre;
    private String password;
    private String email;
    private int x;
    private int y;
    private boolean genero;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
//

    public ArrayList<ObjetoJSON> getInventariol() {
        return inventariol;
    }

    public void setInventariol(ArrayList<ObjetoJSON> inventariol) {
        this.inventariol = inventariol;
    }

    public ArrayList<MonstruoJSON> getMonstruosl() {
        return monstruosl;
    }

    public void setMonstruosl(ArrayList<MonstruoJSON> monstruosl) {
        this.monstruosl = monstruosl;
    }

    public UsuarioJSON(ArrayList<ObjetoJSON> inventariol, ArrayList<MonstruoJSON> monstruosl, String nombre, String password, String email, boolean genero) {
        this.inventariol = inventariol;
        this.monstruosl = monstruosl;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.genero = genero;
    }

//


    public UsuarioJSON() { }

    public UsuarioJSON(String nombre, String password, String email, int x, int y, boolean genero) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.x = x;
        this.y = y;
        this.genero = genero;
    }

    public ObjetoJSON[] getInventario() {
        return inventario;
    }

    public void setInventario(ObjetoJSON[] inventario) {
        this.inventario = inventario;
    }

    public MonstruoJSON[] getMonstruo() {
        return monstruo;
    }

    public void setMonstruo(MonstruoJSON[] monstruo) {
        this.monstruo = monstruo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Comparator<UsuarioJSON> Productoventascomparator
            = new Comparator<UsuarioJSON>() {

        public int compare(UsuarioJSON u1, UsuarioJSON u2) {



            return u1.getMonstruosl().size()-u2.getMonstruosl().size();

        }

    };

    public void parseFromDB(UsuarioDAO usuario){

        this.setNombre(usuario.getId());
        this.setGenero(usuario.getGenero());
        this.setPassword(usuario.getPassword());
        this.setX(usuario.getX());
        this.setY(usuario.getY());

    }
}
