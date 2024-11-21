package dto;

public class PurchaseRequest {
	public String idCompra;
	public String idProducto;
	public String idProveedor;
	public String cantidad;
	public String tiempoEstimado;
	public String tipo;
	public float monto;
	private boolean urgencias;
	
	public String getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public boolean isUrgencias() {
		return urgencias;
	}

	public void setUrgencias(boolean urgencias) {
		this.urgencias = urgencias;
	}
	

}
