package com.ts;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.dao.ConcertDAO;
import com.dao.OrganiserDAO;
import com.dao.TutorDAO;
import com.dao.UserDAO;
import com.dto.ConcertDetails;
import com.dto.OrganiserDetails;
import com.dto.TutorDetails;
import com.dto.UserDetails;
import com.ts.db.HibernateTemplate;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @Path("hi")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hi() throws UnsupportedEncodingException {
		System.out.println("Hi...");
		return "Hi Service!";
	}
    
    @Path("registerUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerUser(UserDetails user) {
		System.out.println("Data Recieved in User Register : " + user);
		
		UserDAO userDao = new UserDAO();
		userDao.register(user);
	
	}
    
   
    
   @Path("loginUser/{email}/{password}")
   @GET
   
   public Object loginUser(@PathParam("email") String email,@PathParam("password") String password){
	   UserDAO userDao = new UserDAO();
	   System.out.println(email+" "+password);
	   return userDao.loginUser(email,password);
   }
   @Path("registerTutor")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerTutor(TutorDetails tutor) {
		System.out.println("Data Recieved in User Register : " + tutor);
		
		TutorDAO tutorDao = new TutorDAO();
		tutorDao.register(tutor);
	
	}
   @Path("loginTutor/{email}/{password}")
   @GET
   
   public Object loginTutor(@PathParam("email") String email,@PathParam("password") String password){
	   TutorDAO tutorDao = new TutorDAO();
	   System.out.println(email+" "+password);
	   return tutorDao.loginTutor(email,password);
   }
   @Path("uploadConcerts")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadConcerts(@FormDataParam("concertImage") InputStream fileInputStream,@FormDataParam("concertImage") FormDataContentDisposition
	formDataContentDisposition, @FormDataParam("concertName") String concertName, @FormDataParam("concertDescription") String concertDescription) throws IOException {; 
		int read = 0;
		byte[] bytes = new byte[1024];
		
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		String pathArr[] = path.split("/WEB-INF/classes/");
		
		FileOutputStream out = new FileOutputStream(new File(pathArr[0]+"/image/", formDataContentDisposition.getFileName()));
				
				
		while((read = fileInputStream.read(bytes)) != -1){	
			
			out.write(bytes,0,read);
		}
		out.flush();
		out.close();
		
		ConcertDetails concert = new ConcertDetails();
		concert.setConcertName(concertName);
		concert.setConcertDescription(concertDescription);
		concert.setConcertImage(formDataContentDisposition.getFileName());
		ConcertDAO concertDao = new ConcertDAO();
		concertDao.addconcert(concert);
	}
  @Path("getConcerts")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ConcertDetails> getConcerts() {

		ConcertDAO concertDAO = new ConcertDAO();
		List <ConcertDetails> concertList = concertDAO.getAllConcertDetails();

		return concertList;
	}
  @Path("getTutor/{role}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TutorDetails> getHandymans(@PathParam("role") String role){
		TutorDAO handy = new TutorDAO();
		List <TutorDetails> itemList = handy.getTutorsByRole(role);
		return itemList;
		
	}

 /* @Path("mail/{emailId}")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String mail(@PathParam("emailId") String emailId) throws MessagingException {
		System.out.println("hi sowmya ch");
String subject="Test Mail";
String body="Java mail test...";
String email=emailId;
String host = "smtp.gmail.com";
String from = "aparna8222@gmail.com";
String pass = "nagendraV";

Properties props = System.getProperties();

props.put("mail.smtp.starttls.enable", "true"); // added this line
props.put("mail.smtp.host", host);
props.put("mail.smtp.user", from);
props.put("mail.smtp.password", pass);
props.put("mail.smtp.port", "587");
props.put("mail.smtp.auth", "true");

String[] to = {email}; // added this line

Session session = Session.getDefaultInstance(props, null);
MimeMessage message = new MimeMessage(session);
message.setFrom(new InternetAddress(from));

InternetAddress[] toAddress = new InternetAddress[to.length];

// To get the array of addresses

for( int i=0; i < to.length; i++ )
{
// changed from a while loop
toAddress[i] = new InternetAddress(to[i]);
}

for( int i=0; i < toAddress.length; i++)
{
// changed from a while loop
message.addRecipient(Message.RecipientType.TO, toAddress[i]);
}

message.setSubject(subject);
message.setText(body);

Transport transport = session.getTransport("smtp");

transport.connect(host, from, pass);
transport.sendMessage(message, message.getAllRecipients());

transport.close();

      return "Successful";
  }*/
  @Path("getTutorDetails/{artform}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TutorDetails> getTutorDetails(@PathParam("artform") String artform){
		TutorDAO tutor = new TutorDAO();
		List <TutorDetails> itemList = tutor.getHandymanByRole(artform);
		//System.out.println("reshma luv u");
		return itemList;
		
	}
  @Path("getOrganiserDetails/{tutorMail}")
 	@GET
 	@Produces(MediaType.APPLICATION_JSON)
 	public List<OrganiserDetails> getOrganiserDetails(@PathParam("tutorMail") String tutorMail){
 		OrganiserDAO organiser = new OrganiserDAO();
 		List <OrganiserDetails> itemList = organiser.getOrganiserByRole(tutorMail);
 		//System.out.println("reshma luv u");
 		return itemList;
 		
 	}
  
  @Path("book")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void book(OrganiserDetails category) {
		System.out.println("Data Recieved in category : " + category);
		OrganiserDAO categoryDao = new OrganiserDAO();
		categoryDao.register(category);
	}
  @Path("delete/{organiserId}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("organiserId") int organiserId){
		System.out.println("Data Recieved in delete : " + organiserId);
		HibernateTemplate.delete(organiserId);
		System.out.println("Successfull Deletion");
	}
  @Path("confirm/{name}/{mail}/{note}")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String confirm(@PathParam("name") String name ,@PathParam("mail") String mail ,@PathParam("note") String note) throws MessagingException {
		String subject="Confirmation Mail";
		String body= "Dear"+" "+name+" "+";"+"Your Booking slot was"+note;
		String email= mail;
		String host = "smtp.gmail.com";
		String from = "aparna8222@gmail.com";
		String pass = "nagendraV";

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true"); // added this line
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		String[] to = {email}; // added this line

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));

		InternetAddress[] toAddress = new InternetAddress[to.length];

		// To get the array of addresses

		for( int i=0; i < to.length; i++ )
		{
			// changed from a while loop
			toAddress[i] = new InternetAddress(to[i]);
		}

		for( int i=0; i < toAddress.length; i++)
		{
			// changed from a while loop
			message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		}

		message.setSubject(subject);
		message.setText(body);

		Transport transport = session.getTransport("smtp");

		transport.connect(host, from, pass);
		transport.sendMessage(message, message.getAllRecipients());

		transport.close();
		System.out.println("Working");
      return "Successful";
  	}
  @Path("updateUser")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Object updateUser(UserDetails editUser) {
		System.out.println("Data Recieved to Update : " + editUser);
		UserDAO userDao = new UserDAO();
		return userDao.update(editUser);
	}

}