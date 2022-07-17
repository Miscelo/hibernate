/*
 * @ author Michael Schossow
 * 
 * Crear un nuevo proyecto MAVEN, con una aplicación que se conecte a una base de datos, 
 * crear un nuevo registro (fila) en una tabla y 
 * luego realice una consulta para devolver todas las filas de dicha tabla.
 * 
 * Para comenzar el proyecto, te puedes ayudar de la estructura de un proyecto Maven 
 * que se encuentra en C:\Ejercicios\Exercise07
 * Será necesario crear una base de datos llamada exercise07 que contenga una tabla llamada student. 
 * Para ello te puedes ayudar del fichero C:\Ejercicios\exercise07.sql.
 * 
 */




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;



public class TestConnection {

	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3306/exercise07?serverTimezone=UTC";
		String user = "mic";
		String passwd = "my1337DB+42";
		
		
		try {
			
			System.out.println("Connexion to Database: "+ url);
			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Conectado a la base de datos con exito!");
			
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM student";
			ResultSet rs = stmt.executeQuery(query);
			
			int columns = rs.getMetaData().getColumnCount();
			
			for (int i=1;i<=columns;i++) {
				System.out.print(String.format("%-30s", rs.getMetaData().getColumnLabel(i)));
			}
			System.out.println("\n");
			
			while(rs.next()) {
				for(int i=1;i<=columns;i++) {
					System.out.print(String.format("%-30s", rs.getString(i)));
				}
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch (SQLException sqlexc) {
			System.out.println("Error connectando a la base de datos.");
			sqlexc.getMessage();
			sqlexc.printStackTrace();
			
		}
		
		
	}

}
