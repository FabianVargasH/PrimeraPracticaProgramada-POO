import java.util.ArrayList;

public class DispositivoLocalizacion {
    private String codigo;
    private String estado;
    private Mascota mascota; // COMPOSICIÓN (dueño)
    private ArrayList<RegistroUbicacion> registros; // COMPOSICIÓN
    
    // Constructor completo 
    public DispositivoLocalizacion(String codigo, String estado, Mascota mascota) {
        this.codigo = codigo;
        this.estado = estado;
        this.mascota = mascota;
        this.registros = new ArrayList<RegistroUbicacion>();
    }
    
    // Getters
    public String getCodigo() {
        return this.codigo;
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public Mascota getMascota() {
        return this.mascota;
    }
    
    public ArrayList<RegistroUbicacion> getRegistros() {
        return this.registros;
    }
    
    // Setters 
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    // Método para registrar ubicación (COMPOSICIÓN)
    public RegistroUbicacion registrarUbicacion(String idRegistro, String informacionUbicacion) {
        RegistroUbicacion nuevoRegistro = new RegistroUbicacion(idRegistro, informacionUbicacion, this);
        this.registros.add(nuevoRegistro);
        return nuevoRegistro;
    }
    
    // equals
    public boolean equals(DispositivoLocalizacion otroDispositivo) {
        return this.codigo.equals(otroDispositivo.codigo);
    }
    
    // toString
    public String toString() {
        return "Dispositivo: \nCódigo = " + this.codigo + 
               "\nEstado = " + this.estado + 
               "\nMascota = " + this.mascota.getNombre() + 
               "\nTotalRegistros = " + this.registros.size();
    }
}