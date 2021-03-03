package com.airiline.tickets.domain.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum City {
    TIRANA("Tirana"),
    YEREVAN("Yerevan"),
    VIENNA("Vienna"),
    BAKU("Baku"),
    MINSK("Minsk"),
    BRUSSELS("Brussels"),
    SARAJEVO("Sarajevo"),
    SOFIA("Sofia"),
    ZAGREB("Zagreb"),
    NICOSIA("Nicosia"),
    PRAGUE("Prague"),
    COPENHAGEN("Copenhagen"),
    TALLINN("Tallinn"),
    HELSINKI("Helsinki"),
    PARIS("Paris"),
    TBILISI("Tbilisi"),
    BERLIN("Berlin"),
    ATHENS("Athens"),
    BUDAPEST("Budapest"),
    REYKJAVIK("Reykjavik"),
    DUBLIN("Dublin"),
    ROME("Rome"),
    PRISTINA("Pristina"),
    RIGA("Riga"),
    VADUZ("Vaduz"),
    VILNIUS("Vilnius"),
    LUXEMBOURG("Luxembourg"),
    VALLETTA("Valletta"),
    CHISINAU("Chisinau"),
    MONACO("Monaco"),
    PODGORICA("Podgorica"),
    AMSTERDAM("Amsterdam"),
    SKOPJE("Skopje"),
    OSLO("Oslo"),
    WARSAW("Warsaw"),
    LISBON("Lisbon"),
    BUCHAREST("Bucharest"),
    MOSCOW("Moscow"),
    BELGRADE("Belgrade"),
    BRATISLAVA("Bratislava"),
    LJUBLJANA("Ljubljana"),
    MADRID("Madrid"),
    STOCKHOLM("Stockholm"),
    BERN("Bern"),
    ANKARA("Ankara"),
    KYIV("Kyiv"),
    LONDON("London");

    @JsonValue
    private String label;
}
