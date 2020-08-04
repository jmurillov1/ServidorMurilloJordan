package ec.edu.ups.appdis.ServidorMurilloJordan.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.appdis.ServidorMurilloJordan.model.Producto;

@Stateless
public class ProductoDAO {

	@PersistenceContext
	private EntityManager em;
	public void insertar(Producto t) {
		em.persist(t);
    }
	
	public Producto buscar(int codigo) {
		Producto pro = em.find(Producto.class, codigo);
		return pro;
    }
	
	public List<Producto> listar() {
		String jpql = "SELECT p FROM Producto p";
		Query q = em.createQuery(jpql, Producto.class);
		return q.getResultList();
	}
}
