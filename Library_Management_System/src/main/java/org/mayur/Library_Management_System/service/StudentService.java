package org.mayur.Library_Management_System.service;

import org.mayur.Library_Management_System.models.OperationType;
import org.mayur.Library_Management_System.models.Student;
import org.mayur.Library_Management_System.models.StudentFilterType;
import org.mayur.Library_Management_System.models.User;
import org.mayur.Library_Management_System.repository.StudentRepository;
import org.mayur.Library_Management_System.repository.UserRepository;
import org.mayur.Library_Management_System.request.CreateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Value("${student.authority}")
    private String studentAuthority;

    public List<Student> findStudent(StudentFilterType studentFilterType, String value, OperationType operationType) {

        switch (operationType) {
            case EQUALS:
                switch (studentFilterType) {
                    case EMAIL:
                        return studentRepository.findByEmail(value);
                    case CONTACT:
                        return studentRepository.findByContact(value);
                }
            default:
                return new ArrayList<>();
        }
    }

    public Student create(CreateStudentRequest createStudentRequest) {
        // check if the student already exist or not
        List<Student> students = findStudent(StudentFilterType.CONTACT, createStudentRequest.getContact() , OperationType.EQUALS );
        if(students == null || students.isEmpty()){
            Student student = createStudentRequest.to();
            User user = (User.builder().
                    contact(student.getContact())).
                    password(passwordEncoder.encode(createStudentRequest.getPassword())).
                    authorities(studentAuthority).
                    build();
            user = userRepository.save(user);
            student.setUser(user);
           return studentRepository.save(student);
        }
        return students.get(0);
    }
}
