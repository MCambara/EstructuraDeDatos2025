package umg.edu.gt.test.ClaseArrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioArrays;

public class MetodoSumaMatrixTest {

    // Logger para la clase de pruebas
    private static final Logger logger = LogManager.getLogger(MetodoSumaMatrixTest.class);

    @Test
    void testSumaMatrix() {
        int[][] matrix = {
            {1, 2, 3},   // Suma = 6
            {4, 3, 6},   // Suma = 15
            {7, 8, 9}    // Suma = 24
        };

        logger.info("Iniciando prueba 'testSumaMatrix'...");
        
        // Verifica que el resultado de sumaMatrix sea 45 (6 + 15 + 24)
        int resultado = EjercicioArrays.sumaMatrix(matrix);
        logger.debug("Resultado obtenido: " + resultado);
        
        assertEquals(45, resultado);
        
        logger.info("Prueba 'testSumaMatrix' completada exitosamente.");
    }

    @Test
    void testMatrizFueraDeRangoFilas() {
        int[][] matrizVacia = {}; // No tiene filas

        logger.info("Iniciando prueba 'testMatrizFueraDeRangoFilas'...");
        
        // Verifica que lanzar una matriz sin filas genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.sumaMatrix(matrizVacia));

        logger.info("Prueba 'testMatrizFueraDeRangoFilas' completada exitosamente.");
    }

    @Test
    void testMatrizFueraDeRangoColumnas() {
        int[][] matrizInvalida = {
            {1, 2, 3},
            {} // Fila vacía
        };

        logger.info("Iniciando prueba 'testMatrizFueraDeRangoColumnas'...");
        
        // Verifica que una matriz con una fila sin columnas genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.sumaMatrix(matrizInvalida));

        logger.info("Prueba 'testMatrizFueraDeRangoColumnas' completada exitosamente.");
    }

    @Test
    void testValoresFueraDeRango() {
        int[][] matrizConValorInvalido = {
            {1, 2, 3},
            {4, 1001, 6} // Contiene un valor mayor a 1000
        };

        logger.info("Iniciando prueba 'testValoresFueraDeRango'...");
        
        // Verifica que un valor fuera del rango permitido genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.sumaMatrix(matrizConValorInvalido));

        logger.info("Prueba 'testValoresFueraDeRango' completada exitosamente.");
    }
}
