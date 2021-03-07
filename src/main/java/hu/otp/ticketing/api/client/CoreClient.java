package hu.otp.ticketing.api.client;

import hu.otp.ticketing.core.endpoint.rest.OtpCoreApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoreClient {

    private final OtpCoreApi coreApi;

    public Boolean isAuthenticated(String userId, String token) {
        return coreApi.isAuthenticated(userId, token).getInfo().getSuccess();
    }
}
