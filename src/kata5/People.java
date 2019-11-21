package kata5;

class People {
    private final String nombre;
    private final String apellido;
    private final String departamento;
    
    People(String nombre, String apellido, String d) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = d;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDepartamento() {
        return departamento;
    }
    
        
}
