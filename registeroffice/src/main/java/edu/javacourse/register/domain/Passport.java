package edu.javacourse.register.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ro_passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private Long passportId;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
    @Column(name = "seria")
    private String seria;
    @Column(name = "number")
    private String number;
    @Column(name = "isue_date")
    private LocalDate isueDate;
    @Column(name = "isue_department")
    private String isueDepartment;

    public Passport() {
    }

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
