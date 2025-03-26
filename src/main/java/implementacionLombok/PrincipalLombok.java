package implementacionLombok;

public class PrincipalLombok {
    public static void main(String[] args) {
        // Crear un objeto usando el constructor vacío
        PersonaLombok persona1 = new PersonaLombok();
        persona1.setNombre("Carlos");
        persona1.setEdad(28);
        persona1.setTelefono(123456789);

        // Crear un objeto usando el constructor con argumentos
        PersonaLombok persona2 = new PersonaLombok("Ana", 32, 987654321);

        // Imprimir los objetos (se usa el toString() generado por Lombok)
        System.out.println(persona1);
        System.out.println(persona2);
    }
}
