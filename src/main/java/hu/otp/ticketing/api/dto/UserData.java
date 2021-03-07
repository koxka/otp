package hu.otp.ticketing.api.dto;


import lombok.Getter;

import javax.servlet.http.HttpServletRequest;

import static hu.otp.ticketing.api.common.HeaderConstants.TOKEN;
import static hu.otp.ticketing.api.common.HeaderConstants.USER_ID;

@Getter
public class UserData {
    private String userId;
    private String token;

    public UserData(HttpServletRequest rq) {
        userId = rq.getHeader(USER_ID);
        token = rq.getHeader(TOKEN);
    }
}
