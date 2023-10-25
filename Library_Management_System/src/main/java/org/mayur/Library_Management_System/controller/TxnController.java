package org.mayur.Library_Management_System.controller;

import org.mayur.Library_Management_System.exception.TxnServiceException;
import org.mayur.Library_Management_System.request.CreateReturnTxnRequest;
import org.mayur.Library_Management_System.request.CreateTxnRequest;
import org.mayur.Library_Management_System.response.GenericResponse;
import org.mayur.Library_Management_System.response.TxnSettlementResponse;
import org.mayur.Library_Management_System.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/txn")
public class TxnController {

    @Autowired
    private TxnService txnService;


    @PostMapping("/create")
    public ResponseEntity<GenericResponse<String>> create(@RequestBody @Valid CreateTxnRequest createTxnRequest) throws TxnServiceException {

        String txnid= txnService.create(createTxnRequest);
        GenericResponse genericResponse = GenericResponse.builder().
                error(null).
                data(txnid).
                status(HttpStatus.OK).build();
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    @PostMapping("/return")
    public TxnSettlementResponse returnBook(@RequestBody CreateReturnTxnRequest createReturnTxnRequest) throws TxnServiceException {
        return txnService.returnBook(createReturnTxnRequest);
    }

}
