public class ScopedValues3 {

    private static final ScopedValue<String> usuario = ScopedValue.newInstance();

    public static void main(String[] args) {
        manejarSolicitud("Usuario1");
        manejarSolicitud("Usuario2");
    }

    private static void manejarSolicitud(String nombreUsuario) {
        ScopedValue.where(usuario, nombreUsuario)
                .run(() -> {
                    autenticar();
                    obtenerDatos();
                });
    }

    private static void autenticar() {
        System.out.println("Autenticando: " + usuario.get());
    }

    private static void obtenerDatos() {
        System.out.println("Obteniendo datos para: " + usuario.get());
    }

}
