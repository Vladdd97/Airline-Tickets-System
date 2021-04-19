package com.airiline.tickets.domain;

import com.airiline.tickets.domain.common.enums.Country;
import com.airiline.tickets.domain.common.enums.Title;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "passengers")
public class Passenger extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private Title title;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Country citizenship;

    @Column(unique = true)
    private String passportNumber;

    private Date passportExpirationDate;

    @Enumerated(EnumType.STRING)
    private Country issuingCountry;

    @Enumerated(EnumType.STRING)
    private Country countryCode;

    private String phone;
    private String email;
}
