package A13.BADA.SalonSamochodowy.Mechanic;

import A13.BADA.SalonSamochodowy.dataClasses.Addres;
import A13.BADA.SalonSamochodowy.dataClasses.Employee;
import A13.BADA.SalonSamochodowy.dataClasses.PersonalInfo;
import A13.BADA.SalonSamochodowy.dataClasses.Position;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.boot.model.internal.OptionalDeterminationSecondPass;
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

    private Optional<Employee> employeeFindById(Integer id){
        return jdbcClient.sql("Select * from employees where employee_id=:id")
                .param("id",id)
                .query(Employee.class)
                .optional();
    }

    private Optional<Addres> addresFindByID(Integer id){
        return jdbcClient.sql("Select * from address where addres_id=:id")
                .param("id",id)
                .query(Addres.class)
                .optional();
    }

    private Optional<Position> positionFindByID(Integer id){
        return jdbcClient.sql("Select * from positions where position_id=:id")
                .param("id",id)
                .query(Position.class)
                .optional();
    }

    public Optional<PersonalInfo> personalInfoFindByID(Integer id){
        Optional<Employee> employee = employeeFindById(id);
        if(!employee.isEmpty()){
            Addres addres = addresFindByID(employee.get().addres_id()).get();
            Position position = positionFindByID(employee.get().position_id()).get();
            return Optional.of(new PersonalInfo(employee.get(),position,addres));
        }
        return Optional.empty();
    }

}
