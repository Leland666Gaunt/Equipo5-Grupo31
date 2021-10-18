
package Modelo;


public class providerDTO {
	
		private long NIT;
		private String ciudad;
		private String direccion;
		private String nombre;
		private String telefono;
		
		
		public providerDTO(long NIT, String ciudad, String direccion, String nombre, String telefono) {
			super();
			this.NIT = NIT;
			this.ciudad = ciudad;
			this.direccion = direccion;
			this.nombre = nombre;
			this.telefono = telefono;
		}


		public long getNIT() {
			return NIT;
		}


		public void setNIT(long nIT) {
			NIT = nIT;
		}


		public String getCiudad() {
			return ciudad;
		}


		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}


		public String getDireccion() {
			return direccion;
		}


		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}


}

