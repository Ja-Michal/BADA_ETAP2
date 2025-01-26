package A13.BADA.SalonSamochodowy.Mechanic;

import A13.BADA.SalonSamochodowy.dataClasses.Employee;
import A13.BADA.SalonSamochodowy.dataClasses.PersonalInfo;
import A13.BADA.SalonSamochodowy.dataClasses.ServiceCar;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import A13.BADA.SalonSamochodowy.dataClasses.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.ui.Model;


import java.util.List;
import java.util.Optional;

@Controller
public class MechanicController {

    private final PersonalInfoDAO personalInfoDAO;
    private final ServicesDAO servicesDAO;


    public MechanicController(PersonalInfoDAO personalInfoDAO, ServicesDAO servicesDAO) {
        this.personalInfoDAO = personalInfoDAO;
        this.servicesDAO = servicesDAO;
    }

    @GetMapping("/mechanic/home")
    public String mechanicHome() {
        return "mechanicHome"; // mechanicHome.html jako widok
    }

    @GetMapping("/mechanic/data")
    public String mechanicData(Model model) {
        PersonalInfo personalInfo = personalInfoDAO.personalInfoFindByID(34).get();
        model.addAttribute("personalInfo",personalInfo);
        return "mechanicData";
    }

    @GetMapping("/mechanic/services")
    public String mechanicServices(Model model) {
        List<ServiceCar> serviceCar = servicesDAO.serviceCars(servicesDAO.findServicesForWorker(34));
        model.addAttribute("serviceCar",serviceCar);
        return "mechanicServices";
    }

    @GetMapping("/mechanic/history")
    public String mechanicHistory(Model model) {
        List<ServiceCar> serviceCar = servicesDAO.serviceCars(servicesDAO.findServicesForWorkerHist(34));
        model.addAttribute("serviceCar",serviceCar);
        return "mechanicHistory";
    }

}
