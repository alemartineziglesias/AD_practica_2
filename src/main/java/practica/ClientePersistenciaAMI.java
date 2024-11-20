package practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientePersistenciaAMI 
{
	public int crearCliente(String nombre, String apellidos, String email, String dni, String clave)
	{
		int id = 0;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sourceURL = "jdbc:mysql://localhost/hotelAMI";
			Connection dbcon = DriverManager.getConnection(sourceURL, "root", "Mr9+agar");
			Statement sentencia = dbcon.createStatement();
			String comando = "INSERT INTO clienteAMI (nombreCliente, apellidosCliente, emailCliente, dniCliente, claveCliente) VALUES ('" + nombre + "', '" + apellidos + "', '" + email + "', '" + dni + "', '" + clave + "')";
			sentencia.executeUpdate(comando);
			ResultSet resultado = sentencia.executeQuery("SELECT idCliente FROM clienteAMI WHERE nombreCliente = '" + nombre + "' AND apellidosCliente = '" + apellidos + "' AND emailCliente = '" + email + "' AND dniCliente = '" + dni + "' AND claveCliente = '" + clave + "'");
			if (resultado.next()) 
			{
			    id = resultado.getInt("idCliente");
			}
			resultado.close();
			sentencia.close();
		} 
		catch (ClassNotFoundException cnfe) 
		{
			System.out.println("Error al activar el conector SQL");
		}
		catch (SQLException sqle) 
		{
			System.out.println("Error en la sentencia SQL: " + sqle.toString());
		}
		return id;
	}
	
	public String leerCliente(int idCliente, String campo)
	{
		String informacion = "";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sourceURL = "jdbc:mysql://localhost/hotelAMI";
			Connection dbcon = DriverManager.getConnection(sourceURL, "root", "Mr9+agar");
			Statement sentencia = dbcon.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT " + campo + " FROM clienteAMI WHERE idCliente = " + idCliente);
			if (resultado.next()) 
			{
			    informacion = resultado.getString(campo);
			}
			else
			{
				informacion = "Error: no existe ningún cliente con id " + idCliente;
			}
			resultado.close();
			sentencia.close();
		} 
		catch (ClassNotFoundException cnfe) 
		{
			System.out.println("Error al activar el conector SQL");
		}
		catch (SQLException sqle) 
		{
			System.out.println("Error en la sentencia SQL: " + sqle.toString());
		}
		return informacion;
	}
	
	public boolean actualizarCliente(int idCliente, String campo, String nuevoValor)
	{
		boolean finalizado = true;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sourceURL = "jdbc:mysql://localhost/hotelAMI";
			Connection dbcon = DriverManager.getConnection(sourceURL, "root", "Mr9+agar");
			Statement sentencia = dbcon.createStatement();
			String comando = "UPDATE clienteAMI SET " + campo + " = '" + nuevoValor + "' WHERE idCliente = " + idCliente;
			int confirmacion = sentencia.executeUpdate(comando);
			if(confirmacion == 0)
			{
				finalizado = false;
			}
			sentencia.close();
		} 
		catch (ClassNotFoundException cnfe) 
		{
			System.out.println("Error al activar el conector SQL");
		}
		catch (SQLException sqle) 
		{
			System.out.println("Error en la sentencia SQL: " + sqle.toString());
		}
		return finalizado;
	}
	
	public boolean eliminarCliente(int idCliente)
	{
		boolean finalizado = true;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sourceURL = "jdbc:mysql://localhost/hotelAMI";
			Connection dbcon = DriverManager.getConnection(sourceURL, "root", "Mr9+agar");
			Statement sentencia = dbcon.createStatement();
			String comando = "DELETE FROM clienteAMI WHERE idCliente = " + idCliente;
			int confirmacion = sentencia.executeUpdate(comando);
			if(confirmacion == 0)
			{
				finalizado = false;
			}
			sentencia.close();
		} 
		catch (ClassNotFoundException cnfe) 
		{
			System.out.println("Error al activar el conector SQL");
		}
		catch (SQLException sqle) 
		{
			System.out.println("Error en la sentencia SQL: " + sqle.toString());
		}
		return finalizado;
	}
}
