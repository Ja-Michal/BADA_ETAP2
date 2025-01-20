package A13.BADA.SalonSamochodowy.dataClasses;

import java.util.Date;

public record CarDB(
        Integer car_id,
        String registration,
        Date manufacturing_date,
        Integer millage,
        Date next_inspection_date,
        CarState technical_state,
        Integer model_id
) {
}

