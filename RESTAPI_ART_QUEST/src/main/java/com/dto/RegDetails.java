package com.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
public class RegDetails {
	@Id@GeneratedValue
	private int regId;

	
	@ManyToOne
	@JoinColumn(name = "tutorId")
	private TutorDetails tutorDetails;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserDetails userDetails;

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	public TutorDetails getTutorDetails() {
		return tutorDetails;
	}

	public void setTutorDetails(TutorDetails tutorDetails) {
		this.tutorDetails = tutorDetails;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
	
}