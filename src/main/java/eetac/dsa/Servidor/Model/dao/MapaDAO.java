package eetac.dsa.Servidor.Model.dao;

import eetac.dsa.Servidor.Controlador.Objetos.OrdenParametro;

public class MapaDAO {

    @OrderFields(indice = 0)
    private String nom;
    @OrderFields(indice = 1)
    private String direccioFile;
    @OrderFields(indice = 2)
    private String nomUsuario;

    public MapaDAO() {
    }

    @OrderMethods(indice = 0)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @OrderMethods(indice = 1)
    public String getDireccioFile() {
        return direccioFile;
    }

    public void setDireccioFile(String direccioFile) {
        this.direccioFile = direccioFile;
    }

    @OrderMethods(indice = 2)
    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }
}
