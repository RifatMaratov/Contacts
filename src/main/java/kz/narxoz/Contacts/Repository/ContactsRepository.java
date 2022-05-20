package kz.narxoz.Contacts.Repository;

import kz.narxoz.Contacts.Entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface ContactsRepository extends JpaRepository<Contacts, Long> {
}
