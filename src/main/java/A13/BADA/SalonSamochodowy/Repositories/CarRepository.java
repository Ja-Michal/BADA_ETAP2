package A13.BADA.SalonSamochodowy.Repositories;

import A13.BADA.SalonSamochodowy.dataClasses.Cars;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Cars,Integer> {
}
