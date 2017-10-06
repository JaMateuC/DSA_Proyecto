package eetac.dsa;

/**
 * La Clase Usuario permite instanciar un personaje para el jugador
 */
public class Usuario extends Personaje
{
    private String email;
    private String password;

    public Usuario(String nombre, String escenario, int x, int y, Lista_Monstruos lista_montruos, Inventario inventario, boolean genero, String email, String password)
    {
        super(nombre, escenario, x, y, lista_montruos, inventario, genero);
        this.email = email;
        this.password = password;
    }
}
