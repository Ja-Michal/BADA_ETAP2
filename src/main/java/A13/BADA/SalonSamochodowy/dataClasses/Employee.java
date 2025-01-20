package A13.BADA.SalonSamochodowy.dataClasses;


public record Employee(
        Integer employee_id,
        String name,
        String surname,
        String pesel,
        String telephone_number,
        Integer location_id,
        Integer position_id,
        Integer addres_id
        ) {
}
