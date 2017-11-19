package eetac.dsa;

import eetac.dsa.Servidor.Controlador.Monstruos.MonstruoEjemplo;
import eetac.dsa.Servidor.Controlador.Objetos.Pocion;
import eetac.dsa.Servidor.Controlador.Usuario;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPersonaje {
    Usuario user;

    @Before
    public void creaPersonaje()
    {
        user = new Usuario("pepito",1,1,true,"pepito@gmail.com","pepe");
        user.añadirMonstruo(new MonstruoEjemplo(1,0));
        user.añadirMonstruo(new MonstruoEjemplo(2,0));
        user.añadirMonstruo(new MonstruoEjemplo(3,0));

        user.getInventario().añadirObeto(new Pocion("pocion normal",2));
        user.getInventario().añadirObeto(new Pocion("pocion normal",4));
    }
}

