package com.airiline.tickets.dto.purchase;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class CreditCard {
    @NotNull
    private String cardHolderName;

    @CreditCardNumber(message = "Card number must be valid")
    private String cardNumber;

    @Future(message = "Card expiration date cannot be in the past")
    private Date cardExpirationDate;

    @Pattern(regexp = "[0-9]+", message = "Card cvv must contain only digits")
    @Size(min = 3, max = 4, message = "Card cvv must be between 3 and 4 digits")
    private String cardCvv;
}
