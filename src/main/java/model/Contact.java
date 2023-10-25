package model;

import java.util.Objects;

public class Contact {
	private String fullName;
	private String phoneNumber;
	private String email;

	public Contact() {
	}

	public Contact(String fullName, String phoneNumber, String email) {
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public Contact setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Contact setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Contact setEmail(String email) {
		this.email = email;
		return this;
	}

	@Override
	public String toString() {
		return String.format("%s | %s | %s", fullName, phoneNumber, email);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Contact contact = (Contact) o;
		return Objects.equals(fullName, contact.fullName) && Objects.equals(phoneNumber,
				contact.phoneNumber) && Objects.equals(email, contact.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fullName, phoneNumber, email);
	}
}
