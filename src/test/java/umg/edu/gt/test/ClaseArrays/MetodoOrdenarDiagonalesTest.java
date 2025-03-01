package umg.edu.gt.test.ClaseArrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioArrays;

public class MetodoOrdenarDiagonalesTest {

    // Logger para la clase de pruebas
    private static final Logger logger = LogManager.getLogger(MetodoOrdenarDiagonalesTest.class);

    @Test
    void testOrdenarDiagonales() {
        int[][] matriz = {
            {3, 3, 1, 1},
            {2, 2, 1, 2},
            {1, 1, 1, 2}
        };

        int[][] resultadoEsperado = {
            {1, 1, 1, 1},
            {1, 2, 2, 2},
            {1, 2, 3, 3}
        };

        logger.info("Iniciando prueba 'testOrdenarDiagonales'...");
        
        // Verifica que el resultado del método sea el esperado
        int[][] resultado = EjercicioArrays.ordenarDiagonales(matriz);
        logger.debug("Resultado obtenido: " + arrayToString(resultado));
        
        assertArrayEquals(resultadoEsperado, resultado);
        
        logger.info("Prueba 'testOrdenarDiagonales' completada exitosamente.");
    }

    @Test
    void testMatrizFueraDeRangoFilas() {
        int[][] matrizGrande = new int[101][10]; // Más de 100 filas

        logger.info("Iniciando prueba 'testMatrizFueraDeRangoFilas'...");
        
        // Verifica que una matriz con más de 100 filas genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.ordenarDiagonales(matrizGrande));

        logger.info("Prueba 'testMatrizFueraDeRangoFilas' completada exitosamente.");
    }

    @Test
    void testMatrizFueraDeRangoColumnas() {
        int[][] matrizGrande = new int[10][101]; // Más de 100 columnas

        logger.info("Iniciando prueba 'testMatrizFueraDeRangoColumnas'...");
        
        // Verifica que una matriz con más de 100 columnas genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.ordenarDiagonales(matrizGrande));

        logger.info("Prueba 'testMatrizFueraDeRangoColumnas' completada exitosamente.");
    }

    @Test
    void testValoresFueraDeRango() {
        int[][] matrizInvalida = {
            {1, 2, 3},
            {4, 1001, 6} // Contiene un valor mayor a 1000
        };

        logger.info("Iniciando prueba 'testValoresFueraDeRango'...");
        
        // Verifica que una matriz con un valor fuera del rango permitido genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.ordenarDiagonales(matrizInvalida));

        logger.info("Prueba 'testValoresFueraDeRango' completada exitosamente.");
    }

    // Método auxiliar para convertir una matriz en un String (para logging)
    private String arrayToString(int[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : array) {
            for (int el : row) {
                sb.append(el).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
