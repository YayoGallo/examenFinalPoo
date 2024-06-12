package udelp.edu.ExamenFinal.Poo.model;

public class Agenda {

	 private Paciente paciente;

	 private Medico medico;

	 private String fechaCita;

	 private String horaDeCita;

	public Agenda(Paciente paciente, Medico medico, String fechaCita, String horaDeCita) {
		this.paciente = paciente;
		this.medico = medico;
		this.fechaCita = fechaCita;
		this.horaDeCita = horaDeCita;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getHoraDeCita() {
		return horaDeCita;
	}

	public void setHoraDeCita(String horaDeCita) {
		this.horaDeCita = horaDeCita;
	}

	@Override
	public String toString() {
		return "Agenda [paciente=" + paciente + ", medico=" + medico + ", fechaCita=" + fechaCita + ", horaDeCita="
				+ horaDeCita + "]";
	} 
	
	 
	 
}
