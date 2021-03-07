package hu.otp.ticketing.api.security;

import hu.otp.ticketing.api.client.CoreClient;
import hu.otp.ticketing.api.common.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static hu.otp.ticketing.api.common.HeaderConstants.TOKEN;
import static hu.otp.ticketing.api.common.HeaderConstants.USER_ID;

@RequiredArgsConstructor
public class UserAuthCheckerInterceptor implements AsyncHandlerInterceptor {

    private final CoreClient coreClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getHeader(USER_ID);
        String token = request.getHeader(TOKEN);
        boolean isAuthenticated = Boolean.TRUE.equals(coreClient.isAuthenticated(userId, token));
        if (!isAuthenticated) {
            throw new UnauthorizedException(String.format("Auth failed for user %s with token %s", userId, token));
        }
        return true;
    }
}
