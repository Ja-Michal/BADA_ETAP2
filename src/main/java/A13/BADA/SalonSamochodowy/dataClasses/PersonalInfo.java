package A13.BADA.SalonSamochodowy.dataClasses;

public record PersonalInfo(
        Integer employee_id,
        String name,
        String surname,
        String pesel,
        String telephone_number,
        Integer location_id,

        String p_position_name,
        String p_description,

        String a_city_name,
        String a_street,
        String a_building_number,
        String a_apartment_number,
        String a_zip_code
) {
}
