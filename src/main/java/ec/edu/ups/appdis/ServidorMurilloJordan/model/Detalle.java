package ec.edu.ups.appdis.ServidorMurilloJordan.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Detalle implements Serializable{
	
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private int cantidad;
	private double subtotal;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_producto")
	private Producto producto;
	private int codigo2;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCodigo2() {
		return codigo2;
	}
	public void setCodigo2(int codigo2) {
		this.codigo2 = codigo2;
	}
	@Override
	public String toString() {
		return "Detalle [codigo=" + codigo + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", producto="
				+ producto + ", codigo2=" + codigo2 + "]";
	}
	

}
