package ec.edu.ups.appsdis.ServidorMurilloJordan.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.ServidorMurilloJordan.data.DetalleDAO;
import ec.edu.ups.appdis.ServidorMurilloJordan.data.ProductoDAO;
import ec.edu.ups.appdis.ServidorMurilloJordan.model.Detalle;
import ec.edu.ups.appdis.ServidorMurilloJordan.model.Producto;
@Stateless
public class CarritoON {

	@Inject
	private ProductoDAO pdao;
	@Inject
	private DetalleDAO ddao;

	public void guardarProducto(Producto producto) {
		pdao.insertar(producto);
	}
	
	public List<Producto> listado(){
		return pdao.listar();
	}
	
	public void guardarCarrito(Detalle d) {
		for (Detalle item : listadoDetalles()) {
			if(item.getProducto().getCodigo()==d.getProducto().getCodigo()) {
				Detalle det = new Detalle();
				det.setCodigo(d.getCodigo());
				det.setCantidad(d.getCantidad()+item.getCantidad());
				det.setSubtotal(d.getSubtotal()+item.getSubtotal());
				det.setProducto(d.getProducto());
				det.setCodigo2(d.getCodigo2());
			}else {
				ddao.insertar(d);
			}
		}
	}
	
	public List<Detalle> listadoDetalles(){
		return ddao.listar();
	}
	
	public Producto buscar(int codigo) {
		return pdao.buscar(codigo);
	}

}
