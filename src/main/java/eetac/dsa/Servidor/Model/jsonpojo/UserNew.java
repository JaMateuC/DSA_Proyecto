package eetac.dsa.Servidor.Model.jsonpojo;

public class UserNew
{
    private String nombre;
    private String password;
    private String email;
    private boolean genero;

    public UserNew() { }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email;  }

    public boolean isGenero() { return genero; }

    public void setGenero(boolean genero) { this.genero = genero; }
}
