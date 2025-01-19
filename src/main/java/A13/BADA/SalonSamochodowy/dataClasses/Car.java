package A13.BADA.SalonSamochodowy.dataClasses;


import java.util.Date;

public record Car(
        Integer car_id,
        String registration,
        Date manofactouring_date,
        Integer millage,
        Date inspection_date,
        CarState state,

        Integer m_model_id,
        String m_model_name,

        Integer b_brand_id,
        String b_brand_name
) {
}
