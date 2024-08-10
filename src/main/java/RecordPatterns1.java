public class RecordPatterns1 {


    /*
    Record Patterns es una mejora en el lenguaje de programación Java que permite deconstruir valores de
    registros (records) usando patrones. Esta característica facilita el trabajo con datos complejos al
    permitir la descomposición de instancias de registros en sus componentes de manera declarativa y concisa.
    A partir de Java 21, los patrones de registros y los patrones de tipo se pueden anidar, lo que mejora
    significativamente la capacidad de navegación y procesamiento de datos.

    En Java, un patrón de registro (record pattern) es una característica introducida en Java 21 que
    extiende el concepto de "pattern matching" (coincidencia de patrones) para permitir la descomposición
    de instancias de registros (records) directamente en las expresiones de instanceof, así como en las
    declaraciones de switch. Los patrones de registro permiten extraer de manera declarativa los
    componentes de un registro sin necesidad de castings manuales ni acceso explícito a los métodos de
    acceso  

    */

    static Pair<String> pair1 = new Pair<>("hello", "world");
    static Pair<Object> pair2 = new Pair<>(42, "foo");

    public static void main(String[] args) {
        //Patrones de Registros
        Point point = new Point(5,4);
        imprimirSuma(point);

        //Patrones Anidados
        /*
        Aquí, Rectangle(ColoredPoint(Point(var x, var y), var c), var lr) es un patrón de registro anidado
        que descompone el Rectangle en sus componentes internos y luego descompone uno de esos componentes
        (ColoredPoint) aún más.
        */
        Rectangle rectangle = new Rectangle(
                new ColoredPoint(new Point(1, 2), Color.RED),
                new ColoredPoint(new Point(3, 4), Color.BLUE)
        );
        imprimirColorDelPuntoSuperiorIzquierdo(rectangle);

        System.out.println();

        //Ejemplo de Inferencia de Tipo
        MyPair<String, Integer> pair = new MyPair<>("Hello", 42);
        recordInterface(pair);

        //Ejemplo de Patrones en Switch
        testSwitch(pair1);
        testSwitch(pair2);
    }

    static void imprimirSuma(Object object){
        /*
        Point(int x, int y) es un patrón de registro que descompone el registro Point en sus componentes x e y
        */
        if(object instanceof Point(int x,int y)){
            System.out.println(x+y);
        }
    }

    static void imprimirColorDelPuntoSuperiorIzquierdo(Rectangle r){
        if (r instanceof Rectangle(ColoredPoint(Point(var x, var y), var c), ColoredPoint(Point(var z, var a), var f))) {
            System.out.println(f);
        }
    }

    static void recordInterface(MyPair<String,Integer> pair){
        //el patrón MyPair(var f, var s) infiere correctamente los tipos String e Integer para f y s.
        switch (pair){
            case MyPair(var f,var s) -> System.out.println(STR."First: \{f}, Second: \{s}");
        }
    }


    static void testSwitch(Pair<?> pair) {
        switch (pair) {
            case Pair(String s1, String s2) -> System.out.println("Pair of strings: " + s1 + ", " + s2);
            case Pair(Integer i1, Integer i2) -> System.out.println("Pair of integers: " + i1 + ", " + i2);
            default -> System.out.println("Other pair");
        }
    }

    static void printPointInfOld(Object object){
        /*
        Antes de Java 21, tenías que usar instanceof para verificar el tipo y luego acceder manualmente a
        los componentes del registro mediante los métodos de acceso generados
        */
        if (object instanceof Point2) {
            Point p = (Point) object; // Cast manual
            int x = p.x(); // Acceso manual a componentes
            int y = p.y();
            System.out.println("x: " + x + ", y: " + y);
        }
    }
}


record Point2(int x,int y){

}

record Pair<T>(T x, T y){

}

record MyPair<S,T>(S fst,T snd){}

record Point(int x,int y){

}

enum Color {
    RED, GREEN, BLUE
}

record ColoredPoint(Point p, Color c) {

}

record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) {

}

/*

- OTROS CONCEPTOS A TENER EN CUENTA

¿Qué es un Record?
+ Un record en Java es una característica introducida en Java 14 como una vista preliminar y formalizada en
Java 16. Los records proporcionan una forma concisa de definir clases que actúan principalmente como
portadores de datos inmutables


¿Qué son genéricos?
+ En Java, los genéricos son una característica que permite a los programadores definir clases, interfaces y
métodos con tipos de datos parametrizados. Esto proporciona una forma de escribir código que es más flexible
y reutilizable, ya que los tipos de datos pueden ser especificados en el momento de la instancia o llamada
del método, en lugar de estar codificados en el propio código.

¿Qué es la inferencia de tipos?
+ La inferencia de tipo es un mecanismo en los lenguajes de programación que permite al compilador deducir
el tipo de una variable, expresión o parámetro sin que el programador tenga que especificarlo explícitamente.
Esto hace que el código sea más conciso y legible, ya que reduce la necesidad de anotaciones de tipo
redundantes.

Ejemplos:

var message = "Hello, World!"; // El compilador infiere que 'message' es de tipo String
var count = 42; // El compilador infiere que 'count' es de tipo int


*/