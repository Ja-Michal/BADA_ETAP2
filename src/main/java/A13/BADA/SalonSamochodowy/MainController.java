package A13.BADA.SalonSamochodowy;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.Collection;

@Controller
public class MainController {

    @GetMapping("/")
    public String defaultAfterLogin(Authentication authentication) {
        // Sprawdź, czy użytkownik jest zalogowany i przekieruj na stronę główną jego roli
        if (authentication != null && authentication.isAuthenticated()) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

            for (GrantedAuthority authority : authorities) {
                String role = authority.getAuthority();
                if (role.equals("ROLE_MECHANIC")) {
                    return "redirect:/mechanic/home";
                } else if (role.equals("ROLE_WMANAGER")) {
                    return "redirect:/wmanager/home";
                } else if (role.equals("ROLE_SMANAGER")) {
                    return "redirect:/smanager/home";
                } else if (role.equals("ROLE_ADMIN")) {
                    return "redirect:/admin/home";
                }

            }
        }
        return "redirect:/main"; // Domyślne przekierowanie w razie braku dopasowania roli
    }

    @GetMapping("/main")
    public String main() {
        // Strona główna dostępna dla zalogowanych użytkowników i niezalogowanych
        return "main"; // Plik main.html
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid username or password.");
        }
        return "login"; // Plik login.html
    }
}
