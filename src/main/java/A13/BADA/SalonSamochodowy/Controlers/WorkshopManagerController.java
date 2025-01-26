package A13.BADA.SalonSamochodowy.Controlers;
import A13.BADA.SalonSamochodowy.Repositories.EmployeeRepository;
import A13.BADA.SalonSamochodowy.Repositories.ServiceRepository;
import A13.BADA.SalonSamochodowy.dataClasses.Employees;
import A13.BADA.SalonSamochodowy.dataClasses.ServiceStatus;
import A13.BADA.SalonSamochodowy.dataClasses.Services;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WorkshopManagerController {

    private final EmployeeRepository employeeRepository;
    private final ServiceRepository serviceRepository;

    public WorkshopManagerController(EmployeeRepository employeeRepository, ServiceRepository serviceRepository) {
        this.employeeRepository = employeeRepository;
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/wmanager/home")
    public String wmanagerHome() {
        return "wmanagerHome";
    }

    @GetMapping("/wmanager/employees")
    public String wmanagerEmployees(Model model) {
        List<Employees> employees = employeeRepository.findEmployeeByLocation_locationId(1);
        model.addAttribute("Employees",employees);
        return "wmanagerEmployees";
    }

    @GetMapping("/wmanager/services")
    public String wmanagerServices(Model model) {
        List<Services> service = serviceRepository.findByLocation_locationIdAndServiceStatusIn(1, List.of(new ServiceStatus[]{ServiceStatus.IN_PROGRESS, ServiceStatus.WAITING}));
        model.addAttribute("serviceCar",service);
        return "wmanagerServices";
    }

    @GetMapping("/wmanager/history")
    public String wmanagerHistory(Model model) {
        List<Services> service = serviceRepository.findByLocation_locationIdAndServiceStatus(1, ServiceStatus.COMPLETED);
        model.addAttribute("serviceCar",service);
        return "wmanagerHistory";
    }
}
