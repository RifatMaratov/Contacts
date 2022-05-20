package kz.narxoz.Contacts.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Contacts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name =  "full_name", nullable = false)
    private String fullName;

    @Column(name =  "phone_number", nullable = false)
    private String phone_number;


}
