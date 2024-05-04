package com.shepherdmoney.interviewproject.vo.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CreateUserPayload {
	private int id;
    private String email;
    
    private LocalDate dateOfBirth;

	private String fName;

	private String lName;

	private String password;

	private String mobileNo;

	private String addline1;

	private String addline2;

	private String addline3;

	private String city;

	private String state;

	private String country;

	private Long pinCode;

	private String ssn;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddline1() {
		return addline1;
	}

	public void setAddline1(String addline1) {
		this.addline1 = addline1;
	}

	public String getAddline2() {
		return addline2;
	}

	public void setAddline2(String addline2) {
		this.addline2 = addline2;
	}

	public String getAddline3() {
		return addline3;
	}

	public void setAddline3(String addline3) {
		this.addline3 = addline3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "CreateUserPayload [email=" + email + ", dateOfBirth=" + dateOfBirth + ", fName="
				+ fName + ", lName=" + lName + ", password=" + password + ", mobileNo=" + mobileNo + ", addline1="
				+ addline1 + ", addline2=" + addline2 + ", addline3=" + addline3 + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pinCode=" + pinCode + ", ssn=" + ssn + "]";
	}
	
	
}
