package edu.javacourse.studentorder.domain;

import java.time.LocalDate;

public class Adult extends Person {
    private String passportSeria;
    private String passportNumber;
    private LocalDate issueDate;
    private PassportOffice issueDepartment;
    private University university;
    private String studentId;



    public Adult(String serName, String givenName, String patronymic, LocalDate dateOfBirth,
                 Address address, String passportSeria, String passportNumber, LocalDate issueDate,
                 PassportOffice issueDepartment, University university, String studentId) {

        super(serName, givenName, patronymic, dateOfBirth, address);
        this.passportSeria = passportSeria;
        this.passportNumber = passportNumber;
        this.issueDate = issueDate;
        this.issueDepartment = issueDepartment;
        this.university = university;
        this.studentId = studentId;
    }

    public Adult(String serName, String givenName, String patronymic, LocalDate dateOfBirth) {
        super(serName, givenName, patronymic, dateOfBirth);
    }

    public Adult() {
        super();
    }

    //    @Override
//public String getPersonString(){
//    return serName+" "+givenName+": "+passportNumber;
//}

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public PassportOffice getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(PassportOffice issueDepartment) {
        this.issueDepartment = issueDepartment;
    }

    @Override
    public String toString() {
        return "Adult{" +
                "passportSeria='" + passportSeria + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", issueDate=" + issueDate +
                ", issueDepartment=" + issueDepartment +
                ", university=" + university +
                ", studentId='" + studentId + '\'' +
                "} " + super.toString();
    }
}
