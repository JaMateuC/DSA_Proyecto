package eetac.dsa;

import static org.junit.Assert.assertEquals;

import eetac.dsa.Objetos.Pocion;
import eetac.dsa.Objetos.PocionExperiencia;
import org.junit.Before;
import org.junit.Test;

public class TestMonstruo {
    Monstruo monstruoTest;
    Monstruo monstruoTestEnemigo;

    @Before
    public void crearMonstruo()
    {
        monstruoTest = new MonstruoEjemplo(2,0);
    }

    @Before
    public void crearMonstruoEnemigo()
    {
        monstruoTestEnemigo = new MonstruoEjemplo(2,0);
    }

    @Test
    public void testAñadirVida()
    {
        monstruoTest.setVidaActual(22);
        monstruoTest.añadirVida(8);
        assertEquals(monstruoTest.getVidaActual(),30);

        monstruoTest.setVidaActual(22);
        monstruoTest.añadirVida(25);
        assertEquals(monstruoTest.getVidaActual(),40);

    }

    @Test
    public void testAñadirExperiencia()
    {
        monstruoTest.añadirExperiencia(20);
        assertEquals(monstruoTest.getExperiencia(),20);
        assertEquals(monstruoTest.getNivel(),2);

        crearMonstruo();
        monstruoTest.añadirExperiencia(200);
        assertEquals(monstruoTest.getExperiencia(),50);
        assertEquals(monstruoTest.getNivel(),4);
    }

    @Test
    public void testRecibirDaño()
    {
        monstruoTest.recibirDaño(50);
        assertEquals(monstruoTest.getVidaActual(),0);
        crearMonstruo();
        monstruoTest.recibirDaño(30);
        assertEquals(monstruoTest.getVidaActual(),16);
    }

    @Test
    public void testAtacar()
    {
        monstruoTest.atacar(monstruoTestEnemigo,1);
        assertEquals(35,monstruoTestEnemigo.getVidaActual());

        crearMonstruo();
        crearMonstruoEnemigo();

        monstruoTest.setVidaActual(34);
        monstruoTest.atacar(monstruoTestEnemigo,2);
        assertEquals(17,monstruoTest.getVidaActual());
        assertEquals(20,monstruoTestEnemigo.getVidaActual());
    }

    @Test
    public void testObjetos()
    {
        monstruoTest.setVidaActual(10);
        monstruoTest.usarObjeto(new Pocion("Pocion pequeña",20));
        assertEquals(30,monstruoTest.getVidaActual());

        monstruoTest.setVidaActual(10);
        monstruoTest.usarObjeto(new Pocion("Pocion Normal",50));
        assertEquals(40,monstruoTest.getVidaActual());

        monstruoTest.usarObjeto(new PocionExperiencia("Pocion de Experiencia Normal",70));
        assertEquals(3,monstruoTest.getNivel());
        assertEquals(10,monstruoTest.getExperiencia());

    }

}
