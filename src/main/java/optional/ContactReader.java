package optional;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ContactReader {
    static ContactManager readFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            ContactManager contactManager = new ContactManager();
            while (scanner.hasNextLine()) {
                Contact contact = createContactFromText(scanner.nextLine());
                contactManager.addContact(contact);
            }
            return contactManager;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private static Contact createContactFromText(String text) {
        String[] data = text.split(";");
        return new Contact(data[0], data[1], data[2], data[3]);
    }
}