package eetac.dsa.Excepciones;

public class CeldaFueraDeRangoException extends IndexOutOfBoundsException {
    @Override
    public String getMessage() {
        return "Celda fuera del rango de escenario";
    }

    @Override
    public String getLocalizedMessage() {
        return "Celda fuera del rango de escenario";
    }
}
