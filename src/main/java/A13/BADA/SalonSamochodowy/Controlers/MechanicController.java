package A13.BADA.SalonSamochodowy.Controlers;

import A13.BADA.SalonSamochodowy.Repositories.EmployeeRepository;
import A13.BADA.SalonSamochodowy.Repositories.ServiceRepository;
import A13.BADA.SalonSamochodowy.dataClasses.Employees;
import A13.BADA.SalonSamochodowy.dataClasses.ServiceStatus;
import A13.BADA.SalonSamochodowy.dataClasses.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


import java.util.List;

@Controller
public class MechanicController {


    private final EmployeeRepository employeeRepository;
    private final ServiceRepository serviceRepository;

    @Autowired
    public MechanicController(EmployeeRepository employeeRepository, ServiceRepository serviceRepository) {
        this.employeeRepository = employeeRepository;
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/mechanic/home")
    public String mechanicHome() {
        return "mechanicHome"; // mechanicHome.html jako widok
    }
    @GetMapping("/mechanic/data")
    public String mechanicData(Model model) {
        Employees employee = employeeRepository.findById(17).get();
        model.addAttribute("personalInfo",employee);
        return "mechanicData";
    }

    @GetMapping("/mechanic/services")
    public String mechanicServices(Model model) {
        List<Services> service = serviceRepository.findByAssignedEmployees_employeeIdAndServiceStatusIn(17, List.of(new ServiceStatus[]{ServiceStatus.IN_PROGRESS, ServiceStatus.WAITING}));
        model.addAttribute("serviceCar",service);
        return "mechanicServices";
    }

    @GetMapping("/mechanic/history")
    public String mechanicHistory(Model model) {
        List<Services> service = serviceRepository.findByAssignedEmployees_employeeIdAndServiceStatus(17, ServiceStatus.COMPLETED);
        model.addAttribute("serviceCar",service);
        return "mechanicHistory";
    }

}
