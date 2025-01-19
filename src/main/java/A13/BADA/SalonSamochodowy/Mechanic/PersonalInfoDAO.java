package A13.BADA.SalonSamochodowy.Mechanic;

import A13.BADA.SalonSamochodowy.dataClasses.PersonalInfo;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonalInfoDAO {
    private final JdbcClient jdbcClient;

    public PersonalInfoDAO(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public Optional<PersonalInfo> findById(Integer id){
        return jdbcClient.sql("" +
                        "SELECT employee_id as employee_id, name as name, surname as surname, pesel as pesel," +
                        "telephone_number as telephone_number, location_id as location_id, position_name as p_position_name," +
                        "description as p_description, city_name as a_city_name, building_number as a_building_number," +
                        "apartment_number as a_apartment_number, zip_code as a_zip_code " +
                        "FROM employees NATURAL JOIN address NATURAL JOIN POSITIONS " +
                        "WHERE employee_id = :id")
                .param("id",id)
                .query(PersonalInfo.class)
                .optional();
    }

}
