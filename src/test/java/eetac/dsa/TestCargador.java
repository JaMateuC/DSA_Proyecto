package eetac.dsa;

import eetac.dsa.Excepciones.CargarDeJsonException;
import eetac.dsa.Monstruos.MonstruoEjemplo;
import eetac.dsa.Objetos.CarameloRaro;
import eetac.dsa.Objetos.PiedraTeleport;
import eetac.dsa.Objetos.Pocion;
import eetac.dsa.Objetos.PocionExperiencia;
import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;
import java.util.HashMap;

public class TestCargador {
    @Test
    public void cargarEscenario()
    {
        try {
            Escenario esc = CargadorJSON.jsonAEscenario(CargadorJSON.ficheroAJSON("src/test/resources/escenarioDePrueba.json"));
        }
        catch (CargarDeJsonException|IOException e)
        {
            throw new AssertionError();
        }
    }

    @Test
    public void cargarPersonajes()
    {
        try {
            HashMap<String,Personaje> personajes = CargadorJSON.jsonAPersonajes(CargadorJSON.ficheroAJSON("src/test/resources/Personajes.json"));
        }
        catch (CargarDeJsonException|IOException e)
        {
            throw new AssertionError();
        }
    }

    @Test
    public void cargarPersonaje()
    {
        try {
            Personaje personaje = CargadorJSON.jsonAPersonaje(CargadorJSON.ficheroAJSON("src/test/resources/Personaje.json"));
        }
        catch (CargarDeJsonException|IOException e)
        {
            throw new AssertionError();
        }
    }

    @Test
    public void cargarObjeto()
    {
        try {
            Objeto objeto = CargadorJSON.jsonAObjeto(CargadorJSON.ficheroAJSON("src/test/resources/Objeto.json"));
        }
        catch (CargarDeJsonException|IOException e)
        {
            throw new AssertionError();
        }
    }

    @Test
    public void cargarMonstruo()
    {
        try {
            Monstruo monstruo = CargadorJSON.jsonAMonstruo(CargadorJSON.ficheroAJSON("src/test/resources/Monstruo.json"));
        }
        catch (CargarDeJsonException|IOException e)
        {
            throw new AssertionError();
        }
    }

    @Test
    public void ObjetoAJson()
    {
        try {
            Assert.assertTrue(CargadorJSON.ficheroAJSON("src/test/resources/Objeto.json").equals(CargadorJSON.objetoAJSON(new Pocion("Pocion pequeña",200))));
            Assert.assertTrue("{\"tipo\":\"CarameloRaro\"}".equals(CargadorJSON.objetoAJSON(new CarameloRaro())));
        }
        catch (CargarDeJsonException|IOException e)
        {
            throw new AssertionError();
        }
    }

    @Test
    public void MonstruoAJson()
    {
        try {
            Assert.assertTrue(CargadorJSON.ficheroAJSON("src/test/resources/Monstruo.json").equals(CargadorJSON.monstruoAJson(new MonstruoEjemplo(1,50))));
        }
        catch (CargarDeJsonException|IOException e)
        {
            throw new AssertionError();
        }
    }

    @Test
    public void personajeAJson()
    {
        try {
            Usuario usuario = new Usuario("juan",0,0,true,"oscarmampel@hotmail.com","oscar");
            usuario.añadirMonstruo(new MonstruoEjemplo(1,50));
            usuario.añadirMonstruo(new MonstruoEjemplo(2,100));
            usuario.añadirMonstruo(new MonstruoEjemplo(3,200));
            usuario.getInventario().añadirObeto(new Pocion("Pocion pequeña",200));
            usuario.getInventario().añadirObeto(new PocionExperiencia("Pocion pequeña",20));
            usuario.getInventario().añadirObeto(new PiedraTeleport(1,2,"escenarioDePrueba"));
            Assert.assertTrue(CargadorJSON.ficheroAJSON("src/test/resources/Personaje.json").equals(CargadorJSON.personajeAJson(usuario)));
        }
        catch (CargarDeJsonException|IOException e)
        {
            throw new AssertionError();
        }
    }


}