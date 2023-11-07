package sessions;

import java.util.List;

import dao.FieldDaoLocal;
import dao.IDAO;
import dao.IDaoLocal;
import entities.Field;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class FieldService implements IDAO<Field>,FieldDaoLocal {
	@PersistenceContext
	private EntityManager em;

	@Override
	@PermitAll
	public boolean create(Field o) {
		em.persist(o);
		return true;

	}

	@Override
	@PermitAll

	public boolean update(Field o) {
		Field f = em.find(Field.class, o.getId());
		f.setCode(o.getCode());
		f.setName(o.getName());
		em.merge(f);
		return true;
	}

	@Override
	@PermitAll

	public boolean delete(Field o) {
		em.remove(em.contains(o) ? o : em.merge(o));
		return true;
	}

	@Override
	@PermitAll

	public Field findById(int id) {

		return em.find(Field.class, id);
	}

	@Override
	@PermitAll
	public List<Field> findAll() {
		jakarta.persistence.Query query = em.createQuery("select f from Field f");
		return query.getResultList();
	}

	

}
