package eetac.dsa;

/**
 * La clase Personaje otorga los atributos comunes a Usuario y Enenmigo
 */
public abstract class Personaje
{
    private String nombre;
    private String escenario;
    private int x, y;
    private Lista_Monstruos lista_montruos;
    private Inventario inventario;
    private boolean genero;

    public Personaje(String nombre, String escenario, int x, int y, boolean genero)
    {
        this.nombre = nombre;
        this.escenario = escenario;
        this.x = x;
        this.y = y;
        this.lista_montruos = new Lista_Monstruos();
        this.inventario = new Inventario();
        this.genero = genero;
    }
}
