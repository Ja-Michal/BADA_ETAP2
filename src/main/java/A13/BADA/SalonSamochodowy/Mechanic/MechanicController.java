package A13.BADA.SalonSamochodowy.Mechanic;

import A13.BADA.SalonSamochodowy.dataClasses.PersonalInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MechanicController {
    private final PersonalInfoDAO personalInfoDAO;

    MechanicController(PersonalInfoDAO personalInfoDAO){
        this.personalInfoDAO = personalInfoDAO;
    }

    @GetMapping("/mechanik/{id}")
    PersonalInfo findById(@PathVariable Integer id){
        Optional<PersonalInfo> personalInfo = personalInfoDAO.findById(id);
        return personalInfo.get();
    }
}
