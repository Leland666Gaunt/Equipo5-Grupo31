package Modelo;
public class productoDTO {
	private Integer codigo_producto;
	private Double ivacompra;
	private String nombre_producto;
	private Integer nitproveedor;
	private Double precio_compra;
	private Double precio_venta;



	public productoDTO(Integer codigo_producto, Double ivacompra, String nombre_producto, Integer nitproveedor,
			Double precio_compra, Double precio_venta) {
		super();
		this.codigo_producto = codigo_producto;
		this.ivacompra = ivacompra;
		this.nombre_producto = nombre_producto;
		this.nitproveedor = nitproveedor;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}



	public Integer getCodigo_producto() {
		return codigo_producto;
	}



	public void setCodigo_producto(Integer codigo_producto) {
		this.codigo_producto = codigo_producto;
	}



	public Double getIvacompra() {
		return ivacompra;
	}



	public void setIvacompra(Double ivacompra) {
		this.ivacompra = ivacompra;
	}



	public String getNombre_producto() {
		return nombre_producto;
	}



	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}



	public Integer getNitproveedor() {
		return nitproveedor;
	}



	public void setNitproveedor(Integer nitproveedor) {
		this.nitproveedor = nitproveedor;
	}



	public Double getPrecio_compra() {
		return precio_compra;
	}



	public void setPrecio_compra(Double precio_compra) {
		this.precio_compra = precio_compra;
	}



	public Double getPrecio_venta() {
		return precio_venta;
	}



	public void setPrecio_venta(Double precio_venta) {
		this.precio_venta = precio_venta;
	}
	
}