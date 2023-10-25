package org.mayur.Library_Management_System.request;

import lombok.*;
import org.mayur.Library_Management_System.models.Student;
import org.mayur.Library_Management_System.models.StudentType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CreateStudentRequest {
    private String name;

    private String address;

    private String contact;

    private String email;

    private String password;

    public Student to() {
        return Student.builder().
                name(this.name).
                email(this.email).
                contact(this.contact).
                studentType(StudentType.ACTIVE).
                address(this.address).
                build();
    }
}
