package A13.BADA.SalonSamochodowy.Mechanic;

import A13.BADA.SalonSamochodowy.dataClasses.PersonalInfo;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class PersonalInfoDAO {
    private final JdbcTemplate jdbcTemplate;

    public PersonalInfoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<PersonalInfo> findById(Integer id) {
        String sql = """
                SELECT employee_id AS employee_id, name AS name, surname AS surname, pesel AS pesel,
                       telephone_number AS telephone_number, location_id AS location_id, 
                       position_name AS p_position_name, description AS p_description, 
                       city_name AS a_city_name, building_number AS a_building_number, 
                       apartment_number AS a_apartment_number, zip_code AS a_zip_code 
                FROM employees 
                NATURAL JOIN address 
                NATURAL JOIN POSITIONS 
                WHERE employee_id = ?
                """;

        return jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> new PersonalInfo(
                rs.getInt("employee_id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getString("pesel"),
                rs.getString("telephone_number"),
                rs.getInt("location_id"),
                rs.getString("p_position_name"),
                rs.getString("p_description"),
                rs.getString("a_city_name"),
                rs.getString("a_street"),
                rs.getString("a_building_number"),
                rs.getString("a_apartment_number"),
                rs.getString("a_zip_code")
        )).stream().findFirst();
    }
}