package udelp.edu.ExamenFinal.Poo.model;

import java.util.ArrayList;
import java.util.List;


public class Medico {
	
	private String cedula;
	private String nombre;
	private List<Especialidad> especialidades;
	private String horaInicio;
	private String horaFin;
	private List<String> horarios;
	
	public Medico(String cedula, String nombre, Especialidad especialidad, String horaInicio, String horaFin) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.especialidades =new ArrayList<Especialidad>();
		this.especialidades.add(especialidad);
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.horarios= darHorarios(horaInicio, horaFin);
		
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public void addEspecialidad(Especialidad especialidad) {
		this.especialidades.add(especialidad);
	}
	public List<String> getHorarios() {
		return horarios;
	}

	public List<String> darHorarios(String horaInicio, String horaFin) {

		if (horaInicio.length() == 5 && horaFin.length() == 5) {
			String[] partes = horaInicio.split(":");
			try {

				Integer horas = Integer.parseInt(partes[0]);
				String[] partes2 = horaInicio.split(":");
				Integer horas2 = Integer.parseInt(partes2[0]);
				List<String> aux= new ArrayList<String>();
				
				for(int i=0; i<=horas2-horas; i++) {
					
					aux.add(horas+":00"+"-"+(horas+1)+":00");
					
				}
				
				return aux;
			} catch (Exception e) {

				System.out.println("Fecha invalida");
			}
	
		}

		return null;
	}
	
	public String mostrarHorarios() {
		
		String respuesta="";
		int paso=0;
		if (null != horarios) {
			for (String horario : horarios) {
				respuesta="("+paso+")"+horario + "\n";
			}
			return respuesta;
		}
		
		return "Sin horarios";
	}

	@Override
	public String toString() {
		return "Medico [cedula=" + cedula + ", nombre=" + nombre + ", especialidades=" + especialidades
				+ ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + "]";
	}
	
}
