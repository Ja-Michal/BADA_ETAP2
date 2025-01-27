package A13.BADA.SalonSamochodowy.Controlers;

import A13.BADA.SalonSamochodowy.Repositories.EmployeeRepository;
import A13.BADA.SalonSamochodowy.Repositories.ServiceRepository;
import A13.BADA.SalonSamochodowy.dataClasses.Address;
import A13.BADA.SalonSamochodowy.dataClasses.Employees;
import A13.BADA.SalonSamochodowy.dataClasses.ServiceStatus;
import A13.BADA.SalonSamochodowy.dataClasses.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


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

    @GetMapping("/mechanic/data/edit")
    public String mechanicDataEdit(Model model){
        Employees employee = employeeRepository.findById(17).get();
        model.addAttribute("employee",employee);
        return "mechanicDataEdit";
    }

    @PostMapping(value = "/mechanic/data/update",  consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String mechanicDataUpdate(Employees employeeCG, Model model){
        Employees employee = employeeRepository.findById(17).get();
        employee.setName(employeeCG.getName());
        employee.setSurname(employeeCG.getSurname());
        employee.setTelephone_number(employeeCG.getTelephone_number());
        Address addressCG = employeeCG.getAddres();
        addressCG.setAddres_id(employee.getAddres().getAddres_id());
        employee.setAddres(addressCG);
        employeeRepository.save(employee);
        model.addAttribute("personalInfo",employee);
        return "mechanicData";
    }
}
