public class ScopedValues2 {

    //Crea un ScopedValue para almacenar un nivel de log temporal.
    private static final ScopedValue<String> nivelLog = ScopedValue.newInstance();

    public static void main(String[] args) {
        System.out.println("Nivel de log inicial: " + obtenerNivelLog());

        //En un bloque de código, ajusta el nivel de log a "DEBUG".
        ScopedValue.where(nivelLog, "DEBUG")
                .run(() -> {
                    System.out.println("Nivel de log temporal: " + obtenerNivelLog());
                    // Realizar tareas con nivel de log DEBUG
                });

        System.out.println("Nivel de log final: " + obtenerNivelLog());
    }

    private static String obtenerNivelLog() {
        return nivelLog.isBound() ? nivelLog.get() : "INFO"; // Valor por defecto "INFO"
    }

}
