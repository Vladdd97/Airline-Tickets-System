package com.airiline.tickets.mapper;

import com.airiline.tickets.domain.Passenger;
import com.airiline.tickets.dto.purchase.PassengerInfo;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface PassengerMapper {
    PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);

    Passenger passengerInfoToPassenger(PassengerInfo passengerInfo);
}
