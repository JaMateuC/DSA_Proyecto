package eetac.dsa;

/**
 * La Clase Usuario permite instanciar un personaje para el jugador
 */
public class Usuario extends Personaje
{
    private String email;
    private String password;

    public Usuario(String nombre, String escenario, int x, int y, boolean genero, String email, String password)
    {
        super(nombre, escenario, x, y, genero);
        this.email = email;
        this.password = password;
    }
}
