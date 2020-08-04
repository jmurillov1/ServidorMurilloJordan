package ec.edu.ups.appdis.ServidorMurilloJordan.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.appdis.ServidorMurilloJordan.model.Detalle;
import ec.edu.ups.appdis.ServidorMurilloJordan.model.Producto;

@Stateless
public class DetalleDAO {

	@PersistenceContext
	private EntityManager em;
	public void insertar(Detalle t) {
		em.persist(t);
    }
	
	public void actualizar(Detalle t) {
		em.merge(t);
    }
	
	public List<Detalle> listar() {
		String jpql = "SELECT d FROM Detalle d";
		Query q = em.createQuery(jpql, Detalle.class);
		return q.getResultList();
	}
}
