package sessions;

import java.util.List;

import dao.IDAO;
import dao.IDaoLocal;
import dao.StudentDaoLocal;
import entities.Student;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Stateless
public class StudentService implements IDAO<Student>,StudentDaoLocal{
	@PersistenceContext
private EntityManager em;

@Override
@PermitAll
public boolean create(Student o) {
   em.persist(o);
	return true;
}

@Override
@PermitAll
public boolean update(Student o) {
	Student s=em.find(Student.class, o.getId());
	s.setFirstname(o.getFirstname());
	s.setLastname(o.getLastname());
	s.setField(o.getField());
	s.setLogin(o.getLogin());
	s.setMotdepasse(o.getMotdepasse());
	s.setTelephone(o.getMotdepasse());
	s.setRoles(o.getRoles());
	em.merge(s);
	return true;
}

@Override
@PermitAll
public boolean delete(Student o) {
	em.remove(em.contains(o) ? o : em.merge(o));
	return true;
}

@Override
@PermitAll
public Student findById(int id) {
	// TODO Auto-generated method stub
	return em.find(Student.class, id);
}

@Override
@PermitAll
public List<Student> findAll() {
	jakarta.persistence.Query query = em.createQuery("select s from Student s");
	return query.getResultList();	
}

@PermitAll
public List<Student> findByFiliere(String name) {
	
	List<Student> individus = null;
	individus = em
	              .createQuery("select s from Student s where s.field.name = ?1", Student.class)
	              .setParameter(1, name)
	              .getResultList();
	return individus;
}
}
