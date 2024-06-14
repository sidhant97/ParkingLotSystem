package com.pl.parkinglot.controller;

import com.pl.parkinglot.constant.ResponseStatus;
import com.pl.parkinglot.dto.request.TokenIssueRequest;
import com.pl.parkinglot.dto.response.TokenIssueResponse;
import com.pl.parkinglot.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.context}")
public class TokenController {

    @Autowired
    private TokenService tokenService;


    @PostMapping("/token/v0/retry")
    private ResponseEntity<Object> entryParking(TokenIssueRequest tokenIssueRequest) throws Exception {
        TokenIssueResponse tokenIssueResponse = tokenService.entryParking(tokenIssueRequest);
        if (!tokenIssueResponse.getResponseStatus().name().equals(ResponseStatus.SUCCESS.name())) {
            return new ResponseEntity<>(tokenIssueResponse.getFailureMsg(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(tokenIssueResponse, HttpStatus.OK);
    }

    @PostMapping("/token/v0/exit")
    private ResponseEntity<Object> exitParking(TokenIssueRequest tokenIssueRequest) throws Exception {
        TokenIssueResponse tokenIssueResponse = tokenService.exitParking(tokenIssueRequest);
        if (tokenIssueResponse == null) {
            return new ResponseEntity<>(tokenIssueResponse.getFailureMsg(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(tokenIssueResponse, HttpStatus.OK);
    }

}
