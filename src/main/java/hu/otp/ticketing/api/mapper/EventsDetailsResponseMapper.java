package hu.otp.ticketing.api.mapper;

import hu.otp.ticketing.api.endpoint.rest.model.EventsDetailsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventsDetailsResponseMapper {
    EventsDetailsResponse map(hu.otp.ticketing.ticket.endpoint.rest.model.EventsDetailsResponse s);
}
