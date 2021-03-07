package hu.otp.ticketing.api.mapper;

import hu.otp.ticketing.api.endpoint.rest.model.EventsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventsResponseMapper {
    EventsResponse map(hu.otp.ticketing.ticket.endpoint.rest.model.EventsResponse s);
}
