package A13.BADA.SalonSamochodowy.Mechanic;

import A13.BADA.SalonSamochodowy.dataClasses.PersonalInfo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MechanicController {

    private final PersonalInfoDAO personalInfoDAO;

    public MechanicController(PersonalInfoDAO personalInfoDAO) {
        this.personalInfoDAO = personalInfoDAO;
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
