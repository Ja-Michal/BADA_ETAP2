package A13.BADA.SalonSamochodowy.Mechanic;

import A13.BADA.SalonSamochodowy.dataClasses.Employee;
import A13.BADA.SalonSamochodowy.dataClasses.PersonalInfo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import A13.BADA.SalonSamochodowy.dataClasses.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@Controller
public class MechanicController {

    private final PersonalInfoDAO personalInfoDAO;
    private final ServicesDAO servicesDAO;

    public MechanicController(PersonalInfoDAO personalInfoDAO) {
        this.personalInfoDAO = personalInfoDAO;
        this.servicesDAO = servicesDAO;
    }

    @GetMapping("/mechanic/home")
    public String mechanicHome() {
        return "mechanicHome"; // mechanicHome.html jako widok
    }
    @GetMapping("/mechanic/data")
    public String mechanicData() {
        // TODO: Pobierz dane mechanika z bazy danych
        return "mechanicData";
    }

    @GetMapping("/mechanic/services")
    public String mechanicServices() {
        // TODO: Pobierz aktywne serwisy przypisane do mechanika z bazy danych
        return "mechanicServices";
    }

    @GetMapping("/mechanic/history")
    public String mechanicHistory() {
        // TODO: Pobierz historię serwisów mechanika z bazy danych
        return "mechanicHistory";
    }

}
