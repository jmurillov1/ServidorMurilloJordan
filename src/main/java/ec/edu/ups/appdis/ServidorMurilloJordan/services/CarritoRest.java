package ec.edu.ups.appdis.ServidorMurilloJordan.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.MarshalException;

import ec.edu.ups.appdis.ServidorMurilloJordan.model.Detalle;
import ec.edu.ups.appdis.ServidorMurilloJordan.model.Producto;
import ec.edu.ups.appsdis.ServidorMurilloJordan.business.CarritoON;

@Path("/carrito")
public class CarritoRest {

	@Inject
	private CarritoON carON;

	@GET
	@Path("/productos")
	@Produces("application/json")
	public List<Producto> listaProductos() throws MarshalException {

		List<Producto> listado = new ArrayList<Producto>();

		listado = carON.listado();
		return listado;
	}

	@POST
	@Path("/guardarProducto")
	@Produces("application/json")
	@Consumes("application/json")
	public String guardarCarrito(Producto producto) {
		// metodos que llaman al ON para realizar un deposito
		System.out.println(producto.toString());
		String res = "";
		try {
			carON.guardarProducto(producto);
			res = "Exito";
		} catch (Exception e) {
			res = "Error";
		}
		return res;
	}
	
	@POST
	@Path("/guardarCarrito")
	@Produces("application/json")
	@Consumes("application/json")
	public String guardarCabecera(Detalle detalle) {
		// metodos que llaman al ON para realizar un deposito
		System.out.println(detalle.toString());
		String res = "";
		try {
			carON.guardarCarrito(detalle);
			res = "Exito";
		} catch (Exception e) {
			res = "Error";
		}
		return res;
	}
	
	@GET
	@Path("/detalles")
	@Produces("application/json")
	public List<Detalle> listaDetalles() throws MarshalException {

		List<Detalle> listado = new ArrayList<Detalle>();

		listado = carON.listadoDetalles();
		return listado;
	}
	
	@GET
	@Path("/producto")
	@Produces("application/json")
	public Producto saludar(@QueryParam("codigo") int codigo) {
		return carON.buscar(codigo);
	}
}
