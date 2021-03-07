package hu.otp.ticketing.api.mapper;

import hu.otp.ticketing.api.endpoint.rest.model.ReservationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationResponseMapper {
    ReservationResponse map(hu.otp.ticketing.ticket.endpoint.rest.model.ReservationResponse s);
}
