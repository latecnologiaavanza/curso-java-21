import java.util.List;

public class StringTemplates {
    public static void main(String[] args) {

        /*
        + Los StringTemplates son una característica de Java 21, que proporciona una forma
        poderosa y segura de manejar cadenas que incluyen valores de variables. Esta
        nueva funcionalidad está destinada a mejorar la legibilidad, la seguridad y la facilidad
        de mantenimiento del código, especialmente cuando se trabaja con plantillas de texto.

        + Los String Templates permiten insertar expresiones dentro de literales de cadenas
        utilizando una sintaxis clara y concisa
        */


        /*
        ¿Para Qué Sirven los String Templates?
        - Seguridad: Al utilizar String Templates, se reduce el riesgo de ataques como la inyección de SQL, ya
        que los valores interpolados se procesan de manera segura, sin necesidad de construir cadenas SQL a mano.

        - Legibilidad: Los String Templates mejoran la legibilidad del código al eliminar la necesidad de
        concatenaciones complicadas o formatos verbosos. Esto hace que el código sea más fácil de entender y mantener

        - Flexibilidad: Permiten la inclusión de lógica compleja dentro de las expresiones interpoladas, lo
        cual es útil para formatear datos o realizar cálculos directamente dentro de la cadena.

        */


        //Ejemplo 1
        /*
        + STR."..." indica que se está utilizando un String Template.
        + \{} se usa para insertar expresiones dentro de la cadena.
        */
        //Sintaxis de String Templates
        String nombre = "Christian";
        int edad = 18;
        String template1 = STR."Nombre: \{nombre}, Edad: \{edad}";
        System.out.println(template1);

        //Ejemplo 2
        //Interpolación de Expresiones
        int x = 5;
        int y = 6;
        String result1 = STR."Suma: \{x+y}";
        System.out.println(result1);

        //Ejempo 3
        //Expresiones de Valor Null
        String nullable = null;
        String result2 = STR."Valor: \{nullable}";
        System.out.println(result2);

        //Ejemplo 4
        //Bloques de Texto
        String name2 = "Christian";
        String multilineTemplate = STR."""
                Estimado \{name2}

                Esta es una plantilla con varias líneas.
                Atentamente,
                El equipo
                """;
        System.out.println(multilineTemplate);

        //Ejemplo 5
        //Generación de HTML

        String title = "Bienvenidos a la Tecnología Avanza";
        String content = "Suscríbete a nuestro canal de YouTube";
        String htmlTemplate = STR."""
        <html>
        <head>
            <title>\{title}</title>
        </head>
        <body>
            <p>\{content}</p>
        </body>
        </html>
        """;
        System.out.println(htmlTemplate);

    }
}
