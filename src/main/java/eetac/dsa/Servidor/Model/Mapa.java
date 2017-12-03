package eetac.dsa.Servidor.Model;

public class Mapa {

    private String iD;
    private String nombre;
    private String direccionFile;

    public Mapa() {
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionFile() {
        return direccionFile;
    }

    public void setDireccionFile(String direccionFile) {
        this.direccionFile = direccionFile;
    }
}
