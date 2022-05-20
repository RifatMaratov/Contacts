package kz.narxoz.Contacts.Service.impl;

import kz.narxoz.Contacts.Entity.Contacts;
import kz.narxoz.Contacts.Repository.ContactsRepository;
import kz.narxoz.Contacts.Service.ContactServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactServiceInterface {

    @Autowired
    ContactsRepository contactRepository;

    @Override
    public List<Contacts> FindAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contacts saveContact(Contacts contact){
        return contactRepository.save(contact);
    }

    @Override
    public Contacts findById(Long id){

        return contactRepository.findById(id).orElse(null);

    }

    @Override
    public Contacts deleteContact(Long id) {
        contactRepository.deleteById(id);
        return null;
    }

}
