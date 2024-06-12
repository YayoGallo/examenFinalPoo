package udel.edu.ExamenFinalPoo.main;

import java.util.List;
import java.util.Scanner;

import udel.edu.ExamenFinalPoo.process.ControlHospital;
import udel.edu.ExamenFinalPoo.process.Validaciones;
import udelp.edu.ExamenFinal.Poo.model.Agenda;
import udelp.edu.ExamenFinal.Poo.model.Especialidad;
import udelp.edu.ExamenFinal.Poo.model.Medico;
import udelp.edu.ExamenFinal.Poo.model.Paciente;

public class Principal {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		boolean repetir = true;
		Validaciones valida = new Validaciones();
		ControlHospital movimientos = new ControlHospital();
		String nombre, codigo,horaEntrada, horaSalida, opcion, padecimiento, fecha, peso, estatura;
		do {
			System.out.println(
					"Bienvenido a hospital\n1)Alta de medico\n2)Editar medico\n3)Alta de paciente\n4)Editar paciente\n5)Agendar cita\n6)Agenda del medico\n7)Salir\n8)Ver datos\nElige una opcion:");
			opcion = leer.nextLine();
			switch (valida.esByte(opcion)) {
			case 1:
				System.out.println("Alta de medico\n Ingresa la cedula");
				codigo=leer.nextLine();
				System.out.println("Ingresa el nombre");
				nombre=leer.nextLine();
				System.out.println("Ingresa el horario de entrada en formato 24 hrs con 0 min Ejemplo(08:00-09:00)");
				horaEntrada=leer.nextLine();
				System.out.println("Ingresa el horario de salida en formato 24 hrs con 0 min Ejemplo(08:00-09:00)");
				horaSalida=leer.nextLine();
				System.out.println("Selecciona una especialidad\n"+movimientos.mostrarEspecialidades());
				opcion=leer.nextLine();
				Medico medico =new Medico(codigo, nombre, movimientos.especialidades.get(valida.esByte(opcion)), horaEntrada, horaSalida);
				movimientos.altaMedico(medico);
				System.out.println("Si no se ha repetido la cedula, el medico se ha guardado");
				repetir=true;
				break;
			case 2:
				System.out.println("Editar medico\n Ingresa la cedula");
				codigo=leer.nextLine();
				if(null!=movimientos.existeMedico(codigo)) {
					Medico aux=movimientos.existeMedico(codigo);
					System.out.println("Ingresa el nombre");
					nombre=leer.nextLine();
					System.out.println("Ingresa el horario de entrada en formato 24 hrs con 0 min Ejemplo(08:00)");
					horaEntrada=leer.nextLine();
					System.out.println("Ingresa el horario de salida en formato 24 hrs con 0 min Ejemplo(08:00)");
					horaSalida=leer.nextLine();
					System.out.println("Agregar nueva especialidad? 1)y Otro)no");
					opcion=leer.nextLine();
					if (valida.esByte(opcion)==1) {
						System.out.println("Selecciona una especialidad\n"+movimientos.mostrarEspecialidades());
						opcion=leer.nextLine();
						aux.addEspecialidad(movimientos.especialidades.get(valida.esByte(opcion)));
						aux.setNombre(nombre);
						aux.setHoraInicio(horaEntrada);
						aux.setHoraFin(horaSalida);
						System.out.println("Medico modificado");
						repetir=true;
						break;
					}
					aux.setNombre(nombre);
					aux.setHoraInicio(horaEntrada);
					aux.setHoraFin(horaSalida);
					System.out.println("Medico modificado");
					repetir=true;
					break;
				}
				System.out.println("No se encontraron coincidencias");
				repetir=true;
				break;
			case 3:
				System.out.println("Alta de paciente\n Ingresa el rfc");
				codigo=leer.nextLine();
				System.out.println("Ingresa el nombre");
				nombre=leer.nextLine();
				System.out.println("Ingresa el padecimiento");
				padecimiento=leer.nextLine();
				System.out.println("Ingresa la fecha de nacimiento");
				fecha=leer.nextLine();
				System.out.println("Ingresa el peso");
				peso=leer.nextLine();
				System.out.println("Ingresa la estatura");
				estatura=leer.nextLine();
				Paciente paciente=new Paciente(codigo, nombre, padecimiento, fecha, peso, estatura);
				movimientos.altaPaciente(paciente);
				System.out.println("Si no se ha repetido el rfc, el paciente se ha dado de alta");
				repetir=true;
				break;
			case 4:
				System.out.println("Editar paciente\n Ingresa el rfc");
				codigo=leer.nextLine();
				if(null!=movimientos.existePaciente(codigo)) {
					Paciente aux=movimientos.existePaciente(codigo);
					System.out.println("Ingresa el nombre");
					nombre=leer.nextLine();
					System.out.println("Ingresa el padecimiento");
					padecimiento=leer.nextLine();
					System.out.println("Ingresa la fecha de nacimiento");
					fecha=leer.nextLine();
					System.out.println("Ingresa el peso");
					peso=leer.nextLine();
					System.out.println("Ingresa la estatura");
					estatura=leer.nextLine();
					aux.setNombre(nombre);
					aux.setPadecimiento(padecimiento);
					aux.setFechaDeNacimiento(fecha);
					aux.setPeso(peso);
					aux.setEstatura(estatura);
					System.out.println("Paciente modificado");
					repetir=true;
					break;
				}
				System.out.println("No se encontraron coincidencias");
				repetir=true;
				break;
			case 5:
				System.out.println("Generar cita \n Ingrese el rfc del paciente");
				codigo=leer.nextLine();
				if(null!=movimientos.existePaciente(codigo)) {
					
					Paciente pacienteAux = movimientos.existePaciente(codigo);
					System.out.println("Selecciona una especialidad\n"+movimientos.mostrarEspecialidades());
					opcion=leer.nextLine();
					Especialidad especialidadAux = movimientos.especialidades.get(valida.esByte(opcion));
					
					if (null!= movimientos.medicosDeEspecialidad(especialidadAux)) {
						List<Medico> auxMedicos= movimientos.medicosDeEspecialidad(especialidadAux);
						System.out.println(movimientos.mostrarMedicos(auxMedicos)+"\n Ingresa la cedula del medico");
						codigo=leer.nextLine();
						if (null!=movimientos.existeMedico(codigo)) {
							
							Medico medicoAux = movimientos.existeMedico(codigo);
							System.out.println("Elige el horario"+medicoAux.mostrarHorarios());
							opcion=leer.nextLine();
							System.out.println("Ingresa la fecha de la cita");
							fecha=leer.nextLine();
							
							Agenda cita=new Agenda(pacienteAux, medicoAux, fecha, medicoAux.getHorarios().get(valida.esByte(opcion)));
							
							if (movimientos.citaDis(cita)) {
								
								movimientos.altaCita(cita);
								System.out.println("Cita guardada con exito");
								repetir=true;
								break;
							}
							
							System.out.println("Cita no disponible");
						}
						System.out.println("No se encontro el medico");
					}
					System.out.println("No se encontraron medicos de la especialidad");
				}
				repetir=true;
				break;
			case 6:
				
				System.out.println("Ya no termine");
				
				repetir=true;
				break;
			case 7:
				System.out.println("Adios");
				repetir=false;
				break;
			case 8:
				movimientos.imprimirAgenda();
				movimientos.imprimirEspecialidades();
				movimientos.imprimirMedicos();
				movimientos.imprimirPacientes();
				repetir=true;
				break;	
			default:
				System.out.println("Elige una opcion del menu");
				repetir=true;
				break;
			}
		} while (repetir);

	}

}
