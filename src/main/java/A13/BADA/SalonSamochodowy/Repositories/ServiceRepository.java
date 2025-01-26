package A13.BADA.SalonSamochodowy.Repositories;

import A13.BADA.SalonSamochodowy.dataClasses.ServiceStatus;
import A13.BADA.SalonSamochodowy.dataClasses.Services;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ServiceRepository extends CrudRepository<Services,Integer> {
    public List<Services> findByAssignedEmployees_employeeIdAndServiceStatus(Integer id, ServiceStatus serviceStatus);
    public List<Services> findByAssignedEmployees_employeeIdAndServiceStatusIn(Integer id, Collection<ServiceStatus> serviceStatus);
    public List<Services> findByLocation_locationIdAndServiceStatus(Integer id, ServiceStatus serviceStatus);
    public List<Services> findByLocation_locationIdAndServiceStatusIn(Integer id, Collection<ServiceStatus> serviceStatus);
}
