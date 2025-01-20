package A13.BADA.SalonSamochodowy.dataClasses;

import java.util.Date;

public record CarDB(
        Integer car_id,
        String registration,
        Date manofactouring_date,
        Integer millage,
        Date inspection_date,
        CarState state
) {
}
