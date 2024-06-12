package udelp.edu.ExamenFinal.Poo.model;

public class Paciente {

	private String rfc;
	private String nombre;
	private String padecimiento;
	private String fechaDeNacimiento;
	private String peso;
	private String estatura;
	public Paciente(String rfc, String nombre, String padecimiento, String fechaDeNacimiento, String peso,
			String estatura) {
		this.rfc = rfc;
		this.nombre = nombre;
		this.padecimiento = padecimiento;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.peso = peso;
		this.estatura = estatura;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPadecimiento() {
		return padecimiento;
	}
	public void setPadecimiento(String padecimiento) {
		this.padecimiento = padecimiento;
	}
	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getEstatura() {
		return estatura;
	}
	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}
	@Override
	public String toString() {
		return "Paciente [rfc=" + rfc + ", nombre=" + nombre + ", padecimiento=" + padecimiento + ", fechaDeNacimiento="
				+ fechaDeNacimiento + ", peso=" + peso + ", estatura=" + estatura + "]";
	}
	
	
	
	
	
	
}
