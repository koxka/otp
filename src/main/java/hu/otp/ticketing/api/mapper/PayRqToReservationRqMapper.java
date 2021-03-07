package hu.otp.ticketing.api.mapper;

import hu.otp.ticketing.api.endpoint.rest.model.PayRequest;
import hu.otp.ticketing.ticket.endpoint.rest.model.ReservationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PayRqToReservationRqMapper {
    ReservationRequest map(PayRequest s);
}
