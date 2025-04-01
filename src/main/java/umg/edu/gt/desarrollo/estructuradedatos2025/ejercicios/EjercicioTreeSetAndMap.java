package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.TreeMap;
import java.util.TreeSet;

public class EjercicioTreeSetAndMap {
    
    // 📌 EJERCICIO 1: Análisis de Frecuencia de Palabras
    public static TreeMap<String, Integer> contarFrecuenciaPalabras(String filePath) {
        TreeMap<String, Integer> frecuenciaPalabras = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Convertir a minúsculas y eliminar puntuaciones
                String[] palabras = linea.toLowerCase().replaceAll("[^a-záéíóúüñ]", " ").split("\\s+");

                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return frecuenciaPalabras;
    }

    public static void imprimirFrecuencia(TreeMap<String, Integer> frecuenciaPalabras) {
        for (var entry : frecuenciaPalabras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    // 📌 EJERCICIO 2: Rastreador de Versiones de Código
    private TreeMap<Integer, String> versiones;
    private int contadorVersiones;

    public EjercicioTreeSetAndMap() {
        this.versiones = new TreeMap<>();
        this.contadorVersiones = 0;
    }

    public void agregarVersion(String codigo) {
        contadorVersiones++; // Incrementa el número de versión
        versiones.put(contadorVersiones, codigo);
        System.out.println("Agregar versión " + contadorVersiones + ": \"" + codigo + "\"");
    }

    public String obtenerVersion(int version) {
        return versiones.getOrDefault(version, "Versión no encontrada");
    }

    public String obtenerUltimaVersion() {
        if (versiones.isEmpty()) {
            return "No hay versiones disponibles";
        }
        return versiones.lastEntry().getValue();
    }

    public void eliminarVersion(int version) {
        if (versiones.containsKey(version)) {
            versiones.remove(version);
            System.out.println("Versión " + version + " eliminada.");
        } else {
            System.out.println("No se encontró la versión " + version);
        }
    }
    
    // 📌 EJERCICIO 3: Sistema de Gestión de Eventos
    public static class Evento implements Comparable<Evento> {
        LocalDateTime fecha;
        public String nombre;
        String ubicacion;

        public Evento(LocalDateTime fecha, String nombre, String ubicacion) {
            this.fecha = fecha;
            this.nombre = nombre;
            this.ubicacion = ubicacion;
        }

        @Override
        public int compareTo(Evento otro) {
            return this.fecha.compareTo(otro.fecha); // Ordenar por fecha ascendente
        }

        @Override
        public String toString() {
            return "\"" + nombre + "\", " + fecha + ", " + ubicacion;
        }
    }

    // Hacemos `eventos` privado para evitar modificaciones externas directas
    private TreeSet<Evento> eventos = new TreeSet<>();

    // Método público para agregar eventos
    public void agregarEvento(LocalDateTime fecha, String nombre, String ubicacion) {
        eventos.add(new Evento(fecha, nombre, ubicacion));
        System.out.println("Evento agregado: " + nombre);
    }

    // Método público para mostrar eventos
    public void mostrarEventos() {
        System.out.println("Lista de eventos:");
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }

    // Método para obtener el próximo evento
    public Evento obtenerProximoEvento() {
        eliminarEventosPasados();
        return eventos.isEmpty() ? null : eventos.first();
    }

    // Método privado para eliminar eventos pasados
    private void eliminarEventosPasados() {
        eventos.removeIf(evento -> evento.fecha.isBefore(LocalDateTime.now()));
    }
}




	
	/** INSTRUCCIONES
 	Escriba el algoritmo que resuelve el problema en esta clase.
	Debe crear un package llamado umg.edu.gt.test.EjercicioTree que corresponda al Test de esta clase.
	Genere un Test por cada ejemplo y fuerce que uno de esos Test falle, puede implementar retornar un resultado
	y compararlo con el esperado.
	 */
	
	/* EJERCICIO 1: Análisis de Frecuencia de Palabras (TreeMap)
	 * 📜 Descripción: Escriba un programa que lea un texto de un archivo y cuente la frecuencia de cada palabra, ordenándolas alfabéticamente.
		🔹 Instrucciones:
			Leer un archivo de texto (.txt).			
			Dividir el texto en palabras (ignorando puntuaciones y convirtiéndolas a minúsculas).
			Almacenar cada palabra en un TreeMap<String, Integer>, donde la clave es la palabra y el valor es el número de veces que aparece.
			Imprimir las palabras en orden alfabético junto con su frecuencia.
	 */
	
	
	/* EJERCICIO 2: Rastreador de Versiones de Código (TreeMap)
		📜 Descripción: Desarrolle un programa que simule un rastreador de versiones de archivos en un sistema de control de versiones.
		🔹 Instrucciones:
			Utilice un TreeMap<Integer, String>, donde la clave representa el número de versión y el valor es el contenido de esa versión del código.			
			Debe permitir:			
			Agregar una nueva versión con una clave autoincrementada.			
			Obtener una versión específica dada su clave.			
			Obtener la última versión disponible.			
			Eliminar una versión específica si es necesario.
			
			Salida:
				Agregar versión 1: "System.out.println('Hola Mundo');"
				Agregar versión 2: "System.out.println('Hola Java');"
				Última versión: "System.out.println('Hola Java');"
				Versión 1: "System.out.println('Hola Mundo');"

	 * 
	 */
	
	/** EJERCICIO 3: Sistema de Gestión de Eventos (TreeSet)
		📜 Descripción: Implemente un sistema para administrar eventos ordenados cronológicamente.		
		🔹 Instrucciones:		
			Utilice un TreeSet, donde cada Evento debe contener:		
			fecha (LocalDateTime)		
			nombre (String)		
			ubicación (String)		
			Los eventos deben ordenarse automáticamente por fecha y hora.		
			Debe permitir:		
				Agregar un nuevo evento.		
				Mostrar la lista de eventos en orden cronológico.		
				Obtener el próximo evento a ocurrir.		
				Eliminar un evento pasado automáticamente después de una consulta.
				
			Salida:
				Próximo evento: "Conferencia de Java", 2025-05-10 10:00, Auditorio A  
				Lista de eventos:  
				1. "Taller de Machine Learning", 2025-04-15 14:00, Sala 3  
				2. "Conferencia de Java", 2025-05-10 10:00, Auditorio A  

	 */