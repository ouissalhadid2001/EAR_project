package test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.wildfly.security.password.spec.HashPasswordSpec;

import dao.IDAO;

import entities.Field;
import entities.Role;
import entities.Student;
import entities.User;

public class Test {

	public static void main(String[] args) {
		try {
			Connexion c = new Connexion();
			IDAO<Role> rdao = c.lookUpRoleRemote();
			IDAO<User> udao = c.lookUpUserRemote();
			IDAO<Field> fdao = c.lookUpFieldRemote();
			IDAO<Student> sdao = c.lookUpStudentRemote();
			System.out.println("1- Gestion des utilisateurs");
			System.out.println("2- Gestion des étudiants");
			System.out.println("3- Gestion des filieres");
			System.out.println("4- Gestion des roles");
			System.out.println("5- Affectation des roles");
			System.out.println("6- Etudiants par filieres");
			System.out.println("Entrer votre choix");
			int chx=-1;
			while(chx!=0) {
				
			
			Scanner sc = new Scanner(System.in);
			 chx = sc.nextInt();
			switch (chx) {
			case 2: {
				Student s1 = new Student(), s2 = new Student();
				s1.setFirstname("ouissal");
				s1.setLastname("hadid");
				s1.setLogin("s1");
				s1.setMotdepasse("123");
				s1.setTelephone("0000000000");
			}
				break;
			case 1: {
              User u1=new User();
              u1.setLogin("admin");
              u1.setMotdepasse("admin");
              udao.create(u1);
              System.out.println(udao.findAll());
			}

			case 3:{
				Field f1 = new Field(), f2 = new Field();
				f1.setCode("code1");
				f2.setCode("code2");
				f1.setName("IIR");
				f2.setName("GC");
				fdao.create(f1);
				fdao.create(f2);
				System.out.println(fdao.findAll());
			}break;
			case 4:{
				Role r1 = new Role();
				r1.setName("etudiant");
				rdao.create(r1);
				System.out.println(rdao.findAll());
			}break;
			case 5:{
				List<Role> roles = new ArrayList<Role>();
				roles.add(rdao.findById(1));
                sdao.findById(1).setRoles(roles);
                System.out.println(sdao.findAll());
			}break;
			
			default:
				break;
			}
			}
			

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
