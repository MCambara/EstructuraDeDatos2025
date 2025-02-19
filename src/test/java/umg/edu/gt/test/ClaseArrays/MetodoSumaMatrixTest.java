package umg.edu.gt.test.ClaseArrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioArrays;

public class MetodoSumaMatrixTest {

    @Test
    void testSumaMatrix() {
        int[][] matrix = {
            {1, 2, 3},   // Suma = 6
            {4, 3, 6},   // Suma = 15 (Añadi un 3 para que no de 15 como antes y que lance un error el test)
            {7, 8, 9}    // Suma = 24
        };

        // Verifica que el resultado de sumaMatrix sea 45 (6 + 15 + 24)
        assertEquals(45, EjercicioArrays.sumaMatrix(matrix));
    }

    @Test
    void testMatrizFueraDeRangoFilas() {
        int[][] matrizVacia = {}; // No tiene filas

        // Verifica que lanzar una matriz sin filas genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.sumaMatrix(matrizVacia));
    }

    @Test
    void testMatrizFueraDeRangoColumnas() {
        int[][] matrizInvalida = {
            {1, 2, 3},
            {} // Fila vacía
        };

        // Verifica que una matriz con una fila sin columnas genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.sumaMatrix(matrizInvalida));
    }

    @Test
    void testValoresFueraDeRango() {
        int[][] matrizConValorInvalido = {
            {1, 2, 3},
            {4, 1001, 6} // Contiene un valor mayor a 1000
        };

        // Verifica que un valor fuera del rango permitido genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.sumaMatrix(matrizConValorInvalido));
    }
}
