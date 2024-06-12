package udel.edu.ExamenFinalPoo.process;

import java.util.ArrayList;
import java.util.List;

import udelp.edu.ExamenFinal.Poo.model.Agenda;
import udelp.edu.ExamenFinal.Poo.model.Especialidad;
import udelp.edu.ExamenFinal.Poo.model.Medico;
import udelp.edu.ExamenFinal.Poo.model.Paciente;
import udelp.edu.PooGrafico.model.Estudiante;

public class ControlHospital {

	public List<Medico> medicos;
	public List<Especialidad> especialidades;
	public List<Paciente> pacientes;
	public List<Agenda> citas;

	public void iniciarEspecialidades() {
		especialidades = new ArrayList<Especialidad>();
		Especialidad especialidad = new Especialidad("Cardiologia");
		Especialidad especialidad1 = new Especialidad("Cancerologia");
		Especialidad especialidad2 = new Especialidad("Citologia");
		Especialidad especialidad3 = new Especialidad("Trauma");
		Especialidad especialidad4 = new Especialidad("Urgencias");
		especialidades.add(especialidad);
		especialidades.add(especialidad1);
		especialidades.add(especialidad2);
		especialidades.add(especialidad3);
		especialidades.add(especialidad4);
	}

	public void altaMedico(Medico medico) {

		if (null != medicos) {
			medicos.add(medico);
		} else if (null == existeMedico(medico.getCedula())) {
			medicos = new ArrayList<Medico>();
			medicos.add(medico);
		}

	}

	public void altaPaciente(Paciente paciente) {

		if (null != pacientes) {
			pacientes.add(paciente);
		} else if (null == existePaciente(paciente.getRfc())) {
			pacientes = new ArrayList<Paciente>();
			pacientes.add(paciente);
		}

	}
	
	public void altaCita(Agenda cita) {

		if (null != citas) {
			citas.add(cita);
		} else  {
			citas = new ArrayList<Agenda>();
			citas.add(cita);
		}

	}

	public String mostrarEspecialidades() {
		String respuesta = "";
		int paso = 0;
		for (Especialidad especialidad : especialidades) {
			respuesta += "(" + paso + ")" + especialidad.getNombre() + "\n";
			paso++;
		}
		return respuesta;
	}

	public Medico existeMedico(String cedula) {

		if (medicos != null) {
			for (int i = 0; i < medicos.size(); i++) {
				if (medicos.get(i).getCedula().equals(cedula)) {

					return medicos.get(i);
				}
			}
		}
		return null;
	}

	public Paciente existePaciente(String rfc) {

		if (pacientes != null) {
			for (int i = 0; i < pacientes.size(); i++) {
				if (pacientes.get(i).getRfc().equals(rfc)) {

					return pacientes.get(i);
				}
			}
		}
		return null;
	}

	public List<Medico> medicosDeEspecialidad(Especialidad especialidad) {

		if (medicos != null) {
			List<Medico> aux = new ArrayList<Medico>();
			for (int i = 0; i < medicos.size(); i++) {
				if (medicos.get(i).getEspecialidades().contains(especialidad)) {
					aux.add(medicos.get(i));
				}
			}

			return aux;
		}
		return null;

	}

	public String mostrarMedicos(List<Medico> medicosAux) {

		String respuesta = "Numero\t|Cedula\t|Nombre\n";
		int paso = 0;

		if (null != medicosAux) {

			for (Medico medico : medicosAux) {

				respuesta += paso + "\t|" + medico.getCedula() + "\t|" + medico.getNombre();

			}

			return respuesta;

		} else if (null != medicos) {

			for (Medico medico : medicos) {

				respuesta += paso + "\t|" + medico.getCedula() + "\t|" + medico.getNombre();

			}
			
			return respuesta;

		}
		
		return "No hay coincidencias";

	}
	
	public boolean citaDis(Agenda cita1) {
		
		if (null!=citas) {
			
			for (Agenda cita: citas) {
				
				if(cita1.getMedico().equals(cita.getMedico()) && cita1.getHoraDeCita().equals(cita.getHoraDeCita()) && cita1.getFechaCita().equals(cita.getFechaCita())) {
					
					return false;
					
				}
				
				return true;
				
			}
			
		}
		
		return true;
		
	}
	
	public void imprimirPacientes() {
		if (null != pacientes) {
			for (Paciente paciente : pacientes) {
				System.out.println(paciente + "\n");
			}
		}
	}
	
	public void imprimirMedicos() {
		if (null != medicos) {
			for (Medico medico : medicos) {
				System.out.println(medico + "\n");
			}
		}
	}
	
	public void imprimirAgenda() {
		if (null != citas) {
			for (Agenda cita : citas) {
				System.out.println(cita + "\n");
			}
		}
	}
	
	public void imprimirEspecialidades() {
		if (null != especialidades) {
			for (Especialidad esp : especialidades) {
				System.out.println(esp + "\n");
			}
		}
	}

}
