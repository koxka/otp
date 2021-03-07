package hu.otp.ticketing.api.service;

import hu.otp.ticketing.api.client.TicketClient;
import hu.otp.ticketing.api.dto.UserData;
import hu.otp.ticketing.api.endpoint.rest.model.EventsDetailsResponse;
import hu.otp.ticketing.api.endpoint.rest.model.EventsResponse;
import hu.otp.ticketing.api.endpoint.rest.model.PayRequest;
import hu.otp.ticketing.api.endpoint.rest.model.ReservationResponse;
import hu.otp.ticketing.api.mapper.EventsDetailsResponseMapper;
import hu.otp.ticketing.api.mapper.EventsResponseMapper;
import hu.otp.ticketing.api.mapper.PayRqToReservationRqMapper;
import hu.otp.ticketing.api.mapper.ReservationResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class EventService {
    private final TicketClient ticketClient;
    private final EventsDetailsResponseMapper eventsDetailsResponseMapper;
    private final EventsResponseMapper eventsResponseMapper;
    private final PayRqToReservationRqMapper payRqToReservationRqMapper;
    private final ReservationResponseMapper reservationResponseMapper;

    private final HttpServletRequest rq;

    public EventsDetailsResponse getEvent(BigDecimal eventId) {
        return eventsDetailsResponseMapper.map(ticketClient.getEvent(new UserData(rq), eventId));
    }

    public EventsResponse getEvents() {
        return eventsResponseMapper.map(ticketClient.getEvents(new UserData(rq)));
    }

    public ReservationResponse pay(PayRequest payRequest) {
        return reservationResponseMapper.map(ticketClient.pay(new UserData(rq), payRqToReservationRqMapper.map(payRequest)));
    }
}
