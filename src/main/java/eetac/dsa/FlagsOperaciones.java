package eetac.dsa;

public class FlagsOperaciones {
    final public static long cargarProtagonista = 0b1;
    final public static long cargarEscenario = 0b10;
    final public static long cargarPersonajesEscenario = 0b100;
    final public static long moverProtagonista = 0b1000;
    final public static long iniciarCombate = 0b10000;
    final public static long añadirObjeto = 0b100000;
    final public static long borrarObjeto = 0b1000000;
    final public static long operacionNoValida = 0b10000000;
}
