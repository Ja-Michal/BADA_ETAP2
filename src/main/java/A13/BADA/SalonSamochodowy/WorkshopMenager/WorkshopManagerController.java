package A13.BADA.SalonSamochodowy.WorkshopMenager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class WorkshopManagerController {
    @GetMapping("/wmanager/home")
    public String wmanagerHome() {
        return "wmanagerHome";
    }

    @GetMapping("/wmanager/employees")
    public String wmanagerEmployees() {
        // TODO: Pobierz listę pracowników w warsztacie z bazy danych
        return "wmanagerEmployees";
    }

    @GetMapping("/wmanager/services")
    public String wmanagerServices() {
        // TODO: Pobierz aktywne serwisy przypisane do warsztatu z bazy danych
        return "wmanagerServices";
    }

    @GetMapping("/wmanager/history")
    public String wmanagerHistory() {
        // TODO: Pobierz historię serwisów warsztatu z bazy danych
        return "wmanagerHistory";
    }
}
