package org.mayur.Library_Management_System.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CreateTxnRequest {
    @NotBlank(message = "Student Contact must not be blank")
    private String studentContact;
    @NotBlank(message = "BookNo must not be blank")
    private String bookNo;
    @NotNull(message = "Paid Amount must not be null")
    @Positive(message = "Amount should be positive")
    private Integer paidAmount;
}
