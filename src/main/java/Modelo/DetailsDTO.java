package Modelo;

public class DetailsDTO {
	private Long code_detail;
	private Long amount;
	private Long code_producto;
	private Long code_sale;
	private Double total;
	private Double sale;
	private Double totalIva;
	



	public DetailsDTO(Long amount, Long code_producto, Double total, Double sale, Double totalIva) {
		super();
		this.amount = amount;
		this.code_producto = code_producto;
		this.total = total;
		this.sale = sale;
		this.totalIva = totalIva;
	}

	public Long getCode_detail() {
		return code_detail;
	}

	public void setCode_detail(Long code_detail) {
		this.code_detail = code_detail;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getCode_producto() {
		return code_producto;
	}

	public void setCode_producto(Long code_producto) {
		this.code_producto = code_producto;
	}

	public Long getCode_sale() {
		return code_sale;
	}

	public void setCode_sale(Long code_sale) {
		this.code_sale = code_sale;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getSale() {
		return sale;
	}

	public void setSale(Double sale) {
		this.sale = sale;
	}

	public Double getTotaliva() {
		return totalIva;
	}

	public void setTotaliva(Double totaliva) {
		this.totalIva = totaliva;
	}
	
	
	
	

}
