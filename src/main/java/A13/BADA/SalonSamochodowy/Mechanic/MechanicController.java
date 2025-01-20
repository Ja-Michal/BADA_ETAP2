package A13.BADA.SalonSamochodowy.Mechanic;

import A13.BADA.SalonSamochodowy.dataClasses.Employee;
import A13.BADA.SalonSamochodowy.dataClasses.PersonalInfo;
import A13.BADA.SalonSamochodowy.dataClasses.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mechanik")
public class MechanicController {
    private final PersonalInfoDAO personalInfoDAO;
    private final ServicesDAO servicesDAO;

    MechanicController(PersonalInfoDAO personalInfoDAO,ServicesDAO servicesDAO){
        this.personalInfoDAO = personalInfoDAO;
        this.servicesDAO = servicesDAO;
    }

    @GetMapping("/{id}")
    PersonalInfo findById(@PathVariable Integer id){
        Optional<PersonalInfo> personalInfo = personalInfoDAO.personalInfoFindByID(id);
        if(personalInfo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Personal data not found.");
        }
        return personalInfo.get();
    }

    @GetMapping("/serwisy/{id}")
    List<Service> findServices(@PathVariable Integer id){
        return servicesDAO.findServicesForWorker(id);
    }
}
