package utils;

import entities.Driver;
import entities.Tweet;
import uy.edu.um.prog2.adt.hashtable.HashTable;
import uy.edu.um.prog2.adt.hashtable.MyHashTable;
import uy.edu.um.prog2.adt.linkedlist.LinkedList;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;

import static utils.Sorting.heapSort;

public class Operations {
    public MyLinkedList<Integer> top10PilotosMencionados(MyLinkedList<Tweet> tweets, MyLinkedList<Driver> drivers, int month, int year) {

        //Tenemos una lista de tweets llamada "tweets" con los datos correspondientes
        tweets = new LinkedList<>();
        drivers = new LinkedList<>();

        MyHashTable<String, Integer> mencionesPilotos = new HashTable<>(20);
        //agrego todos los drivers al hash para ya ahorrarme el tener que agregarlos despues
        for (Driver driver : drivers) { // O(20)
            mencionesPilotos.put(driver.getFullname(), 0);
        }

        // De los tweets que coinciden en mes y año, busco los nombres de los pilotos
        for (Tweet tweet : tweets) { // O(N)
            if (tweet.getYear() == year && tweet.getMonth() == month) {
                //entro al contenido del tweet y busco el nombre del piloto y cuantas veces aparece
                String tweetContent = tweet.getContent();

                if(tweetContent != null){ // mientras que el contenido del tweet no sea nulo
                    for (Driver driver : drivers){ // O(20)
                        String driverName = driver.getName();
                        String driverSurname = driver.getSurname();
                        if(tweetContent.contains(driverName) || tweetContent.contains(driverSurname) || tweetContent.contains(driver.getFullname() ) ){
                            mencionesPilotos.put(driverName, mencionesPilotos.get(driverName) + 1); // lo que tenía antes más 1
                        }
                    }
                }
            }
        }
        // Ordena el Hash en función de los valores de menciones en orden descendente

        //Puedo crearme un array que guarde las posiciones de los elementos de la linked list y ordenar ese array leyendo los valores de la linkedlist
        //y luego recorrer la linked list con los elementos ordenados
       Comparable[] valores = new Comparable[mencionesPilotos.size()];
         int i = 0;
        for (Driver key : drivers) { // O(20)
            valores[i] = mencionesPilotos.get(key.getFullname()); // guardo en el array la cantidad de menciones
            i++;
        }
        heapSort(valores); // O(20 log 20)

        // Toma los 10 primeros elementos de la lista ordenada
        for (int j = 0; j < 10; j++) {
            if (valores[j] != null) {
                for (Driver key : drivers) { // O(20)
                    if (mencionesPilotos.get(key.getFullname()).equals(valores[j])) {
                        mencionesPilotos.put(key.getFullname(), j + 1);
                    }
                }
            }
        }

        MyLinkedList<Integer> top10Pilotos = ((HashTable<String, Integer>) mencionesPilotos).hashToLinkedList(); // O(20)

        return top10Pilotos;
    }
    //afuera
}
/* for (Tweet tweet : tweetsFiltrados) {
            String textoTweet = tweet.getText();
            String nombrePilotoMencionado = obtenerNombrePilotoMencionado(textoTweet);

            if (nombrePilotoMencionado != null) {
                mencionesPilotos.put(nombrePilotoMencionado, mencionesPilotos.getOrDefault(nombrePilotoMencionado, 0) + 1);
            }
        }

        // Ordena el HashMap en función de los valores de menciones en orden descendente
        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(mencionesPilotos.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Toma los 10 primeros elementos de la lista ordenada
        List<Map.Entry<String, Integer>> top10Pilotos = listaOrdenada.subList(0, Math.min(10, listaOrdenada.size()));

        // Imprime los resultados
        for (Map.Entry<String, Integer> entry : top10Pilotos) {
            System.out.println("Piloto: " + entry.getKey() + ", Menciones: " + entry.getValue());
        }
*/