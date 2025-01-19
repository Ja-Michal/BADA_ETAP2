package A13.BADA.SalonSamochodowy.dataClasses;


import java.util.Date;

public record Service(
        Integer service_id,
        Date start_date,
        Float cost,
        Integer car_id,
        Integer location_id,
        ServiceStatus status,
        String description
) {

}
