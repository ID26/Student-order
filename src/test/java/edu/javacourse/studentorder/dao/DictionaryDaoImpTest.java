package edu.javacourse.studentorder.dao;


import edu.javacourse.studentorder.domain.CountryArea;
import edu.javacourse.studentorder.domain.PassportOffice;
import edu.javacourse.studentorder.domain.RegisterOffice;
import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.exception.DaoException;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDateTime;
import java.util.List;

public class DictionaryDaoImpTest {
    private static final Logger logger= LoggerFactory.getLogger(DictionaryDaoImpTest.class);

    @BeforeClass
    public static void startUpp() throws Exception {
        DBInit.startUpp();
    }

    @Test
    public void testStreet() throws DaoException {
        LocalDateTime dt1=LocalDateTime.now();
        LocalDateTime dt2=LocalDateTime.now();
        logger.info("TEST {} {} ", dt1, dt2);
        List<Street> d=new DictionaryDaoImp().findStreets("про");
        Assert.assertTrue(d.size()==2);
    }
    @Test
    public void testPassportOffice() throws DaoException {
        List<PassportOffice> po=new DictionaryDaoImp().findPassportOffices("010020000000");
        Assert.assertTrue(po.size()==2);
    }
    @Test
    public void testRegisterOffice() throws DaoException {
        List<RegisterOffice> ro=new DictionaryDaoImp().findRegisterOffices("010010000000");
        Assert.assertTrue(ro.size()==2);
    }
    @Test
    public void testCountryAreas() throws DaoException {
        List<CountryArea> ca1=new DictionaryDaoImp().findAreas("  ");
        Assert.assertTrue(ca1.size()==2);
        List<CountryArea> ca2=new DictionaryDaoImp().findAreas("020000000000");
        Assert.assertTrue(ca2.size()==2);
        List<CountryArea> ca3=new DictionaryDaoImp().findAreas("020010000000");
        Assert.assertTrue(ca3.size()==2);
        List<CountryArea> ca4=new DictionaryDaoImp().findAreas("020010010000");
        Assert.assertTrue(ca4.size()==2);
    }

}