package eetac.dsa;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

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

}
