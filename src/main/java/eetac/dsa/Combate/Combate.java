package eetac.dsa.Combate;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

public class Combate {
    static Combate combateInstance = null;
    World mundo;

    private Combate() {
        Vec2 gravedad = new Vec2(0.f,-9.8f);
        mundo = new World(gravedad);
        mundo.setAllowSleep(true);
        mundo.setContactListener(new CombatCollisionListener());
        EntidadEscenario escenario = new EntidadEscenario(40,20,mundo);
    }

    static public Combate getInstance()
    {
        if(combateInstance==null)
            combateInstance = new Combate();
        return combateInstance;
    }

    public World getMundo() {
        return mundo;
    }
}
