package kz.narxoz.Contacts.Service;

import kz.narxoz.Contacts.Entity.Contacts;

import java.util.List;

public interface ContactServiceInterface {
    List<Contacts> FindAllContacts();
    Contacts saveContact(Contacts contact);
    Contacts findById(Long id);
    Contacts deleteContact(Long id);

}
