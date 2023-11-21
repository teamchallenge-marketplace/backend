package ua.com.marketplace.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import ua.com.marketplace.backend.model.enums.UserRole;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    @Indexed(unique = true)
    private String email;

    private String password;

    //orders

    //sellerInfo

    private Set<UserRole> userRoles;

    private Date dateCreated;

    private Date dateUpdated;

}
