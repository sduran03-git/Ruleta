public class usuario {
    private String username;
    private String password;
    private String nombre;
    public usuario(String username, String password, String nombre) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }
    public boolean validarCredenciales(String u, String p) {
        return this.username.equals(u) && this.password.equals(p);
    }
    public String getNombre() {
        return nombre;
    }
}