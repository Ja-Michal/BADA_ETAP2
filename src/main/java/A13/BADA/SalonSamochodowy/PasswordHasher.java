package A13.BADA.SalonSamochodowy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode("haslo1");
        hashedPassword = hashedPassword.replaceAll("\\$", "\\\\\\$");
        System.out.println("Hashed password: " + hashedPassword);


    }


}
