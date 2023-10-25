import component.ContactInitializer;
import component.FileSaver;
import config.AppConfig;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import model.Contact;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) throws IOException {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		String filePath = context.getBean(FileSaver.class).getFilepath();
		User user = new User();
		context.getBean(ContactInitializer.class).initialize(user);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String textFromConsole;
		System.out.println("Добро пожаловать в приложение для работы с контактами!");
		while (true) {
			System.out.println("""
					Введите текстовую команду, что хотите сделать:
					1) Добавить
					2) Распечатать
					3) Удалить
					4) Сохранить""");
			textFromConsole = reader.readLine();
			switch (textFromConsole) {
				case "Добавить":
					System.out.println(
							"Введите контакт в формате Ф. И. О.; номер телефона; адрес электронной почты");
					String contact = reader.readLine();
					user.addContact(contact);
					break;
				case "Распечатать":
					user.getContacts().forEach(System.out::println);
					break;
				case "Удалить":
					System.out.println("Введите email контакта, который хотите удалить");
					String email = reader.readLine();
					List<Contact> newContactList =
							user.getContacts().stream().filter(c -> !c.getEmail().equals(email))
									.toList();
					user.setContacts(newContactList);
					break;
				case "Сохранить":
					try {
						writeInFile(user.getContacts(), filePath);
					} catch (Exception e) {
						System.out.println("Ошибка! Контакты не сохранены, попробуйте еще раз.");
						break;
					}
					System.out.println("Контакты записаны в файлы");
					break;
			}
		}
	}

	private static void writeInFile(List<Contact> contacts, String file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Contact contact : contacts) {
			String formattedString = String.format("%s;%s;%s", contact.getFullName(), contact.getPhoneNumber(), contact.getEmail());
			writer.write(formattedString);
			writer.newLine();
		}
		writer.close();
	}

	private static void initializeContacts() {

	}
}
