package edu.javacourse.register.domain;

import java.time.LocalDate;

public class BirthCertificate {

    private Long birthCertificateId;
    private String number;
    private LocalDate isueDate;
    private Person person;
    private PersonMale father;
    private PersonFemale mather;

    public BirthCertificate() {
    }

    public Long getBirthCertificateId() {
        return birthCertificateId;
    }

    public void setBirthCertificateId(Long birthCertificateId) {
        this.birthCertificateId = birthCertificateId;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonMale getFather() {
        return father;
    }

    public void setFather(PersonMale father) {
        this.father = father;
    }

    public PersonFemale getMather() {
        return mather;
    }

    public void setMather(PersonFemale mather) {
        this.mather = mather;
    }
}
