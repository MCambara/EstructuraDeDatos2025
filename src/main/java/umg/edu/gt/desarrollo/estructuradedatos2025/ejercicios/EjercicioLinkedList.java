package umg.edu.gt.desarrollo.estructuradedatos2025.ejercicios;

import java.util.LinkedList;

public class EjercicioLinkedList {
	
	/** INSTRUCCIONES
 	Escriba el algoritmo que resuelve el problema en esta clase.
	Debe crear un package llamado umg.edu.gt.test.EjercicioLinkedList que corresponda al Test de esta clase.
	Genere un Test por cada ejemplo y fuerce que uno de esos Test falle, puede implementar retornar un resultado
	y compararlo con el esperado.
	 */
	
	// Usando LinkedList de Java Collections, resuelva los siguientes problemas
	
	// Problema 1: Dada una LinkedList<Integer>, escribir un método que elimine los valores duplicados,
	// dejando solo la primera aparición de cada número.
	
	public void eliminarDuplicados(LinkedList<Integer> listaEnteros)
	{
		// Recorremos la lista con dos índices para comparar cada elemento con los siguientes
		for(int i = 0; i < listaEnteros.size(); i++)
		{
			// Comparamos el valor actual con el siguiente
			for(int j = i + 1; j < listaEnteros.size(); j++)
			{
				// Si encontramos un valor duplicado, lo eliminamos
				if(listaEnteros.get(i).equals(listaEnteros.get(j)))
				{
					listaEnteros.remove(j);
					// Ajustamos el índice para continuar la búsqueda sin perder elementos
					j--;
				}
			}
		}
	}
	
	// Problema 2: Implementar un método que invierta los elementos de una LinkedList<String> sin usar
	// otra lista o ArrayList.
	
	public void invertirLista(LinkedList<String> listaString)
	{
		int cabeza = 0;  // Índice del primer elemento
		int cola = listaString.size() - 1;  // Índice del último elemento
		
		// Intercambiamos los elementos mientras cabeza sea menor que cola
		while(cabeza < cola)
		{
			// Guardamos temporalmente el valor en la cabeza
			String temporal = listaString.get(cabeza);
			// Intercambiamos los elementos
			listaString.set(cabeza, listaString.get(cola));
			listaString.set(cola, temporal);
			
			// Movemos los índices hacia el centro de la lista
			cola--;
			cabeza++;
		}
	}
	
	// Problema 3: Dadas dos listas enlazadas ordenadas de enteros, escribir un método que devuelva una
	// nueva LinkedList<Integer> con los elementos de ambas listas intercalados en orden.
	
	public LinkedList<Integer> intercalarListas(LinkedList<Integer> lista1, LinkedList<Integer> lista2)
	{
		LinkedList<Integer> nuevaLista = new LinkedList<Integer>();  // Lista resultante
		int primerIndice = 0;  // Índice para la primera lista
		int segundoIndice = 0;  // Índice para la segunda lista
	
		// Intercalamos los elementos de ambas listas mientras no se haya agotado ninguna
		while(primerIndice < lista1.size() && segundoIndice < lista2.size())
		{
			// Comparamos y agregamos el menor valor a la nueva lista
			if(lista1.get(primerIndice) < lista2.get(segundoIndice))
			{
				nuevaLista.add(lista1.get(primerIndice));
				primerIndice++;  // Avanzamos el índice de la primera lista
			}
			else
			{
				nuevaLista.add(lista2.get(segundoIndice));
				segundoIndice++;  // Avanzamos el índice de la segunda lista
			}
		}
		
		// Si quedan elementos en la primera lista, los agregamos
		while(primerIndice < lista1.size())
		{
			nuevaLista.add(lista1.get(primerIndice));
			primerIndice++;
		}
		
		// Si quedan elementos en la segunda lista, los agregamos
		while(segundoIndice < lista2.size())
		{
			nuevaLista.add(lista2.get(segundoIndice));
			segundoIndice++;
		}
		
		// Retornamos la nueva lista con los elementos intercalados
		return nuevaLista;
	}
}
