package practica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestHotelAMI 
{
	public static void main(String[] args) 
	{
		int seleccion;
		int seleccion_extra;
		Scanner teclado = new Scanner(System.in);
		ClientePersistenciaAMI operacion = new ClientePersistenciaAMI();
		int id;
		String nombre;
		String apellidos;
		String email;
		String dni;
		String clave;
		try
		{
			do 
			{
				System.out.println("¿Que quieres hacer?");
				System.out.println("1. Crear cliente");
				System.out.println("2. Leer cliente");
				System.out.println("3. Actualizar cliente");
				System.out.println("4. Eliminar cliente");
				System.out.println("5. Salir");
				seleccion = teclado.nextInt();
				teclado.nextLine();

				switch(seleccion)
				{
				case 1:
					System.out.println("Escriba su nombre: ");
					nombre = teclado.nextLine();
					System.out.println("Escriba sus apellidos: ");
					apellidos = teclado.nextLine();
					System.out.println("Escriba su email: ");
					email = teclado.nextLine();
					System.out.println("Escriba su dni: ");
					dni = teclado.nextLine();
					System.out.println("Escriba su clave: ");
					clave = teclado.nextLine();
					id = operacion.crearCliente(nombre.trim(), apellidos.trim(), email.trim(), dni.trim(), clave.trim());
					System.out.println("Cliente creado");
					System.out.println("Su id de cliente es: " + id);
					break;

				case 2:
					System.out.println("Introduzca su id de cliente: ");
					id = teclado.nextInt();
					teclado.nextLine();
					System.out.println("¿Qué campo quieres ver?");
					System.out.println("1. Nombre");
					System.out.println("2. Apellidos");
					System.out.println("3. Email");
					System.out.println("4. Dni");
					System.out.println("5. Clave");
					seleccion_extra = teclado.nextInt();
					teclado.nextLine();
					if(seleccion_extra == 1)
					{
						System.out.println(operacion.leerCliente(id, "nombreCliente"));
					}
					else if(seleccion_extra == 2)
					{
						System.out.println(operacion.leerCliente(id, "apellidosCliente"));
					}
					else if(seleccion_extra == 3)
					{
						System.out.println(operacion.leerCliente(id, "emailCliente"));
					}
					else if(seleccion_extra == 4)
					{
						System.out.println(operacion.leerCliente(id, "dniCliente"));
					}
					else if(seleccion_extra == 5)
					{
						System.out.println(operacion.leerCliente(id, "claveCliente"));
					}
					else
					{
						System.out.println("Error: el número " + seleccion_extra + " no es una opción valida");
					}
					break;

				case 3:
					System.out.println("Introduzca su id de cliente: ");
					id = teclado.nextInt();
					teclado.nextLine();
					System.out.println("¿Qué campo quieres editar?");
					System.out.println("1. Nombre");
					System.out.println("2. Apellidos");
					System.out.println("3. Email");
					System.out.println("4. Dni");
					System.out.println("5. Clave");
					seleccion_extra = teclado.nextInt();
					teclado.nextLine();
					if(seleccion_extra == 1)
					{
						System.out.println("Escriba el nuevo nombre: ");
						nombre = teclado.nextLine();
						if(operacion.actualizarCliente(id, "nombreCliente", nombre) == true)
						{
							System.out.println("Cambio realizado con exito");
						}
						else
						{
							System.out.println("Error: no se pudo actualizar el cliente");
						}
					}
					else if(seleccion_extra == 2)
					{
						System.out.println("Escriba los nuevos apellidos: ");
						apellidos = teclado.nextLine();
						if(operacion.actualizarCliente(id, "apellidosCliente", apellidos) == true)
						{
							System.out.println("Cambio realizado con exito");
						}
						else
						{
							System.out.println("Error: no se pudo actualizar el cliente");
						}
					}
					else if(seleccion_extra == 3)
					{
						System.out.println("Escriba el nuevo email: ");
						email = teclado.nextLine();
						if(operacion.actualizarCliente(id, "emailCliente", email) == true)
						{
							System.out.println("Cambio realizado con exito");
						}
						else
						{
							System.out.println("Error: no se pudo actualizar el cliente");
						}
					}
					else if(seleccion_extra == 4)
					{
						System.out.println("Escriba el nuevo dni: ");
						dni = teclado.nextLine();
						if(operacion.actualizarCliente(id, "dniCliente", dni) == true)
						{
							System.out.println("Cambio realizado con exito");
						}
						else
						{
							System.out.println("Error: no se pudo actualizar el cliente");
						}
					}
					else if(seleccion_extra == 5)
					{
						System.out.println("Escriba la nueva clave: ");
						clave = teclado.nextLine();
						if(operacion.actualizarCliente(id, "claveCliente", clave) == true)
						{
							System.out.println("Cambio realizado con exito");
						}
						else
						{
							System.out.println("Error: no se pudo actualizar el cliente");
						}
					}
					else
					{
						System.out.println("Error: el número " + seleccion_extra + " no es una opción valida");
					}
					break;

				case 4:
					System.out.println("Escriba el id del cliente a eliminar: ");
					id = teclado.nextInt();
					teclado.nextLine();
					System.out.println("¿Esta seguro de querer eliminar el cliente?");
					System.out.println("1. Sí");
					System.out.println("2. No");
					seleccion_extra = teclado.nextInt();
					teclado.nextLine();
					if(seleccion_extra == 1)
					{
						System.out.println("Eliminando cliente...");
						if(operacion.eliminarCliente(id) == true)
						{
							System.out.println("Cliente eliminado");
						}
						else
						{
							System.out.println("Error: no hay ningún cliente con id " + id);
						}
					}
					else if(seleccion_extra == 2)
					{
						System.out.println("Eliminación cancelada");
					}
					else
					{
						System.out.println("Error: el número " + seleccion_extra + " no es una opción valida");
					}
					break;
					
				case 5:
					System.out.println("Saliendo del programa.");
					break;

				default:
					System.out.println("El número " + seleccion + " no corresponde a ninguna opción");
				}
			} while (seleccion != 5);
		}
		catch (InputMismatchException ime)
		{
			System.out.println("Error: solo se aceptan números");
		}
		teclado.close();
	}
}
