package miPackage;

//Actividad Final Crud. Programacion Orientada a Objetos - José Carrillo. C.I.30739823

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Crud{

public static void main(String[]args){
		
		try{
			//Se crea la conexion con pgAdmin
			
					Connection miConexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Entidad - Relacion Universidad","postgres", "postgres");
					System.out.println("Paso 1: Conexion  Completa");
					
				
					Statement miStatement= miConexion.createStatement(); 
					System.out.println("Paso 2: Objeto para realizar consultas creado"); 
					
					//Insercion de Datos en las tablas
					
					//String insertSQL = "INSERT INTO Carrera (id_carrera, nombre_carrera, duracion_carrera) VALUES ('0010-3589','Administracion de PG', '9')";
					
					//String insertSQL = "INSERT INTO Alumno (cedula_alumno, nombre_alumno, edad_alumno, semestre_alumno, id_carrera_alumno) VALUES ('30739823','Jose Carrillo', '19', '7', '54384-008')";
					
					String insertSQL = "SELECT *FROM Alumno";
					
					//Se ejecuta el Query
					
					ResultSet miResultset = miStatement.executeQuery(insertSQL); 
					
					System.out.println("Paso 3: Ejecucion de Query completada"); 
				
					//Actualizacion de Base de Datos y Eliminacion de fila
					/*         
					String updateSQL = "UPDATE Alumno SET \"semestre_alumno\"=\"semestre_alumno\"+1"; 
					
					String deleteSQL = "DELETE FROM Carrera WHERE \"duracion_carrera\"='10'"; 
					
					//Se elimina el comentario depende de la accion que se elija realizar: (Insertar, actualizar, eliminar)
					
					//miStatement.executeUpdate(insertSQL); 
					//miStatement.executeUpdate(updateSQL); 
					//miStatement.executeUpdate(deleteSQL);
					
					System.out.println("Registro borrado correctamente");*/
					
					
					
					while(miResultset.next()){
						   
						/*
						 System.out.println("ID: "+ miResultset.getInt("id_carrera")+
								           " Nombre: "+ miResultset.getString("nombre_carrera")+
								           " Duracion: "+ miResultset.getString("duracion_carrera"));     
					*/
						
						 System.out.println("Cedula: "+ miResultset.getInt("cedula_alumno")+
						           " Nombre: "+ miResultset.getString("nombre_alumno")+
						           " Edad: "+ miResultset.getString("edad_alumno")+
						           " Semestre: "+ miResultset.getString("semestre_alumno")+
						           " ID de Carrera: "+ miResultset.getString("id_carrera_alumno"));   
						
					}
					System.out.println("Paso 4: Operacion realizada con exito"); 
					
				}catch(Exception e) {
					System.out.println("Fallo");
					System.out.println(e.getMessage()); 
				}
			}
		
	
}
