package eetac.dsa;

import eetac.dsa.Ejemplos.MonstruoEjemplo;
import eetac.dsa.Objetos.Pocion;
import eetac.dsa.Objetos.PocionExperiencia;

import java.util.Vector;
//TODO(a medida que creemos objetos y monstruos hay que añadirlos en el creadorAleatorio)
public class CreadorAleatori
{
    static Objeto crearObjeto(int rango)
    {
        Vector<Objeto> listaObjetosAparecibles = new Vector<Objeto>();
        switch (rango)
        {
            case 0:
                listaObjetosAparecibles.add(new Pocion("Pocion Pequeña",20));
                listaObjetosAparecibles.add(new PocionExperiencia("Pocion de Experiencia Pequeña",20));
                break;

            case 1:
                listaObjetosAparecibles.add(new Pocion("Pocion",100));
                listaObjetosAparecibles.add(new PocionExperiencia("Pocion de Experiencia",100));
                break;

            case 2:
                listaObjetosAparecibles.add(new Pocion("Pocion Mediana",200));
                listaObjetosAparecibles.add(new PocionExperiencia("Pocion de Experiencia Mediana",200));
                break;

            case 3:
                listaObjetosAparecibles.add(new Pocion("Pocion Grande",300));
                listaObjetosAparecibles.add(new PocionExperiencia("Pocion de Experiencia Grande",300));
                break;

            case 4:
                listaObjetosAparecibles.add(new Pocion("Mega Pocion",400));
                listaObjetosAparecibles.add(new PocionExperiencia("Mega Pocion de Experiencia",400));
                break;
        }
        double aleatori = Math.random();

        aleatori *= listaObjetosAparecibles.size();
        int index = (int)aleatori;

        return  listaObjetosAparecibles.get(index);
    }

    static Monstruo crearMonstruo(int rango)
    {
        Vector<Monstruo> listaMonstruos = new Vector<Monstruo>();
        int randomNivel = (int)(Math.random()*5);
        switch (rango)
        {
            case 0:
                listaMonstruos.add(new MonstruoEjemplo(randomNivel,0));
                break;

            case 1:
                listaMonstruos.add(new MonstruoEjemplo(randomNivel+5,0));
                break;

            case 2:
                listaMonstruos.add(new MonstruoEjemplo(randomNivel+10,0));
                break;

            case 3:
                listaMonstruos.add(new MonstruoEjemplo(randomNivel+15,0));
                break;

            case 4:
                listaMonstruos.add(new MonstruoEjemplo(randomNivel+20,0));
                break;
        }
        double aleatori = Math.random();

        aleatori *= listaMonstruos.size();
        int index = (int)aleatori;

        return  listaMonstruos.get(index);
    }
}
