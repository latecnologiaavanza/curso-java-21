public class UnnamedPatternsAndVariables {

    /*

    En términos simples, Unnamed Patterns y Unnamed Variables son patrones y variables que no requieren
    un nombre explícito para usarse. Esto facilita el uso de patrones en situaciones donde solo se
    necesita verificar una condición sin necesidad de acceder a los valores específicos

    Los Unnamed Patterns and Variables (Patrones y Variables sin Nombre) son una característica introducida
    en Java 21 en vista previa. Permiten realizar coincidencias en patrones (patterns) sin la necesidad de
    nombrar explícitamente las variables resultantes cuando estas no se utilizarán en el código
    */

    public static void main(String[] args) {

        //Ejemplo Básico: Patrones sin Nombre
        Object obj = "Hello";

        /*
        instanceof String _: En este caso, String _ es un patrón sin nombre que verifica si obj es una
        instancia de String. La variable _ no se usa, por lo que no se le asigna un nombre específico.
        */

        if (obj instanceof String _) {
            System.out.println("Es una cadena de texto.");
        }

        switch (obj) {
            case String _ -> System.out.println("Es una cadena de texto.");
            case Integer _ -> System.out.println("Es un número entero.");
            default -> System.out.println("Tipo desconocido.");
        }
    }

}
