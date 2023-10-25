package component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Contact;
import model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InitContactsInitializer implements ContactInitializer{

	@Value("${file.init}")
	private String filePath;

	@Override
	public void initialize(User user) throws IOException {
		List<Contact> contacts = new ArrayList<>();
		FileReader fileReader = new FileReader(filePath);
		Scanner scanner = new Scanner(fileReader);
		while (scanner.hasNextLine()) {
			String contactFromFile = scanner.nextLine();
			String[] contactsArray = contactFromFile.split(";");
			Contact contact = new Contact(contactsArray[0], contactsArray[1], contactsArray[2]);
			contacts.add(contact);
		}
		user.setContacts(contacts);
		fileReader.close();
		System.out.println("Контакты загружены из файла");
	}
}
