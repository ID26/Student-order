package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.exception.DaoException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class StudentOrderDaoImplTest {

    @BeforeClass
    public static void startUpp() throws Exception {
        DBInit.startUpp();
    }

    @Test
    public void saveStudentOrder() throws DaoException {
        StudentOrder so=buildStudentOrder(10);
        Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }

    @Test(expected = DaoException.class)
    public void saveStudentOrderError() throws DaoException {
            StudentOrder so = buildStudentOrder(10);
            so.getHusband().setSerName(null);
            Long id = new StudentOrderDaoImpl().saveStudentOrder(so);

    }

    @Test
    public void getStudentOrders() throws DaoException {
        List<StudentOrder> list = new StudentOrderDaoImpl().getStudentOrders();
    }

    public StudentOrder buildStudentOrder(long id){
        StudentOrder so=new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId(""+(123456000+id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        RegisterOffice ro3=new RegisterOffice(3l,"","");
        so.setMarriageOffice(ro3);

        Street street=new Street(1l, "First street");

        Address address=new Address("346000", street,
                "120", "Б", "208");

        //husband
        Adult husband=new Adult("Denisov", "Ivan", "Alexandrovich",
                LocalDate.of(1979, 10, 17));
        husband.setPassportSeria(""+(1000+id));
        husband.setPassportNumber(""+(100000+id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice po1=new PassportOffice(1l,"","");
        husband.setIssueDepartment(po1);
        husband.setStudentId(""+(100000+id));
        husband.setAddress(address);
        husband.setUniversity(new University(2L,""));
        husband.setStudentId("HH12345");
        //wife
        Adult wife=new Adult("Denisova", "Elena", "Vladimirovna",
                LocalDate.of(1980, 01, 17));
        wife.setPassportSeria(""+(2000+id));
        wife.setPassportNumber(""+(200000+id));
        wife.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice po2=new PassportOffice(2l,"","");
        wife.setIssueDepartment(po2);
        wife.setStudentId(""+(200000+id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L,""));
        wife.setStudentId("WW12345");
        //child
        Child child1=new Child("Denisov", "Nikita", "Ivanovich",
                LocalDate.of(2010, 02, 01));
        child1.setCertificateNumber(""+(300000+id));
        child1.setIssueDate(LocalDate.of(2017, 9, 15));
        RegisterOffice ro1=new RegisterOffice(1l,"","");
        child1.setIssueDepartment(ro1);
        child1.setAddress(address);
        //child
        Child child2=new Child("Denisova", "Alena", "Ivanovna",
                LocalDate.of(2012, 03, 06));
        child2.setCertificateNumber(""+(400000+id));
        child2.setIssueDate(LocalDate.of(2017, 9, 15));
        RegisterOffice ro2=new RegisterOffice(2l,"","");
        child2.setIssueDepartment(ro2);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);



        return so;
    }

}