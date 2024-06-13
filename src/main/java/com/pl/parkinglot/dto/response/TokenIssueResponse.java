package com.pl.parkinglot.dto.response;

import com.pl.parkinglot.constant.ResponseStatus;
import com.pl.parkinglot.model.TokenModel;
import lombok.Data;

@Data
public class TokenIssueResponse {
    private TokenModel token;

    private ResponseStatus responseStatus;

    private String failureMsg;
}
