package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class TutorDetails {
	@Id@GeneratedValue
	private int tutorId;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String password;
	private String street;
	private String city;
	private String pincode;
	private String state;
	private String artform;
	private String typeOfart;
	private String durationOfCourse;
	private String fee;
	private int ratings;
	
	@OneToMany(mappedBy = "tutorDetails",fetch=FetchType.LAZY)
	List<RegDetails> regDetails = new ArrayList<RegDetails>();
	
	
	@OneToMany(mappedBy = "tutorDetails",fetch=FetchType.LAZY)
	List<ConcertDetails> concertDetails = new ArrayList<ConcertDetails>();
	
	

	public int getTutorId() {
		return tutorId;
	}


	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
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


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmailId(String email) {
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


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	

	public String getArtform() {
		return artform;
	}


	public void setArtform(String artform) {
		this.artform = artform;
	}


	public String getTypeOfart() {
		return typeOfart;
	}


	public void setTypeOfart(String typeOfart) {
		this.typeOfart = typeOfart;
	}


	public String getDurationOfCourse() {
		return durationOfCourse;
	}


	public void setDurationOfCourse(String durationOfCourse) {
		this.durationOfCourse = durationOfCourse;
	}


	public String getFee() {
		return fee;
	}


	public void setFee(String fee) {
		this.fee = fee;
	}


	public int getRatings() {
		return ratings;
	}


	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	

	public List<RegDetails> getRegDetails() {
		return regDetails;
	}


	public void setRegDetails(List<RegDetails> regDetails) {
		this.regDetails = regDetails;
	}


	public List<ConcertDetails> getConcertDetails() {
		return concertDetails;
	}


	public void setConcertDetails(List<ConcertDetails> concertDetails) {
		this.concertDetails = concertDetails;
	}


	
	
}