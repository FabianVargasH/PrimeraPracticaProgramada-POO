public class Mascota {
    private String id;
    private String nombre;
    private String especie;
    private String estado;
    private DispositivoLocalizacion dispositivo; // COMPOSICIÓN
    
    // Constructor completo
    public Mascota(String id, String nombre, String especie, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.estado = estado;
        this.dispositivo = null;
    }
    
    // Constructor parcial
    public Mascota(String id, String nombre, String especie) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.estado = "ACTIVO";
        this.dispositivo = null;
    }
    
    // Constructor por defecto
    public Mascota() {
    }
    
    // Getters
    public String getId() {
        return this.id;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getEspecie() {
        return this.especie;
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public DispositivoLocalizacion getDispositivo() {
        return this.dispositivo;
    }
    
    // Setters
    public void setId(String id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    // Método para crear y asociar dispositivo (COMPOSICIÓN)
    public boolean crearDispositivo(String codigo, String estadoDispositivo) {
        if (this.dispositivo != null) {
            return false;
        }
        this.dispositivo = new DispositivoLocalizacion(codigo, estadoDispositivo, this);
        return true;
    }
    
    // equals
    public boolean equals(Mascota otraMascota) {
        return this.id.equals(otraMascota.id);
    }
    
    // toString
    public String toString() {
        String informacion = "Mascota: \nID = " + this.id + 
                           "\nNombre = " + this.nombre + 
                           "\nEspecie = " + this.especie + 
                           "\nEstado = " + this.estado;
        
        if (this.dispositivo != null) {
            informacion += "\nDispositivo =" + this.dispositivo.getCodigo();
        } else {
            informacion += "\nDispositivo = No tiene";
        }
        
        return informacion;
    }
}