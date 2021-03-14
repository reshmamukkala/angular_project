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
public class OrganiserDetails {
	@Id@GeneratedValue
	private int organiserId;
	private String name;
	private String email;
	private String telephone;
	private String subject;
	private String message;
	private String tutorMail;
	
	
	@OneToMany(mappedBy="organiserDetails",fetch = FetchType.LAZY)
	List<ConcertDetails> concertDetails = new ArrayList<ConcertDetails>();

	public int getOrganiserId() {
		return organiserId;
	}

	public void setOrganiserId(int organiserId) {
		this.organiserId = organiserId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTutorMail() {
		return tutorMail;
	}

	public void setTutorMail(String tutorMail) {
		this.tutorMail = tutorMail;
	}

	public void setConcertDetails(List<ConcertDetails> concertDetails) {
		this.concertDetails = concertDetails;
	}

	public List<ConcertDetails> getConcertDetails() {
		return concertDetails;
	}
	
}