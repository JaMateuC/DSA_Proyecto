package eetac.dsa.Ejemplos;

import eetac.dsa.Ataque;
import eetac.dsa.Combate.Ataques.Pisoton;
import eetac.dsa.Combate.Ataques.Placaje;
import eetac.dsa.Combate.Ataques.SaltoAereo;
import eetac.dsa.Ejemplos.AtaqueEjemplo;
import eetac.dsa.Monstruo;

public class MonstruoEjemplo extends Monstruo
{
    public MonstruoEjemplo(int nivel,int experiencia)
    {
        super(20, 5, 3, "MonstruoEjemplo", 30,nivel);
        setExperiencia(experiencia);

        getLista_ataques().añadirAtaque(new Pisoton());
        getLista_ataques().añadirAtaque(new AtaqueEjemplo());
        getLista_ataques().añadirAtaque(new Placaje());
        getLista_ataques().añadirAtaque(new SaltoAereo());
    }
}
