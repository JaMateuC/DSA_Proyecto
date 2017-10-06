package eetac.dsa;

/**
 * La clase Personaje otorga los atributos comunes a Usuario y Enenmigo
 */
public abstract class Personaje
{
    private String nombre;
    private String escenario;
    private int x, y;
    private Inventario inventario;
    private Lista_Monstruos lista_montruos;
    private boolean genero;
}
