package com.airiline.tickets.dto.purchase;

import com.airiline.tickets.domain.common.enums.Country;
import com.airiline.tickets.domain.common.enums.Title;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
public class PassengerInfo {
    private Title title;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Past(message = "Date of birth cannot be in the future")
    private Date dateOfBirth;

    private Country citizenship;

    @NotNull
    private String passportNumber;

    @Future(message = "Passport expiration date cannot be in the past")
    private Date passportExpirationDate;

    private Country issuingCountry;

    private Country countryCode;

    @NotNull
    private String phone;

    @Email(message = "Email must be valid")
    private String email;
}
