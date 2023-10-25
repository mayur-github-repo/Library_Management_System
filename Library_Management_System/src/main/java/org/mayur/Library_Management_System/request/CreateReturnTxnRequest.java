package org.mayur.Library_Management_System.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CreateReturnTxnRequest {
    private String studentContact;
    private String bookNo;

}
