package com.ducat.entities;



import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Component
public class User {

	private int id;
	@Pattern(regexp="[a-z,A-Z]{2}[a-z,A-Z]*",message="Name can contain only alphabets min length 2.")
	private String name;
	@Email(message="MailId should be in proper format.")
	@NotBlank(message="MailId is required.")
	private String mailId;
	@Length(min=5, message="Must have at least 5 chars.")
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
