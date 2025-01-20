package A13.BADA.SalonSamochodowy.Mechanic;

import A13.BADA.SalonSamochodowy.dataClasses.Service;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServicesDAO {
    private final JdbcClient jdbcClient;

    public ServicesDAO(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Service> findServicesForWorker(Integer id){
        return jdbcClient.sql("Select * from services where service_id IN (Select service_id from ASSIGNED_EMPLOYEES where employee_id = :id)")
                .param("id",id)
                .query(Service.class)
                .list();
    }
}
