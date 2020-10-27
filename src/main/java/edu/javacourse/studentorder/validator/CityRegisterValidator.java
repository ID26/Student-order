package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.register.AnswerCityRegisterItem;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.exception.TransportException;
import edu.javacourse.studentorder.validator.register.CityRegisterChecker;
import edu.javacourse.studentorder.validator.register.FakeCityRegisterChecker;

public class CityRegisterValidator {
    //    public String hostName;
//    protected int port;
//    private String login;
//    String password;
    public static final String IN_CODE="NO GRN";

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so){
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.addItem(checkPerson(so.getHusband()));
        ans.addItem(checkPerson(so.getWife()));
        for (Child child: so.getChildren()) {
            ans.addItem(checkPerson(child));
        }

        return ans;
    }
    private AnswerCityRegisterItem checkPerson(Person person){
        AnswerCityRegisterItem.CityStatus status=null;
        AnswerCityRegisterItem.CityError error=null;
        try {
            CityRegisterResponse tmp=personChecker.checkPerson(person);
            status=tmp.isExisting()?
                    AnswerCityRegisterItem.CityStatus.YES :
                    AnswerCityRegisterItem.CityStatus.NO;
        }catch (TransportException exc){
            exc.printStackTrace(System.out);
            status=AnswerCityRegisterItem.CityStatus.ERROR;
            error=new AnswerCityRegisterItem.CityError(IN_CODE, exc.getMessage());
        } catch (CityRegisterException exc) {
            exc.printStackTrace(System.out);
            status=AnswerCityRegisterItem.CityStatus.ERROR;
            error=new AnswerCityRegisterItem.CityError(exc.getCode(), exc.getMessage());
        } catch (Exception exc){
            exc.printStackTrace(System.out);
        }
        AnswerCityRegisterItem ans=new AnswerCityRegisterItem(status, person, error);
        return null;
    }
}
