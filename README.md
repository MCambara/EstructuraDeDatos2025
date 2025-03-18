# Proyecto EstructurasDeDatos2025

Este proyecto contiene varias tareas resueltas relacionadas con estructuras de datos, que forman parte de la asignatura de Estructuras de Datos del ciclo de ingeniería en sistemas.

## Descripción

Este repositorio contiene implementaciones de ejercicios usando estructuras de datos, específicamente en Java. Las tareas resueltas incluyen:

1. **Eliminar duplicados en una lista enlazada (LinkedList)**:
   - Este metodo recorre la lista tomando un valor y luego comparandolo con los demas, cuando encuentra un valor repetido lo borra de la lista y baja el indice de la comparacion para no saltar ni uno
   
2. **Invertir los elementos de una LinkedList de Strings**:
   - Este metodo recorre los elementos de la lista de las puntas hacia el centro e intercambia los valores en el camino hasta que chocan y sale del bucle
   
3. **Intercalar dos listas enlazadas ordenadas**:
   - Este metodo recorre ambas listas y toma el valor de los indices de ambas para luego compararlos y agregar el menor, siendo este el que avanza de indice y el otro se queda igual para seguirlo comparando

  ## Tests

1. **Test para eliminar duplicados**:
   - Este test verifica que el método `eliminarDuplicados` funcione correctamente. Se crea una lista con elementos repetidos y se asegura que, después de ejecutar el método, la lista tenga solo los valores únicos.

2. **Test para invertir lista**:
   - Este test verifica que el método `invertirLista` invierta correctamente los elementos de una `LinkedList`. Se comprueba que el primer elemento de la lista sea el último de la original, y que el orden se haya invertido correctamente.

3. **Test para intercalar listas**:
   - Este test verifica que el método `intercalarListas` funcione correctamente. Se crean dos listas ordenadas y se verifica que los elementos de ambas listas se intercalen de forma correcta, manteniendo el orden ascendente.

