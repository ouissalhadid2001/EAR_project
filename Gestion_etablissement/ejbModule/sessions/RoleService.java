package sessions;

import java.util.List;

import dao.IDAO;
import dao.IDaoLocal;
import dao.RoleDaoLocal;
import entities.Role;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Stateless
public class RoleService implements IDAO<Role>,RoleDaoLocal{
	@PersistenceContext
EntityManager em;
	@Override
	@PermitAll
	public boolean create(Role o) {
		// TODO Auto-generated method stub
				em.persist(o);
				return true;
	}

	@Override
	@PermitAll
	public boolean update(Role o) {
		Role r=em.find(Role.class, o.getId());
		r.setName(o.getName());
		em.merge(r);
		return true;
	}

	@Override
	@PermitAll
	public boolean delete(Role o) {
		em.remove(em.contains(o) ? o : em.merge(o));
return false;
	}

	@Override
	@PermitAll
	public Role findById(int id) {
		return em.find(Role.class, id);
	}

	@Override
	@PermitAll
	public List<Role> findAll() {
Query query=em.createQuery("select r from Role r");
		return query.getResultList();
	}

	

}
