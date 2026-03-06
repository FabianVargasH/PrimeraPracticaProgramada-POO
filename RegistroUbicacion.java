import java.util.Date;

public class RegistroUbicacion {
    private String id;
    private Date fechaHora;
    private String ubicacion;
    private DispositivoLocalizacion dispositivo; // COMPOSICIÓN
    
    // Constructor completo
    public RegistroUbicacion(String id, String ubicacion, DispositivoLocalizacion dispositivo) {
        this.id = id;
        this.fechaHora = new Date();
        this.ubicacion = ubicacion;
        this.dispositivo = dispositivo;
    }
    
    // Getters
    public String getId() {
        return this.id;
    }
    
    public Date getFechaHora() {
        return this.fechaHora;
    }
    
    public String getUbicacion() {
        return this.ubicacion;
    }
    
    public DispositivoLocalizacion getDispositivo() {
        return this.dispositivo;
    }
    
    // Setters
    public void setId(String id) {
        this.id = id;
    }
    
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    // equals
    public boolean equals(RegistroUbicacion otroRegistro) {
        return this.id.equals(otroRegistro.id);
    }

    // toString
    public String toString() {
        return "Registro: \nID = " + this.id + 
               "\nFecha = " + this.fechaHora + 
               "\nUbicación = " + this.ubicacion + 
               "\nDispositivo = " + this.dispositivo.getCodigo();
    }
}