package umg.edu.gt.test.ClaseArrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioArrays;

public class MetodoElMasRicoTest {

    // Logger para la clase de pruebas
    private static final Logger logger = LogManager.getLogger(MetodoElMasRicoTest.class);

    @Test
    void testElMasRico() {
        int Dinero[][] = {
            {1, 5},  // Suma = 6
            {7, 3},  // Suma = 10 (máxima)
            {3, 5}   // Suma = 8
        };

        logger.info("Iniciando prueba 'testElMasRico'...");
        
        // Verifica que el resultado de elMasRico sea 10
        int resultado = EjercicioArrays.elMasRico(Dinero);
        logger.debug("Resultado obtenido: " + resultado);

        assertEquals(10, resultado);
        
        logger.info("Prueba 'testElMasRico' completada exitosamente.");
    }

    @Test
    void testMatrizFueraDeRangoFilas() {
        int Dinero[][] = new int[101][10]; // Más de 100 filas

        logger.info("Iniciando prueba 'testMatrizFueraDeRangoFilas'...");
        
        // Verifica que una matriz con más de 100 filas genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.elMasRico(Dinero));

        logger.info("Prueba 'testMatrizFueraDeRangoFilas' completada exitosamente.");
    }

    @Test
    void testMatrizFueraDeRangoColumnas() {
        int Dinero[][] = new int[10][101]; // Más de 100 columnas

        logger.info("Iniciando prueba 'testMatrizFueraDeRangoColumnas'...");
        
        // Verifica que una matriz con más de 100 columnas genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.elMasRico(Dinero));

        logger.info("Prueba 'testMatrizFueraDeRangoColumnas' completada exitosamente.");
    }

    @Test
    void testValoresFueraDeRango() {
        int Dinero[][] = {
            {1, 2, 3},
            {4, 1001, 6} // Contiene un valor mayor a 1000
        };

        logger.info("Iniciando prueba 'testValoresFueraDeRango'...");
        
        // Verifica que una matriz con un valor fuera del rango permitido genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.elMasRico(Dinero));

        logger.info("Prueba 'testValoresFueraDeRango' completada exitosamente.");
    }
}
