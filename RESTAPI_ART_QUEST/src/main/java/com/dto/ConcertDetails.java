package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@Entity
public class ConcertDetails {
	@Id@GeneratedValue
	private int concertId;
	private String concertName;
	private String concertImage;
	private String concertDescription;
	
	@ManyToOne
	@JoinColumn(name = "tutorId")
	private TutorDetails tutorDetails;
	
	@ManyToOne
	@JoinColumn(name = "organiserId")
	private OrganiserDetails organiserDetails;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserDetails userDetails;

	public int getConcertId() {
		return concertId;
	}

	public void setConcertId(int concertId) {
		this.concertId = concertId;
	}

	public String getConcertName() {
		return concertName;
	}

	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}

	public String getConcertImage() {
		return concertImage;
	}

	public void setConcertImage(String concertImage) {
		this.concertImage = concertImage;
	}

	public String getConcertDescription() {
		return concertDescription;
	}

	public void setConcertDescription(String concertDescription) {
		this.concertDescription = concertDescription;
	}

	public TutorDetails getTutorDetails() {
		return tutorDetails;
	}

	public void setTutorDetails(TutorDetails tutorDetails) {
		this.tutorDetails = tutorDetails;
	}

	public OrganiserDetails getOrganiserDetails() {
		return organiserDetails;
	}

	public void setOrganiserDetails(OrganiserDetails organiserDetails) {
		this.organiserDetails = organiserDetails;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	
	
}