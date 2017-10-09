package eetac.dsa;

import eetac.dsa.Ejemplos.MonstruoEjemplo;
import eetac.dsa.Objetos.Pocion;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestPersonaje {
    Usuario user;

    @Before
    public void creaPersonaje()
    {
        user = new Usuario("pepito","principal",1,1,true,"pepito@gmail.com","pepe");
        user.añadirMonstruo(new MonstruoEjemplo(1,0));
        user.añadirMonstruo(new MonstruoEjemplo(2,0));
        user.añadirMonstruo(new MonstruoEjemplo(3,0));

        user.getInventario().añadirObeto(new Pocion("pocion normal",2));
        user.getInventario().añadirObeto(new Pocion("pocion normal",4));
    }

    @Test
    public void usarObjeto()
    {
        user.obtenerMonstruo(0).setVidaActual(10);
        user.usarObjetoAMonstruo("pocion normal",0);
        assertEquals(1,user.getInventario().obtenerTamaño());

        user.usarObjetoAMonstruo(0,0);
        assertEquals(0,user.getInventario().obtenerTamaño());
    }
}

