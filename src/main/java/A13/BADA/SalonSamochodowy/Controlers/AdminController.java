package A13.BADA.SalonSamochodowy.Controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/home")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/workshops")
    public String adminWorkshops() {
        // TODO: Pobierz listę warsztatów
        return "adminWorkshops";
    }

    @GetMapping("/admin/employees")
    public String adminEmployees() {
        // TODO: Pobierz liste employees
        return "adminEmployees";
    }

    @GetMapping("/admin/users")
    public String adminUsers() {
        // TODO : Pobierz liste users
        return "adminUsers";
    }
    @GetMapping("/admin/services")
    public String adminServices() {
        // TODO : Pobierz liste services
        return "adminServices";
    }
    @GetMapping("/admin/cars")
    public String adminCars() {
        // TODO : Pobierz liste samochodow
        return "adminCars";
    }
}