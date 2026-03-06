import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    private BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    public void mostrar() throws IOException {
        int opcion;
        do {
            System.out.println("\n========================================");
            System.out.println("   SISTEMA DE GESTION DE MASCOTAS");
            System.out.println("========================================");
            System.out.println("1. Registrar mascota");
            System.out.println("2. Asociar dispositivo a mascota");
            System.out.println("3. Registrar ubicación manual");
            System.out.println("4. Consultar información de mascota");
            System.out.println("5. Listar todas las mascotas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(lector.readLine());
            
            if (opcion == 1) {
                registrarMascota();
            } else if (opcion == 2) {
                asociarDispositivo();
            } else if (opcion == 3) {
                registrarUbicacion();
            } else if (opcion == 4) {
                consultarMascota();
            } else if (opcion == 5) {
                listarMascotas();
            } else if (opcion == 0) {
                System.out.println("¡Gracias por usar el sistema!");
            } else {
                System.out.println("Opción no válida. Por favor intente de nuevo.");
            }
            
        } while (opcion != 0);
    }
    private Mascota buscarMascota(String id) {
        for (int indice = 0; indice < mascotas.size(); indice++) {
            Mascota mascotaActual = mascotas.get(indice);
            if (mascotaActual.getId().equals(id)) {
                return mascotaActual;
            }
        }
        return null;
    }
    private void registrarMascota() throws IOException {
        System.out.println("\n--- REGISTRO DE MASCOTA ---");
        
        System.out.print("ID de la mascota: ");
        String id = lector.readLine();
        
        if (buscarMascota(id) != null) {
            System.out.println("Error: Ya existe una mascota con el ID " + id);
            return;
        }
        System.out.print("Nombre de la mascota: ");
        String nombre = lector.readLine();
        System.out.print("Especie de la mascota: ");
        String especie = lector.readLine();
        System.out.print("Estado de la mascota: ");
        String estado = lector.readLine();
        Mascota nuevaMascota = new Mascota(id, nombre, especie, estado);
        mascotas.add(nuevaMascota);
        System.out.println("- - - - - - - - - - -");
        System.out.println("La mascota " + nombre + " ha sido registrada exitosamente con ID " + id);
        System.out.println(nuevaMascota.toString());
    }
    private void asociarDispositivo() throws IOException {
        System.out.println("\n--- ASOCIAR DISPOSITIVO A MASCOTA ---");
        System.out.print("ID de la mascota: ");
        String idMascota = lector.readLine();
        Mascota mascotaEncontrada = buscarMascota(idMascota);
        if (mascotaEncontrada == null) {
            System.out.println("Error: No se encontró ninguna mascota con el ID " + idMascota);
            return;
        }
        if (mascotaEncontrada.getDispositivo() != null) {
            System.out.println("Error: La mascota " + mascotaEncontrada.getNombre() + " ya tiene un dispositivo asociado");
            return;
        }
        System.out.print("Código del dispositivo: ");
        String codigo = lector.readLine();
        System.out.print("Estado del dispositivo: ");
        String estadoDispositivo = lector.readLine();
        boolean operacionExitosa = mascotaEncontrada.crearDispositivo(codigo, estadoDispositivo);
        if (operacionExitosa) {
            System.out.println("- - - - - - - - - - -");
            System.out.println("El dispositivo con código " + codigo + " ha sido creado y asociado a la mascota " + mascotaEncontrada.getNombre());
            System.out.println(mascotaEncontrada.getDispositivo().toString());
        } else {
            System.out.println("Error: No se pudo crear el dispositivo");
        }
    }
    
    private void registrarUbicacion() throws IOException {
        System.out.println("\n--- REGISTRO DE UBICACION ---");
        System.out.print("ID de la mascota: ");
        String idMascota = lector.readLine();
        Mascota mascotaEncontrada = buscarMascota(idMascota);
        if (mascotaEncontrada == null) {
            System.out.println("Error: No se encontró ninguna mascota con el ID " + idMascota);
            return;
        }
        DispositivoLocalizacion dispositivo = mascotaEncontrada.getDispositivo();
        if (dispositivo == null) {
            System.out.println("Error: La mascota " + mascotaEncontrada.getNombre() + " no tiene un dispositivo asociado");
            return;
        }
        System.out.print("ID del registro: ");
        String idRegistro = lector.readLine();
        ArrayList<RegistroUbicacion> registrosDelDispositivo = dispositivo.getRegistros();
        for (int indice = 0; indice < registrosDelDispositivo.size(); indice++) {
            RegistroUbicacion registroExistente = registrosDelDispositivo.get(indice);
            if (registroExistente.getId().equals(idRegistro)) {
                System.out.println("Error: Ya existe un registro con el ID " + idRegistro + " en este dispositivo");
                return;
            }
        }
        System.out.print("Información de ubicación: ");
        String ubicacion = lector.readLine();
        RegistroUbicacion nuevoRegistro = dispositivo.registrarUbicacion(idRegistro, ubicacion);
        System.out.println("- - - - - - - - - - -");
        System.out.println("Ubicación registrada exitosamente para la mascota " + mascotaEncontrada.getNombre());
        System.out.println(nuevoRegistro.toString());
    }
    
    private void consultarMascota() throws IOException {
        System.out.println("\n--- CONSULTA DE MASCOTA ---");
        System.out.print("ID de la mascota a consultar: ");
        String idMascota = lector.readLine();
        Mascota mascotaEncontrada = buscarMascota(idMascota);
        if (mascotaEncontrada == null) {
            System.out.println("No se encontró ninguna mascota con el ID " + idMascota);
            return;
        }
        System.out.println("\n" + mascotaEncontrada.toString());
        DispositivoLocalizacion dispositivo = mascotaEncontrada.getDispositivo();
        if (dispositivo != null) {
            System.out.println("\n" + dispositivo.toString());
            ArrayList<RegistroUbicacion> registrosDelDispositivo = dispositivo.getRegistros();
            if (registrosDelDispositivo.size() > 0) {
                System.out.println("\n--- REGISTROS DE UBICACIÓN DE " + mascotaEncontrada.getNombre().toUpperCase() + " ---");
                for (int indiceRegistro = 0; indiceRegistro < registrosDelDispositivo.size(); indiceRegistro++) {
                    RegistroUbicacion registroActual = registrosDelDispositivo.get(indiceRegistro);
                    System.out.println("\n" + registroActual.toString());
                }
            } else {
                System.out.println("\nLa mascota " + mascotaEncontrada.getNombre() + " no tiene registros de ubicación");
            }
        } else {
            System.out.println("\nLa mascota " + mascotaEncontrada.getNombre() + " no tiene un dispositivo asociado");
        }
    }
    private void listarMascotas() {
        System.out.println("\n--- LISTA DE MASCOTAS REGISTRADAS ---");
        if (mascotas.size() == 0) {
            System.out.println("No hay mascotas registradas en el sistema");
            return;
        }
        System.out.println("Total de mascotas: " + mascotas.size());
        System.out.println("----------------------------------------------------");
        for (int indice = 0; indice < mascotas.size(); indice++) {
            Mascota mascotaActual = mascotas.get(indice);
            String informacionDispositivo;
            DispositivoLocalizacion dispositivo = mascotaActual.getDispositivo();
            if (dispositivo != null) {
                informacionDispositivo = "Sí (Código: " + dispositivo.getCodigo() + ")";
            } else {
                informacionDispositivo = "No";
            }
            int numeroLista = indice + 1;
            System.out.println(numeroLista + ". " + 
                               "Id: " + mascotaActual.getId() + " - " + 
                               mascotaActual.getNombre() + " (" + 
                               mascotaActual.getEspecie() + ") - Estado: " + 
                               mascotaActual.getEstado() + " - Dispositivo: " + 
                               informacionDispositivo);
        }
    }
}