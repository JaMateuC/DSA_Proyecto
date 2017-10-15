package eetac.dsa.Combate.Ataques;

import eetac.dsa.Combate.AtaqueFisica;
import eetac.dsa.Combate.MonstruoEntidad;
import org.jbox2d.common.Vec2;

public class Placaje extends AtaqueFisica{
    public Placaje() {
        super("Placaje", 2f,0.25f);
    }

    @Override
    public void extraAtacanteFisica(MonstruoEntidad atacante) {
        if(atacante.isApuntaDerecha())
        {
            atacante.getBody().applyLinearImpulse(new Vec2(30,0), atacante.getBody().getWorldCenter());
        }
        else
        {
            atacante.getBody().applyLinearImpulse(new Vec2(-30,0), atacante.getBody().getWorldCenter());
        }
    }
}
