package pck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class actividadbdd {

	public static void main(String[]args) {
		
		try {
					
					Connection miConexion= DriverManager.getConnection("jdbc:postgresql://localhost:5432/RestaurantUruBD","postgres", "elimora");
					System.out.println("Paso 1: Conexion  Completa");
					
				
					Statement miStatement= miConexion.createStatement(); 
					System.out.println("Paso 2 objeto para hacer consultas completo"); 
					
					//String insertSQL = "INSERT INTO platos(precio_plato, nombre_plato) VALUES ('90','Sopa de costilla')";
					//String insertSQL = "INSERT INTO platos  VALUES('80','Choripan')";
					
					String insertSQL = "SELECT *FROM platos";
					
					ResultSet miReseultset = miStatement.executeQuery(insertSQL); 
					
					
					System.out.println("Paso 3 completo"); 
					/*         
					String upDateSQL = "UPDATE productos SET \"PRECIO\"=\"PRECIO\"*2 WHERE \"CODIGOPRODUCTOS\"='AR78'"; 
					
					String deleteSQL = "DELETE FROM productos WHERE \"CODIGOPRODUCTOS\"='AR78'"; 
					
					
					//miStatement.executeUpdate(insertSQL); 
					//miStatement.executeUpdate(upDateSQL); 
					miStatement.executeUpdate(deleteSQL);
					
					System.out.println("Registro borrado correctamente");*/
					
					
					
					while(miReseultset.next()) {
						   
						System.out.println("id    : "+ miReseultset.getInt("id_plato")+
								           " Precio  : "+ miReseultset.getString("precio_plato")+
								           " Nombre : "+ miReseultset.getString("nombre_plato"));     
					
					}
					System.out.println("Paso 4 completo"); 
					
				}catch(Exception e) {
					System.out.println("Fallo");
					System.out.println(e.getMessage()); 
				}
			}
	
}
