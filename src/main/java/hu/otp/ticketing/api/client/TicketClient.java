package hu.otp.ticketing.api.client;

import hu.otp.ticketing.api.dto.UserData;
import hu.otp.ticketing.ticket.endpoint.rest.EventsApi;
import hu.otp.ticketing.ticket.endpoint.rest.model.EventsDetailsResponse;
import hu.otp.ticketing.ticket.endpoint.rest.model.EventsResponse;
import hu.otp.ticketing.ticket.endpoint.rest.model.ReservationRequest;
import hu.otp.ticketing.ticket.endpoint.rest.model.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TicketClient {

    private final EventsApi eventApi;

    public EventsDetailsResponse getEvent(UserData userData, BigDecimal eventId) {
        return eventApi.getEvent(userData.getUserId(), userData.getToken(), eventId);
    }

    public EventsResponse getEvents(UserData userData) {
        return eventApi.getEvents(userData.getUserId(), userData.getToken());
    }

    public ReservationResponse pay(UserData data, ReservationRequest rq) {
        return eventApi.reserve(data.getUserId(), data.getToken(), rq);
    }

}