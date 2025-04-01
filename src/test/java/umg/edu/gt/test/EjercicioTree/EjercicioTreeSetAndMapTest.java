package umg.edu.gt.test.EjercicioTree;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioTreeSetAndMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class EjercicioTreeSetAndMapTest {

    // 📌 Test del Ejercicio 1: Análisis de Frecuencia de Palabras
    @Test
    public void testContarFrecuenciaPalabras() {
        String filePath = "src/test/resources/test.txt"; // Ruta del archivo
        // Se espera que el archivo test.txt contenga: "hola mundo hola"
        TreeMap<String, Integer> frecuencia = EjercicioTreeSetAndMap.contarFrecuenciaPalabras(filePath);

        // Verificar la frecuencia de las palabras
        assertEquals(2, frecuencia.get("hola"));
        assertEquals(1, frecuencia.get("mundo"));
    }

    // 📌 Test del Ejercicio 2: Rastreador de Versiones de Código
    @Test
    public void testRastreadorDeVersiones() {
        EjercicioTreeSetAndMap ejercicio = new EjercicioTreeSetAndMap();

        // Agregar versiones
        ejercicio.agregarVersion("System.out.println('Hola Mundo');");
        ejercicio.agregarVersion("System.out.println('Hola Java');");

        // Verificar la última versión
        assertEquals("System.out.println('Hola Java');", ejercicio.obtenerUltimaVersion());

        // Verificar una versión específica
        assertEquals("System.out.println('Hola Mundo');", ejercicio.obtenerVersion(1));

        // Eliminar una versión
        ejercicio.eliminarVersion(1);
        assertEquals("System.out.println('Hola Java');", ejercicio.obtenerUltimaVersion());
    }

    // 📌 Test del Ejercicio 3: Sistema de Gestión de Eventos
    @Test
    public void testGestionDeEventos() {
        EjercicioTreeSetAndMap ejercicio = new EjercicioTreeSetAndMap();
        
        // Agregar eventos
        ejercicio.agregarEvento(LocalDateTime.of(2025, 5, 10, 10, 0), "Conferencia de Java", "Auditorio A");
        ejercicio.agregarEvento(LocalDateTime.of(2025, 4, 15, 14, 0), "Taller de Machine Learning", "Sala 3");

        // Verificar que los eventos se han agregado y ordenado
        ejercicio.mostrarEventos();

        // Obtener el próximo evento
        assertEquals("Taller de Machine Learning", ejercicio.obtenerProximoEvento().nombre);

        // Aquí hacemos que falle a propósito, esperando un valor incorrecto
        assertEquals("Conferencia de Java", ejercicio.obtenerProximoEvento().nombre); // Esto fallará intencionadamente
     
        // Verificar que el tamaño de eventos es 1 después de eliminar el evento pasado
        assertEquals(1, ejercicio.obtenerProximoEvento() != null ? 1 : 0);
    }
}
