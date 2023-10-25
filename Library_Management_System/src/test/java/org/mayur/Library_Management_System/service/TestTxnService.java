package org.mayur.Library_Management_System.service;

import org.mayur.Library_Management_System.exception.TxnServiceException;
import org.mayur.Library_Management_System.models.Student;
import org.mayur.Library_Management_System.models.Txn;
import org.mayur.Library_Management_System.repository.TxnRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TestTxnService {

    @Mock
    private StudentService studentService;

    @Mock
    private BookService bookService;

    @Mock
    private TxnRepository txnRepository;
    @InjectMocks
    private TxnService txnService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(new TestTxnService());
        ReflectionTestUtils.setField(txnService, "validDays", "14");
        ReflectionTestUtils.setField(txnService, "finePerDay", 2);
    }

    @Test(expected = TxnServiceException.class)
    public void testFindStudentWithNullCheck() throws TxnServiceException {
        Mockito.when(studentService.findStudent(any(),eq("8168139116"), any())).thenReturn(null);
        Mockito.when(studentService.findStudent(any(),eq("8168139119"), any())).thenReturn(new ArrayList<>());
        System.out.println(txnService.findStudent("8168139119"));
    }
    @Test(expected = TxnServiceException.class)
    public void testFindStudentWithEmptyResponse() throws TxnServiceException {
        Mockito.when(studentService.findStudent(any(),any(), any())).thenReturn(new ArrayList<>());
        System.out.println(txnService.findStudent("8168139119"));
    }

    @Test
    public void testFindStudentWithSuccessResponse() throws TxnServiceException {
        List<Student> list = new ArrayList<>();
        Student s1 =Student.builder().name("student1").build();
        Student s2 =Student.builder().name("student2").build();
        list.add(s1);
        list.add(s2);
        Mockito.when(studentService.findStudent(any(),any(), any())).thenReturn(list);
        Assert.assertEquals(list, txnService.findStudent(any()) );
    }

    @Test
    public void testCalculateSettlementAmount() throws ParseException {
        DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = "2023-08-23 15:59:53";
        Txn txn = Txn.builder().createdOn(dtf.parse(dateString)).paidCost(20).build();
        int amount  =txnService.calculateSettlementAmount(txn);
        Assert.assertEquals(-28, amount);

    }




}
