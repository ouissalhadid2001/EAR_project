package sessions;

import java.util.List;

import dao.IDAO;
import dao.IDaoLocal;
import dao.UserDaoLocal;
import entities.User;
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
public class UserService implements IDAO<User>,UserDaoLocal{
	@PersistenceContext
private EntityManager em;

@Override
@PermitAll
public boolean create(User o) {
	em.persist(o);
	return true;
}

@Override
@PermitAll
public boolean update(User o) {
	User u=em.find(User.class, o.getId());
	u.setLogin(o.getLogin());
	u.setMotdepasse(o.getMotdepasse());
	u.setRoles(o.getRoles());
	return false;
}

@Override
@PermitAll
public boolean delete(User o) {
	em.remove(em.contains(o) ? o : em.merge(o));
	return true;
}

@Override
@PermitAll
public User findById(int id) {
	return em.find(User.class, id);
}

@Override
@PermitAll
public List<User> findAll() {
	Query query= em.createQuery("select u from User u");
	return query.getResultList();
}



}
