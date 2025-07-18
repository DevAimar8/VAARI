package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Clase para la conexión con una base de datos MySQL
 *
 * @author Francisco Jesús Delgado Almirón
 */
public class ConexionMySQL {

    // Base de datos a la que nos conectamos
    private String BD;
    // Usuario de la base de datos
    private String USUARIO;
    // Contraseña del usuario de la base de datos
    private String PASS;
    // Objeto donde se almacenará nuestra conexión
    private Connection connection;
    // Indica que está en localhost
    private String HOST;
    // Zona horaria
    private TimeZone zonahoraria;

    /**
     * Constructor de la clase
     *
     * @param usuario Usuario de la base de datos
     * @param pass Contraseña del usuario
     * @param bd Base de datos a la que nos conectamos
     * 
     */
   
    public ConexionMySQL(String usuario, String pass, String bd) {
        HOST = "localhost";
        USUARIO = usuario;
        PASS = pass;
        BD = bd;
        connection = null;
    }

    /**
     * Comprueba que el driver de MySQL esté correctamente integrado
     *
     * @throws SQLException Se lanzará cuando haya un fallo con la base de datos
     */
    private void registrarDriver() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al conectar con MySQL: " + e.getMessage());
        }
    }

    /**
     * Conecta con la base de datos
     * @return 
     *
     * @throws SQLException Se lanzará cuando haya un fallo con la base de datos
     */
    public boolean conectar() throws SQLException {
        if (connection == null || connection.isClosed()) {
            registrarDriver();
            // Obtengo la zona horaria
            Calendar now = Calendar.getInstance();
            zonahoraria = now.getTimeZone();
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + BD + "?user="
                    + USUARIO + "&password=" + PASS + "&useLegacyDatetimeCode=false&serverTimezone="
                    + zonahoraria.getID());
        }
		return false;
    }

    /**
     * Cierra la conexión con la base de datos
     *
     * @throws SQLException Se lanzará cuando haya un fallo con la base de datos
     */
    public void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    /**
     * Ejecuta una consulta SELECT
     *
     * @param consulta Consulta SELECT a ejecutar
     * @return Resultado de la consulta
     * @throws SQLException Se lanzará cuando haya un fallo con la base de datos
     */
    public ResultSet ejecutarSelect(String consulta) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rset = stmt.executeQuery(consulta);

        return rset;
    }

    /**
     * Ejecuta una consulta INSERT, DELETE o UPDATE
     *
     * @param consulta Consulta INSERT, DELETE o UPDATE a ejecutar
     * @return Cantidad de filas afectadas
     * @throws SQLException Se lanzará cuando haya un fallo con la base de datos
     */
    public int ejecutarInsertDeleteUpdate(String consulta) throws SQLException {
        Statement stmt = connection.createStatement();
        int fila = stmt.executeUpdate(consulta);

        return fila;
    }
    
    public boolean verificarCredenciales(String email, String contrasena) {
        String consulta = "SELECT * FROM usuarios WHERE email = ? AND contrasena = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(consulta)) {
            pstmt.setString(1, email);
            pstmt.setString(2, contrasena);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Si hay al menos una fila, significa que las credenciales son correctas
        } catch (SQLException e) {
            System.err.println("Error al verificar credenciales: " + e.getMessage());
            return false;
        }
    }
    
}
