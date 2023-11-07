package test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDAO;
import entities.Field;
import entities.Role;
import entities.Student;
import entities.User;

public class Connexion {
	public static IDAO<Student> lookUpStudentRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDAO<Student>) context.lookup("ejb:Gestion_etablissement_EAR/Gestion_etablissement/StudentService!dao.IDAO");

	}

	public static IDAO<Field> lookUpFieldRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDAO<Field>) context.lookup("ejb:Gestion_etablissement_EAR/Gestion_etablissement/FieldService!dao.IDAO");

	}

	public static IDAO<Role> lookUpRoleRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDAO<Role>) context.lookup("ejb:Gestion_etablissement_EAR/Gestion_etablissement/RoleService!dao.IDAO");

	}

	public static IDAO<User> lookUpUserRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);
		return (IDAO<User>) context.lookup("ejb:Gestion_etablissement_EAR/Gestion_etablissement/UserService!dao.IDAO");

	}
}
