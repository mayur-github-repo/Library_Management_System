package org.mayur.Library_Management_System.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TxnSettlementResponse {

    private String txnId;
    private Integer settlementAmount;
}
