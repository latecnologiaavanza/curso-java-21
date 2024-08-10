import java.util.concurrent.Executors;

public class VirtualThreads {

    //Caso de Uso Simplificado: Simulación de Tareas Concurrentes
    //Comparar el rendimiento entre hilos tradicionales y hilos virtuales en una tarea simple que simula
    //una operación de espera.
    public static void main(String[] args) {

        /*
        final int numThreads = 3000; // Número reducido de hilos para simplificar
        Thread[] threads = new Thread[numThreads];

        long startTime = System.currentTimeMillis();

        // Crear y empezar hilos
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                try {
                    // Simular una tarea
                    Thread.sleep(100); // Esperar 100 ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread thread : threads) {
            try {
                thread.join(); // Esperar a que cada hilo termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo total con hilos tradicionales: " + (endTime - startTime) + " ms");
/*

         */
        final int numThreads = 1000; // Número reducido de hilos para simplificar

        long startTime = System.currentTimeMillis();

        // Crear y empezar hilos virtuales
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = Thread.ofVirtual().start(() -> {
                try {
                    // Simular una tarea
                    Thread.sleep(100); // Esperar 100 ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Esperar a que todos los hilos terminen
        for (Thread thread : threads) {
            try {
                thread.join(); // Esperar a que cada hilo termine
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Tiempo total con hilos virtuales: " + (endTime - startTime) + " ms");
    }
}
/*
    }
}

/*

- Concurrencia: La concurrencia se refiere a la capacidad de un sistema para ejecutar múltiples tareas de
manera simultánea. En programación, esto significa que múltiples partes de un programa pueden estar en
progreso al mismo tiempo, aunque no necesariamente se estén ejecutando exactamente al mismo tiempo en un
sistema de un solo núcleo

- Paralelismo: Es una forma de concurrencia donde múltiples tareas se ejecutan al mismo tiempo en diferentes
núcleos de un procesador o en múltiples procesadores. En un sistema de múltiples núcleos, el paralelismo es
más común y efectivo.

- Sincronización: Para coordinar el acceso a recursos compartidos y evitar problemas como condiciones de
carrera, se utilizan técnicas de sincronización

-------------------------------------------
-  Los hilos virtuales son una forma ligera de hilos que permiten una alta concurrencia sin los costos
asociados con los hilos tradicionales (hilos de plataforma)

- Los hilos virtuales permiten una gran cantidad de hilos concurrentes en comparación con los hilos
tradicionales, que son más pesados y costosos en términos de recursos

* Diferencias con Hilos Tradicionales:

- Hilos Tradicionales: Cada hilo tradicional en Java está asociado con un hilo del sistema operativo
subyacente. Esto puede ser costoso en términos de memoria y recursos, especialmente cuando se manejan
grandes cantidades de hilos

- Hilos Virtuales: Son gestionados por la máquina virtual de Java (JVM) y no están directamente ligados a
los hilos del sistema operativo. Esto permite una creación y gestión más eficiente, usando menos recursos
para cada hilo virtual


-----------------------------------------
¿Qué es un proceso?
- Es una instancia en ejecución de un programa. Cuando ejecutas un programa en tu computadora, el sistema
operativo crea un proceso para manejar esa ejecución

¿Qué es un Hilo?
- Un hilo (o thread) es la unidad básica de ejecución dentro de un proceso. Los hilos permiten que múltiples
tareas se realicen simultáneamente dentro del mismo proceso


*/