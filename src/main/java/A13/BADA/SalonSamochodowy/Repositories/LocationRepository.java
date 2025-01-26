package A13.BADA.SalonSamochodowy.Repositories;

import A13.BADA.SalonSamochodowy.dataClasses.Locations;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Locations,Integer> {
}
