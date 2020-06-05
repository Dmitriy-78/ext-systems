package edu.javacourse.city.dao;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCheckDao {

    private static final String SQL_REQUEST =
            "select temparal from cr_address_person ap " +
                    "inner join cr_person p on p.person_id = ap.person_id " +
                    "inner join cr_address a on a.address_id = ap.address_id " +
                    "WHERE " +
                    "CURRENT_DATE >= ap.start_date and (CURRENT_DATE <= ap.end_date or ap.end_date is null) " +
                    "and UPPER (p.sur_name) = UPPER(?) and UPPER(p.given_name) = UPPER(?) " +
                    "and UPPER(patronymic) = UPPER(?) " +
                    "and p.date_of_birth = ? and a.street_code = ?  " +
                    "and UPPER(a.building) = UPPER(?) and UPPER(a.extension) = UPPER(?) "+
                    "and UPPER(a.apartment) = UPPER(?)";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        PersonResponse response = new PersonResponse();
        
        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(SQL_REQUEST);
        ) {
            pst.setString(1,request.getSurName());
            pst.setString(2,request.getGivenName());
            pst.setString(3,request.getPatronymic());
            pst.setDate(4,java.sql.Date.valueOf(request.getDateOfBirth()));
            pst.setInt(5,request.getStreetCode());
            pst.setString(6,request.getBuilding());
            pst.setString(7,request.getExtention());
            pst.setString(8,request.getApartment());

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                response.setRegistered(true);
                response.setTemparal(rs.getBoolean("temparal"));
            }
        } catch (SQLException e) {
            throw new PersonCheckException(e);
        }
        return response;
    }

    private Connection getConnection() throws SQLException {
        return connectionBuilder.getConnection();
    }
}
