package dto;

public class Order {

	public String idCompra;
	public String idProducto;
	public String idProveedor;
	public String cantidad;
	public String tiempoEstimado;
	public String tipo;
	public float monto;
	private boolean urgencia;
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the monto
	 */
	public float getMonto() {
		return monto;
	}
	/**
	 * @param monto the monto to set
	 */
	public void setMonto(float monto) {
		this.monto = monto;
	}
	/**
	 * @return the idCompra
	 */
	public String getIdCompra() {
		return idCompra;
	}
	/**
	 * @param idCompra the idCompra to set
	 */
	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}
	/**
	 * @return the idProducto
	 */
	public String getIdProducto() {
		return idProducto;
	}
	/**
	 * @param idProducto the idProducto to set
	 */
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	/**
	 * @return the idProveedor
	 */
	public String getIdProveedor() {
		return idProveedor;
	}
	/**
	 * @param idProveedor the idProveedor to set
	 */
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	/**
	 * @return the cantidad
	 */
	public String getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the tiempoEstimado
	 */
	public String getTiempoEstimado() {
		return tiempoEstimado;
	}
	/**
	 * @param tiempoEstimado the tiempoEstimado to set
	 */
	public void setTiempoEstimado(String tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}
	/**
	 * @return the urgencias
	 */
	public boolean isUrgencia() {
		return urgencia;
	}
	/**
	 * @param urgencias the urgencias to set
	 */
	public void setUrgencia(boolean urgencia) {
		this.urgencia = urgencia;
	}
	
}
