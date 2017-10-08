package eetac.dsa;
import static org.junit.Assert.assertEquals;

import eetac.dsa.Objetos.Pocion;
import eetac.dsa.Objetos.PocionExperiencia;
import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

public class TestListas {
    @Test
    public void testLista_Monstruos()
    {
        Lista_Monstruos list = new Lista_Monstruos();
        list.añadirMonstruo(new MonstruoEjemplo(1,0));
        list.añadirMonstruo(new MonstruoEjemplo(2,0));
        list.añadirMonstruo(new MonstruoEjemplo(3,0));
        list.añadirMonstruo(new MonstruoEjemplo(4,0));
        list.añadirMonstruo(new MonstruoEjemplo(5,0));
        list.añadirMonstruo(new MonstruoEjemplo(6,0));
        list.añadirMonstruo(new MonstruoEjemplo(7,0));
        assertEquals(6,list.getTamaño());

        list.quitarMonstruoPorPosicion(2);
        assertEquals(5,list.getTamaño());

        Monstruo monstruo = list.obtenerMonstruo(2);
        list.quitarMonstruo(monstruo);
        assertEquals(4,list.getTamaño());
        assertEquals(list.obtenerMonstruo(2).getNivel(),5);
    }

    @Test
    public void testInventario()
    {
        Inventario inventario = new Inventario();
        inventario.añadirObeto(new Pocion("pocion normal",20));
        inventario.añadirObeto(new Pocion("pocion grande",50));
        inventario.añadirObeto(new PocionExperiencia("pocion de experiencia pequeña",10));
        inventario.añadirObeto(new PocionExperiencia("pocion de experiencia normal",30));
        inventario.añadirObeto(new Pocion("pocion super",50));
        inventario.añadirObeto(new PocionExperiencia("pocion de experiencia gigante",900));
        assertEquals(6,inventario.obtenerTamaño());

        Vector<Objeto> pociones = inventario.buscarObjetosPorTipo("Pocion");
        assertEquals(3,pociones.size());

        Objeto obj =inventario.obtenerObjetoPorNombre("pocion normal");
        assertEquals(5,inventario.obtenerTamaño());
        assertEquals("pocion normal",obj.getNombre());

        obj =inventario.buscarObjetoPorNombre("pocion grande");
        assertEquals(5,inventario.obtenerTamaño());
        assertEquals("pocion grande",obj.getNombre());
        assertEquals(null,inventario.buscarObjeto(6));
    }
}
