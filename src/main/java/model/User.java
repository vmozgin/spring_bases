package model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private List<Contact> contacts = new ArrayList<>();

	public List<Contact> getContacts() {
		return contacts;
	}

	public User setContacts(List<Contact> contacts) {
		this.contacts = contacts;
		return this;
	}

	public void addContact(String value) {
		String[] contacts = value.split(";");
		Contact contact = new Contact();
		try {
			contact.setFullName(contacts[0].trim());
			contact.setPhoneNumber(contacts[1].trim());
			contact.setEmail(contacts[2].trim());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Ошибка! Введите данные в правильном формате, пример: "
					+ "\"Иванов Иван Иванович; +890999999; someEmail@example.example\"");
		}
		this.contacts.add(contact);
	}
}
