package A13.BADA.SalonSamochodowy.dataClasses;

public record Addres(
        Integer addres_id,
        String city_name,
        String street,
        String building_number,
        String apartment_number,
        String zip_code
) {
}
