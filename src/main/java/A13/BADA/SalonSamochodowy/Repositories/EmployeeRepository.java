package A13.BADA.SalonSamochodowy.Repositories;

import A13.BADA.SalonSamochodowy.dataClasses.Employees;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employees,Integer> {
    public List<Employees> findEmployeeByLocation_locationId(Integer locationId);
}
