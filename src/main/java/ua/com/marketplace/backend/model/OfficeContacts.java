package ua.com.marketplace.backend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OfficeContacts {

    private String phoneNumber;

    private String officeCity;

}
