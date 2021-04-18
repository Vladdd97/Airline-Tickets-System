package com.airiline.tickets.domain.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CountryCode {
    ALBANIA("Albania (+355)"),
    ANDORRA("Andorra (+376)"),
    ARMENIA("Armenia (+374)"),
    AUSTRIA("Austria (+43)"),
    BELARUS("Belarus (+375)"),
    BELGIUM("Belgium (+32)"),
    BOSNIA_AND_HERZEGOVINA("Bosnia and Herzegovina (+387)"),
    BULGARIA("Bulgaria (+359)"),
    CROATIA("Croatia (+385)"),
    CYPRUS("Cyprus (+357)"),
    CZECH_REPUBLIC("Czech Republic (+420)"),
    DENMARK("Denmark (+45)"),
    ESTONIA("Estonia (+372)"),
    FAEROE_ISLANDS("Faeroe Islands (+298)"),
    FINLAND("Finland (+358)"),
    FRANCE("France (+33)"),
    GEORGIA("Georgia (+995)"),
    GERMANY("Germany (+49)"),
    GIBRALTAR("Gibraltar (+350)"),
    GREECE("Greece (+30)"),
    HUNGARY("Hungary (+36)"),
    ICELAND("Iceland (+354)"),
    REPUBLIC_OF_IRELAND("Republic of Ireland (+353)"),
    ITALY("Italy (+39)"),
    KOSOVO("Kosovo (+381)"),
    LATVIA("Latvia (+371)"),
    LIECHTENSTEIN("Liechtenstein (+423)"),
    LITHUANIA("Lithuania (+370)"),
    LUXEMBOURG("Luxembourg (+352)"),
    MALTA("Malta (+356)"),
    MOLDOVA("Moldova (+373)"),
    MONACO("Monaco (+377)"),
    MONTENEGRO("Montenegro (+382)"),
    NETHERLANDS("Netherlands (+31)"),
    NORTH_MACEDONIA("North Macedonia (+389)"),
    NORWAY("Norway (+47)"),
    POLAND("Poland (+48)"),
    PORTUGAL("Portugal (+351)"),
    ROMANIA("Romania (+40)"),
    RUSSIA("Russia (+7)"),
    SAN_MARINO("San Marino (+378)"),
    SERBIA("Serbia (+381)"),
    SLOVAKIA("Slovakia (+421)"),
    SLOVENIA("Slovenia (+386)"),
    SPAIN("Spain (+34)"),
    SWEDEN("Sweden (+46)"),
    SWITZERLAND("Switzerland (+41)"),
    TURKEY("Turkey (+90)"),
    UKRAINE("Ukraine (+380)"),
    UNITED_KINGDOM("United Kingdom (+44)"),
    VATICAN_CITY_STATE("Vatican City State (+39)");

    @JsonValue
    private final String label;
}
