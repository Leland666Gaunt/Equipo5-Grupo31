package Modelo;

public class ReportsDTO {
	private Long cedula;
	private String nombre;
	private Long valor_total;
	public ReportsDTO(Long cedula, String nombre, Long valor_total) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.valor_total = valor_total;
	}
	public Long getCedula() {
		return cedula;
	}
	public void setCedula(Long cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getValor_total() {
		return valor_total;
	}
	public void setValor_total(Long valor_total) {
		this.valor_total = valor_total;
	}
	
	
	

}
