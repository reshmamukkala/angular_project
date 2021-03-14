package com.dto;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class UserDetails {
	@Id@GeneratedValue
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String street;
	private String city;
	private String artform;
	
	@OneToMany(mappedBy = "userDetails",fetch=FetchType.LAZY)
	List<RegDetails> regDetails = new ArrayList<RegDetails>();
	
	//@OneToMany(mappedBy = "userDetails",fetch=FetchType.LAZY)
	//List<ConcertDetails> concertDetails = new ArrayList<ConcertDetails>();
	
	public UserDetails() {
		super();
	}

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getArtform() {
		return artform;
	}


	public void setArtform(String artform) {
		this.artform = artform;
	}


	public List<RegDetails> getRegDetails() {
		return regDetails;
	}


	public void setRegDetails(List<RegDetails> regDetails) {
		this.regDetails = regDetails;
	}

	
	
}