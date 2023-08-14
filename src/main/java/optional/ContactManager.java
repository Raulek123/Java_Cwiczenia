package optional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ContactManager {
    private Set<Contact> contacts = new HashSet<>();

    void addContact(Contact contact) {
        contacts.add(contact);
    }

    Contact findByEmail(String email) {
        if (email == null)
            throw new NullPointerException("email cannot be null");
        for (Contact contact : contacts) {
            if (email.equals(contact.getEmail()))
                return contact;
        }
        return null;
    }

    List<Contact> findByLastName(String textFragment) {
        if (textFragment == null)
            throw new NullPointerException("search text cannot be null");
        List<Contact> foundContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getLastName().contains(textFragment))
                foundContacts.add(contact);
        }
        return foundContacts;
    }
}