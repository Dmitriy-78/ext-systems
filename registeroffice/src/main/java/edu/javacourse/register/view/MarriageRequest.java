package edu.javacourse.register.view;

import java.io.Serializable;
import java.time.LocalDate;

public class MarriageRequest implements Serializable {

    private String husbandSurName;
    private String husbandGivenName;
    private String husbandPatronymic;
    private LocalDate husbandDateOfBirth;
    private String husbandPassportSeria;
    private String husbandPassportNumber;
    private LocalDate husbandPassportIsueDate;

    private String sifeSurName;
    private String sifeGivenName;
    private String wifePatronymic;
    private LocalDate wifeDateOfBirth;
    private String wifePassportSeria;
    private String sifePassportNumber;
    private LocalDate wifePassportIsueDate;

    private String marriageCertificateNumber;
    private LocalDate marriageCertificateDate;



}
