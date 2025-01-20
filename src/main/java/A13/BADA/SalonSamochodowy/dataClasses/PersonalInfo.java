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
    public PersonalInfo(Integer employee_id, String name, String surname, String pesel, String telephone_number, Integer location_id, String p_position_name, String p_description, String a_city_name, String a_street, String a_building_number, String a_apartment_number, String a_zip_code) {
        this.employee_id = employee_id;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.telephone_number = telephone_number;
        this.location_id = location_id;
        this.p_position_name = p_position_name;
        this.p_description = p_description;
        this.a_city_name = a_city_name;
        this.a_street = a_street;
        this.a_building_number = a_building_number;
        this.a_apartment_number = a_apartment_number;
        this.a_zip_code = a_zip_code;
    }

    public PersonalInfo(Employee employee, Position position, Addres addres){
        this(employee.employee_id(), employee.name(), employee.surname(),
                employee.pesel(), employee.telephone_number(), employee.location_id(),
                position.position_name(), position.description(), addres.city_name(), addres.street(),
                addres.building_number(), addres.apartment_number(), addres.zip_code());
    }
}
