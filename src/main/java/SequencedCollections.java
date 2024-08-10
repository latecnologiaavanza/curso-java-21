import java.sql.Array;
import java.util.*;

public class SequencedCollections {

    /*
    - Java 21 introduce una serie de interfaces llamadas Sequenced Collections a través de JEP 431. Estas
    interfaces están diseñadas para manejar colecciones con un orden definido, facilitando el acceso a
    elementos en los extremos de la colección y la reversión del orden. Las tres interfaces principales son:
    SequencedCollection, SequencedSet, y SequencedMap

    - Las Sequenced Collections representan cualquier colección con un orden definido, permitiendo operaciones
    específicas sobre elementos en el primer y último lugar de la colección

    - Antes de Java 21, no existía una interfaz estandar para manejar estos casos de uso de manera
    consistente en las colecciones en Java

    * Propósitos y Beneficios

    - Acceso a Primer y Último Elemento: Las nuevas interfaces permiten acceder directamente al primer y último
    elemento, sin necesidad de iterar o realizar búsquedas adicionales.

    - Operaciones de Adición y Eliminación en los Extremos: Facilitan la adición y eliminación de elementos
    tanto al principio como al final de una colección

    - Iteración Inversa: Proveen una vista invertida de la colección, simplificando el proceso de
    iterar en orden inverso
    */


    public static void main(String[] args) {

        //Es la interfaz base que describe una colección con un orden definido
        SequencedCollection<String> tasks = new ArrayList<>();
        tasks.add("Suscríbete a La Tecnologia Avanza"); //2
        tasks.addFirst("Deja tu comentario"); //1
        tasks.addLast("Comparte el curso en tus redes"); //3
        System.out.println(tasks);
        System.out.println(tasks.getFirst());
        System.out.println(tasks.getLast());
        System.out.println(tasks.reversed());

        //Extiende SequencedCollection y Set, proporcionando una estructura de conjunto con un orden definido
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>(List.of(1, 2, 3));
        System.out.println(numbers);
        System.out.println(numbers.getFirst()); // 1
        System.out.println(numbers.getLast()); // 3
        System.out.println(numbers.reversed()); // [3, 2, 1]

        //Extiende Map y añade métodos específicos para manejar entradas de mapa con un orden
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Uno");
        map.put(2, "Dos");
        System.out.println(map.firstEntry()); // 1=Uno
        System.out.println(map.lastEntry()); // 2=Dos
        System.out.println(map.reversed()); // {2=Dos, 1=Uno}


    }
}
