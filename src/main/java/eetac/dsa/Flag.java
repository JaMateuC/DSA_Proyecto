package eetac.dsa;

public class Flag {
    final public static long cargarProtagonista =                 0b1;
    final public static long cargarEscenario =                   0b10;
    final public static long cargarPersonajesEscenario =        0b100;
    final public static long moverProtagonista =              0b10000;
    final public static long iniciarCombate =                0b100000;
    final public static long añadirObjeto =                 0b1000000;
    final public static long borrarObjeto =                0b10000000;

    long flag;

    public Flag() {
        this.flag = 0b0;
    }

    public void addFlag(long flag)
    {
        flag = this.flag|flag;
    }

    public boolean isFlag(long flag)
    {
        if((flag&this.flag)!=0)
            return true;
        return false;
    }
}
