package ua.com.marketplace.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Document(collection = "manufacturers")
public class SellerInfo {

    @Id
    private String id;

    @Indexed(unique = true)
    private String sellerName;

    private String about;

    private Set<OfficeContacts> contacts;

    private String contactEmail;

    private String officeAddress;

    private Double rating;


    public void addContact(OfficeContacts officeContact) {
        if (contacts == null)
            contacts = new HashSet<>();

        contacts.add(officeContact);
    }

}
