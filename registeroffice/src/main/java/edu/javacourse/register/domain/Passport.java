package edu.javacourse.register.domain;

import java.time.LocalDate;

public class Passport {

    private Long passportId;
    private String seria;
    private String number;
    private LocalDate isueDate;
    private String isueDepartment;

    public Passport() {
    }

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIsueDate() {
        return isueDate;
    }

    public void setIsueDate(LocalDate isueDate) {
        this.isueDate = isueDate;
    }

    public String getIsueDepartment() {
        return isueDepartment;
    }

    public void setIsueDepartment(String isueDepartment) {
        this.isueDepartment = isueDepartment;
    }
}
