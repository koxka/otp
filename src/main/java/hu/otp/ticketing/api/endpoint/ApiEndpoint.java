package hu.otp.ticketing.api.endpoint;

import hu.otp.ticketing.api.endpoint.rest.EventsApi;
import hu.otp.ticketing.api.endpoint.rest.model.EventsDetailsResponse;
import hu.otp.ticketing.api.endpoint.rest.model.EventsResponse;
import hu.otp.ticketing.api.endpoint.rest.model.PayRequest;
import hu.otp.ticketing.api.endpoint.rest.model.ReservationResponse;
import hu.otp.ticketing.api.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("${api.basePath}")
@RequiredArgsConstructor
public class ApiEndpoint implements EventsApi {
    private final EventService eventService;

    @Override
    public ResponseEntity<EventsDetailsResponse> getEvent(BigDecimal eventId) {
        return ResponseEntity.ok(eventService.getEvent(eventId));
    }

    @Override
    public ResponseEntity<EventsResponse> getEvents() {
        return ResponseEntity.ok(eventService.getEvents());
    }

    @Override
    public ResponseEntity<ReservationResponse> pay(@Valid PayRequest payRequest) {
        return ResponseEntity.ok(eventService.pay(payRequest));
    }
}
