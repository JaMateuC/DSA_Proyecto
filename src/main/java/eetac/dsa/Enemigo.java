package eetac.dsa;
import java.util.Random;
/**
 * La clase Enemigo contiene los parametros para instanciar a un enemigo en el juego
 */
public class Enemigo extends Personaje
{
    public Enemigo(String nombre, String escenario, int x, int y, Lista_Monstruos lista_montruos, Inventario inventario, boolean genero)
    {
        super(nombre, escenario, x, y, lista_montruos, inventario, genero);
    }

    public int Random()
    {
        Random random = new Random();
        int num = random.nextInt(4);
        return num;
    }
}
