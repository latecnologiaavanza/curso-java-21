public class ScopedValues1 {


    /*
    Scoped Values es una característica en vista previa introducida en Java para proporcionar una forma de
    compartir datos de forma segura y eficiente dentro de un hilo, en un ámbito controlado y limitado.
    Esta característica es útil para manejar configuraciones, contexto, o datos temporales sin utilizar
    variables globales ni recursos de almacenamiento

    Scoped Value: Es una clase que permite almacenar y acceder a un valor dentro de un ámbito (scope.)
    limitado a un hilo

    Binding: Es el proceso de asociar un valor a un ScopedValue dentro de un ámbito específico

    Unbinding: Al salir del ámbito, el valor asociado es "desatado" (unbound), lo que evita el acceso
    accidental o el uso indebido del valor fuera del ámbito definido

    */

    //ScopedValue.newInstance() crea una nueva instancia de un ScopedValue
    private static final ScopedValue<String> mensaje = ScopedValue.newInstance();

    public static void main(String[] args) {
        /*
        + ScopedValue.where(mensaje, "Hola, Scoped Values").run(...) define un ámbito donde el mensaje tiene
        el valor "Hola, Scoped Values"

        + Dentro de ese ámbito, el valor puede ser accedido con mensaje.get()

        + Fuera del ámbito, el valor no está accesible, lo que previene el uso accidental fuera del contexto
        definido
        */
        ScopedValue.where(mensaje, "Hola, Scoped Values")
                .run(() -> {
                    // Este código puede acceder al valor del Scoped Value
                    System.out.println(mensaje.get()); // Imprime: Hola, Scoped Values
                    System.out.println(mensaje.isBound());
                    otroMetodo();
                });


        // Fuera del ámbito, el valor ya no es accesible
        System.out.println(mensaje.isBound()); // Imprime: false
    }

    private static void otroMetodo() {
        // Aún en el ámbito, se puede acceder al Scoped Value
        System.out.println(mensaje.get()); // Imprime: Hola, Scoped Values
    }

}
