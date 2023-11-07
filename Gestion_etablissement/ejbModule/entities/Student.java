package entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import jakarta.persistence.ManyToOne;
@Entity
@DiscriminatorValue("student")
public class Student extends User implements Serializable{
	private String firstname;
	private String lastname;
	private String telephone;
	@ManyToOne
	private Field field;
	
	public Student() {
		super();
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", telephone=" + telephone + ", field="
				+ field + "]";
	}
	
	
	
}
