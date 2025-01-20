package A13.BADA.SalonSamochodowy.ServiceManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceManagerController {

    @GetMapping("/smanager/home")
    public String smanagerHome() {
        return "smanagerHome";
    }

    @GetMapping("/smanager/workshops")
    public String smanagerWorkshops() {
        // TODO: Pobierz listę warsztatów przypisanych do service managera z bazy danych
        return "smanagerWorkshops";
    }

    @GetMapping("/smanager/assign")
    public String smanagerAssignServices() {
        // TODO: Implementuj przydzielanie serwisów do warsztatów
        return "smanagerAssignServices";
    }
}