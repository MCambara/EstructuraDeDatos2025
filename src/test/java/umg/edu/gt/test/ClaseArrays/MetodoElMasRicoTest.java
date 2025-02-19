package umg.edu.gt.test.ClaseArrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios.EjercicioArrays;

public class MetodoElMasRicoTest {

    @Test
    void testElMasRico() {
        int Dinero[][] = {
            {1, 5},  // Suma = 6
            {7, 3},  // Suma = 10 (máxima)
            {3, 5}   // Suma = 8
        };

        // Verifica que el resultado de elMasRico sea 10
        assertEquals(10, EjercicioArrays.elMasRico(Dinero));
    }

    @Test
    void testMatrizFueraDeRangoFilas() {
        int Dinero[][] = new int[101][10]; // Más de 100 filas

        // Verifica que una matriz con más de 100 filas genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.elMasRico(Dinero));
    }

    @Test
    void testMatrizFueraDeRangoColumnas() {
        int Dinero[][] = new int[10][101]; // Más de 100 columnas

        // Verifica que una matriz con más de 100 columnas genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.elMasRico(Dinero));
    }

    @Test
    void testValoresFueraDeRango() {
        int Dinero[][] = {
            {1, 2, 3},
            {4, 1001, 6} // Contiene un valor mayor a 1000
        };

        // Verifica que una matriz con un valor fuera del rango permitido genere una excepción
        assertThrows(IllegalArgumentException.class, () -> EjercicioArrays.elMasRico(Dinero));
    }
}
