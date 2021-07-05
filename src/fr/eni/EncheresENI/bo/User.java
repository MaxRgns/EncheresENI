package fr.eni.EncheresENI.bo;

public class User {
	private Integer idUser;
	private String firstname;
	private String lastname;
	private String mail;
	private String username;
	private Double credit;
	private String phone;
	private String street;
	private String postcode;
	private String city;
	private String password;
	
	public User() {
	}

	public User(String firstname, String lastname, String mail, String username, Double credit, String phone,
			String street, String postcode, String city, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.username = username;
		this.credit = credit;
		this.phone = phone;
		this.street = street;
		this.postcode = postcode;
		this.city = city;
		this.password = password;
	}

	public User(Integer idUser, String firstname, String lastname, String mail, String username, Double credit,
			String phone, String street, String postcode, String city, String password) {
		super();
		this.idUser = idUser;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.username = username;
		this.credit = credit;
		this.phone = phone;
		this.street = street;
		this.postcode = postcode;
		this.city = city;
		this.password = password;
	}
	
	
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", firstname=" + firstname + ", lastname=" + lastname + ", mail=" + mail
				+ ", username=" + username + ", credit=" + credit + ", phone=" + phone + ", street=" + street
				+ ", postcode=" + postcode + ", city=" + city + "]";
	}
	
}
