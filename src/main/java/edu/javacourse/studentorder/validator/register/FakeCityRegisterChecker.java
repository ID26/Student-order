package edu.javacourse.studentorder.validator.register;

import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.exception.TransportException;

public class FakeCityRegisterChecker implements CityRegisterChecker {

    public static final String GOOD_1 ="1000";
    public static final String GOOD_2 ="2000";
    public static final String BAD_1 ="1001";
    public static final String BAD_2 ="2001";
    public static final String ERROR_1 ="1002";
    public static final String ERROR_2 ="2002";
    public static final String ERROR_T_1 ="1003";
    public static final String ERROR_T_2 ="2003";


    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException {
        CityRegisterResponse res=new CityRegisterResponse();
        if (person instanceof Adult){
            Adult t=(Adult)person;
            String ps=t.getPassportSeria();
            if (ps.equals(GOOD_1)||ps.equals(GOOD_2)) {
                res.setExisting(true);
                res.setTemporal(false);
            }
            if (ps.equals(BAD_1)||ps.equals(BAD_2)) {
                res.setExisting(true);
            }
            if (ps.equals(ERROR_1)||ps.equals(ERROR_2)) {
                CityRegisterException ex=
                        new CityRegisterException("1", "GRN Error"+ps);
                throw ex;
            }
            if (ps.equals(ERROR_T_1)||ps.equals(ERROR_T_2)) {
                TransportException ex=
                        new TransportException("Transport Error"+ps);
                throw ex;
            }
            System.out.println(res);
        }
        if (person instanceof Child){
            res.setExisting(true);
            res.setTemporal(true);
        }

        return res;
    }
}