package A13.BADA.SalonSamochodowy.Controlers;
import A13.BADA.SalonSamochodowy.Repositories.EmployeeRepository;
import A13.BADA.SalonSamochodowy.Repositories.ServiceRepository;
import A13.BADA.SalonSamochodowy.dataClasses.Address;
import A13.BADA.SalonSamochodowy.dataClasses.Employees;
import A13.BADA.SalonSamochodowy.dataClasses.ServiceStatus;
import A13.BADA.SalonSamochodowy.dataClasses.Services;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/wmanager/data")
    public String wmanagerData(Model model) {
        Employees employee = employeeRepository.findById(34).get();
        model.addAttribute("personalInfo",employee);
        return "wmanagerData";
    }

    @GetMapping("/wmanager/employees")
    public String wmanagerEmployees(Model model) {
        List<Employees> employees = employeeRepository.findEmployeeByLocation_locationId(0);
        model.addAttribute("Employees",employees);
        return "wmanagerEmployees";
    }

    @GetMapping("/wmanager/services")
    public String wmanagerServices(Model model) {
        List<Services> service = serviceRepository.findByLocation_locationIdAndServiceStatusIn(0, List.of(new ServiceStatus[]{ServiceStatus.IN_PROGRESS, ServiceStatus.WAITING}));
        model.addAttribute("serviceCar",service);
        return "wmanagerServices";
    }

    @GetMapping("/wmanager/history")
    public String wmanagerHistory(Model model) {
        List<Services> service = serviceRepository.findByLocation_locationIdAndServiceStatus(0, ServiceStatus.COMPLETED);
        model.addAttribute("serviceCar",service);
        return "wmanagerHistory";
    }


    @GetMapping("/wmanager/data/edit")
    public String wmanagerDataEdit(Model model){
        Employees employee = employeeRepository.findById(34).get();
        model.addAttribute("employee",employee);
        return "wmanagerDataEdit";
    }


    @PostMapping(value = "/wmanager/data/update",  consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String wmanagerDataUpdate(Employees employeeCG, Model model){
        Employees employee = employeeRepository.findById(34).get();
        employee.setName(employeeCG.getName());
        employee.setSurname(employeeCG.getSurname());
        employee.setTelephone_number(employeeCG.getTelephone_number());
        Address addressCG = employeeCG.getAddres();
        addressCG.setAddres_id(employee.getAddres().getAddres_id());
        employee.setAddres(addressCG);
        employeeRepository.save(employee);
        model.addAttribute("personalInfo",employee);
        return "wmanagerData";
    }

    @GetMapping("/wmanager/Employees/Edit/{id}")
    public String wmanagerEmployeesEdit(Model model, @PathVariable Integer id){
        Employees employee = employeeRepository.findById(id).get();
        model.addAttribute("employee",employee);
        return "wmanagerEmployeesEdit";
    }

    @PostMapping(value = "/wmanager/Employees/update",  consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String wmanagerEmployeesUpdate(Employees employeeCG, Model model){
        Employees employee = employeeRepository.findById(34).get();
        employee.setName(employeeCG.getName());
        employee.setSurname(employeeCG.getSurname());
        employee.setTelephone_number(employeeCG.getTelephone_number());
        Address addressCG = employeeCG.getAddres();
        addressCG.setAddres_id(employee.getAddres().getAddres_id());
        employee.setAddres(addressCG);
        employeeRepository.save(employee);
        List<Employees> employees = employeeRepository.findEmployeeByLocation_locationId(0);
        model.addAttribute("Employees",employees);
        return "wmanagerEmployees";
    }

    @GetMapping("/wmanager/Employees/Add")
    public String wmanagerEmployeesAdd(Model model){
        Employees employee = new Employees();
        model.addAttribute("employee",employee);
        return "wmanagerEmployeesAdd";
    }

    @PostMapping(value = "/wmanager/Employees/Add/update",  consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String wmanagerEmployeesAddUpdate(Employees employeeCG, Model model){
        Employees employee = employeeRepository.findById(17).get();
        employee.setEmployeeId(employeeCG.getEmployeeId());
        employee.setName(employeeCG.getName());
        employee.setSurname(employeeCG.getSurname());
        employee.setTelephone_number(employeeCG.getTelephone_number());
        Address addressCG = employeeCG.getAddres();
        addressCG.setAddres_id(employeeCG.getEmployeeId());
        employee.setAddres(addressCG);
        employeeRepository.save(employee);
        return "/wmanager/home";
    }

    @DeleteMapping(value = "/wmanager/Employees/Delete/{id}")
    public String wmanagerEmployeeDelete(@PathVariable Integer id){
        employeeRepository.deleteById(id);
        return "/wmanager/home";
    }
}