package A13.BADA.SalonSamochodowy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/main")
    public String main(){
        return "main";
    }
    @PostMapping("/")
    public String tset(){
        return "index";
    }
}
