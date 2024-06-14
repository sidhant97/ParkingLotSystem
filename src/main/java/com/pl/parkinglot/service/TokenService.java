package com.pl.parkinglot.service;

import com.pl.parkinglot.dto.request.TokenIssueRequest;
import com.pl.parkinglot.dto.response.TokenIssueResponse;

public interface TokenService {

    TokenIssueResponse entryParking(TokenIssueRequest tokenIssueRequest) throws Exception;

    TokenIssueResponse exitParking(TokenIssueRequest tokenIssueRequest) throws Exception;
}
