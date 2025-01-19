package A13.BADA.SalonSamochodowy.dataClasses;

public record Workshop(
        Integer location_id,
        String location_name,
        Integer w_workstation_count,
        String a_city_name,
        String a_street,
        String a_building_number,
        String a_apartment_number,
        String a_zip_code
) {
}
