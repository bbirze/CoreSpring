package com.oaktreeair.ffprogram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("contact01")
public class ContactInfo {
	@Value("ssmith@gmail.com")
	private String emailAddress;
	
	@Value("214-506-7890")
	private String homePhone;
	
	@Value("214-506-7888")
	private String mobilePhone;
	
	@Value("214-506-7888")
	private String smsNumber;

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getSmsNumber() {
		return smsNumber;
	}
	public void setSmsNumber(String smsNumber) {
		this.smsNumber = smsNumber;
	}
	@Override
	public String toString() {
		return "ContactInfo [emailAddress=" + emailAddress + ", homePhone=" + homePhone + ", mobilePhone=" + mobilePhone
				+ ", smsNumber=" + smsNumber + "]";
	}
	
}
