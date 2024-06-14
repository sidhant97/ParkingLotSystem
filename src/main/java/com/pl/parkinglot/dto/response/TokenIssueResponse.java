package com.pl.parkinglot.dto.response;

import com.pl.parkinglot.constant.ResponseStatus;
import com.pl.parkinglot.model.Token;
import lombok.Data;

@Data
public class TokenIssueResponse {

    private Token token;

    private ResponseStatus responseStatus;

    private String failureMsg;
}
