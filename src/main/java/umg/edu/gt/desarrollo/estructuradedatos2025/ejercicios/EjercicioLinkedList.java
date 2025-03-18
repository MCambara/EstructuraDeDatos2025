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
	
	// Problema 1: Dada una LinkedList<Integer>, escribir un método que elimine los valores duplicados, dejando solo la primera aparición de cada número.
	
	public void eliminarDuplicados(LinkedList<Integer> listaEnteros)
	{
		for(int i = 0; i < listaEnteros.size(); i++)
		{
			for(int j = i + 1; j <listaEnteros.size(); j++)
			{
				if(listaEnteros.get(i).equals(listaEnteros.get(j)))
				{
					listaEnteros.remove(j);
					j--;
				}
			}
		}
	}
	
	// Problema 2: Implementar un método que invierta los elementos de una LinkedList<String> sin usar otra lista o ArrayList.
	
	public void invertirLista(LinkedList<String> listaString)
	{
		int cabeza = 0;
		int cola = listaString.size() - 1;
		while(cabeza < cola)
		{
			String temporal = listaString.get(cabeza);
			listaString.set(cabeza, listaString.get(cola));
			listaString.set(cola, temporal);
			cola --;
			cabeza++;
		}
	}
	
	// Problema 3: Dadas dos listas enlazadas ordenadas de enteros, escribir un método que devuelva una nueva LinkedList<Integer> con los elementos de ambas listas intercalados en orden.
	
	public LinkedList<Integer> intercalarListas(LinkedList<Integer> lista1, LinkedList<Integer> lista2)
	{
		LinkedList<Integer> nuevaLista = new LinkedList<Integer>();
		int primerIndice = 0;
		int segundoIndice = 0;
	
		while(primerIndice < lista1.size() && segundoIndice < lista2.size())
		{
			if(lista1.get(primerIndice) < lista2.get(segundoIndice))
			{
				nuevaLista.add(lista1.get(primerIndice));
				primerIndice++;
			}
			else
			{
				nuevaLista.add(lista2.get(segundoIndice));
				segundoIndice++;
			}
		}
		
		while(primerIndice < lista1.size())
		{
			nuevaLista.add(lista1.get(primerIndice));
			primerIndice++;
		}
		
		while(segundoIndice < lista2.size())
		{
			nuevaLista.add(lista2.get(segundoIndice));
			segundoIndice++;
		}
		
		return nuevaLista;
		
	}
}