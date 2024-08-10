public class PatternMatchingForSwitch {

    /*
    - Patrón: Un patrón es una plantilla o estructura que define cómo se deben organizar y clasificar
    los datos. Los patrones permiten:

    * Reconocer si un dato cumple con ciertas características
    * Extraer información de los datos de manera estructurada
    * Realizar operaciones basadas en la forma o el contenido de los datos

    */
    
    /*
    + La característica de "Pattern Matching for Switch" (coincidencia de patrones para switch) es parte de la
    evolución del lenguaje Java que busca mejorar la flexibilidad y la expresividad de las declaraciones switch

    + Pattern Matching for Switch (coincidencia de patrones para switch) es una característica añadida a Java que
    simplifica la forma en que se manejan los casos en una expresión switch al permitir el uso de patrones en
    lugar de solo valores constantes. Esto mejora la legibilidad y reduce el código repetitivo.

    + Pattern Matching for switch mejora la estructura de switch en Java al permitir que los case utilicen
    patrones para hacer coincidir tanto el tipo de datos como sus valores, simplificando así el código y
    mejorando la legibilidad


    Patrones de Tipo: Se usa para verificar y extraer datos del tipo especificado.
    Patrones de Clase: Permiten desestructurar objetos de clases con sus componentes.
    Patrones Compuestos: Combinan condiciones para coincidir con múltiples criterios.
    */

    record Point(int x,int y){

    }

    public static void printPointInfo(Object obj) {
        switch (obj) {
            case Point(int x, int y) -> System.out.println("Point with x: " + x + " and y: " + y);
            default -> System.out.println("Not a Point");
        }
    }

    public static void main(String[] args) {
        /* Uso Básico de Patrones */
        //OldSwitchExample 1
        describe("Hello");  // Output: String with length: 5
        describe(42);        // Output: Integer with value: 42
        describe(3.14);      // Output: Double with value: 3.14

        //New 1
        describeWithPattern("Hello");  // Output: String with length: 5
        describeWithPattern(42);        // Output: Integer with value: 42
        describeWithPattern(3.14);      // Output: Double with value: 3.14

        System.out.println();

        /*  Patrones de Desestructuración en Registros */
        Point point = new Point(1,2);
        printPointInfo(point);

        Object obj = new Object();
        printPointInfo(obj);

        System.out.println();

        /*Patrones Compuestos*/
        process("HelloWorld");  // Output: Long String
        process("Hi");          // Output: Short String
        process(15);            // Output: Large Integer
        process(5);             // Output: Small Integer
        process(new Object()); // Output: Unknown type
    }

    public static void describe(Object obj) {
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println("String with length: " + s.length());
        } else if (obj instanceof Integer) {
            Integer i = (Integer) obj;
            System.out.println("Integer with value: " + i);
        } else if (obj instanceof Double) {
            Double d = (Double) obj;
            System.out.println("Double with value: " + d);
        } else {
            System.out.println("Other type");
        }
    }

    public static void describeWithPattern(Object object){
        switch (object){
            case String s -> System.out.println("String with length: " + s.length());
            case Integer i -> System.out.println("Integer with value: " + i);
            case Double d -> System.out.println("Double with value: " + d);
            default -> System.out.println("Other type");
        }
    }

    public static void process(Object obj) {
        switch (obj) {
            case String s -> {
                if (s.length() > 5) {
                    System.out.println("Long String");
                } else {
                    System.out.println("Short String");
                }
            }
            case Integer i -> {
                if (i > 10) {
                    System.out.println("Large Integer");
                } else {
                    System.out.println("Small Integer");
                }
            }
            default -> System.out.println("Unknown type");
        }
    }
}
