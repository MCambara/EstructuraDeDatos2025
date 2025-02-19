package umg.edu.gt.test.ClaseArrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioArrays;

public class MetodoOrdenarDiagonalesTest {

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

        // Verifica que el resultado del método sea el esperado
        assertArrayEquals(resultadoEsperado, EjercicioArrays.ordenarDiagonales(matriz));
    }

    @Test
    void testMatrizFueraDeRangoFilas() {
        int[][] matrizGrande = new int[101][10]; // Más de 100 filas

        // Verifica que una matriz con más de 100 filas genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.ordenarDiagonales(matrizGrande));
    }

    @Test
    void testMatrizFueraDeRangoColumnas() {
        int[][] matrizGrande = new int[10][101]; // Más de 100 columnas

        // Verifica que una matriz con más de 100 columnas genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.ordenarDiagonales(matrizGrande));
    }

    @Test
    void testValoresFueraDeRango() {
        int[][] matrizInvalida = {
            {1, 2, 3},
            {4, 1001, 6} // Contiene un valor mayor a 1000
        };

        // Verifica que una matriz con un valor fuera del rango permitido genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.ordenarDiagonales(matrizInvalida));
    }
}
