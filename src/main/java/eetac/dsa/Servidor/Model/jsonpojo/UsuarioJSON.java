package eetac.dsa.Servidor.Model.jsonpojo;

import eetac.dsa.Servidor.Controlador.Monstruo;
import eetac.dsa.Servidor.Controlador.Objeto;
import eetac.dsa.Servidor.Controlador.Usuario;

import java.util.ArrayList;
import java.util.Collections;
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



    public Usuario toUsario()throws Exception
    {
        Usuario usuario = new Usuario(nombre,x,y,genero,email,password);
        for(int i =0;i<monstruo.length;i++)
        {
            usuario.añadirMonstruo(monstruo[i].toMonstruo());
        }
        for(int i =0;i<inventario.length;i++)
        {
            usuario.getInventario().añadirObeto(inventario[i].toObjeto());
        }
        return usuario;
    }

    public void fromUsuario(Usuario usuario) throws Exception
    {
        this.email = usuario.getEmail();
        this.genero = usuario.getGenero();
        this.nombre = usuario.getNombre();
        this.password = usuario.getPassword();
        if(usuario.getPosicion()!=null) {
            this.x = (int) usuario.getPosicion().getX();
            this.y = (int) usuario.getPosicion().getY();
        }
        this.inventario = new ObjetoJSON[usuario.getInventario().obtenerTamaño()];
        this.monstruo = new MonstruoJSON[usuario.getLista_montruos().getTamaño()];
        for(int i =0;i<inventario.length;i++)
        {
            ObjetoJSON obj = new ObjetoJSON();
            obj.fromObjeto(usuario.getInventario().buscarObjeto(i));
            inventario[i] = obj;
        }

        for(int i =0;i<monstruo.length;i++)
        {
            MonstruoJSON obj = new MonstruoJSON();
            obj.fromMonstruo(usuario.getLista_montruos().getMonstruo(i));
            monstruo[i] = obj;
        }
    }
}
