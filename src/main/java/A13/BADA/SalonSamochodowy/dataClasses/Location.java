package A13.BADA.SalonSamochodowy.dataClasses;

public record Location(
        Integer location_id,
        String location_name,
        String a_city_name,
        String a_street,
        String a_building_number,
        String a_apartment_number,
        String a_zip_code
) {
    public Location(Integer location_id, String location_name, String a_city_name, String a_street, String a_building_number, String a_apartment_number, String a_zip_code) {
        this.location_id = location_id;
        this.location_name = location_name;
        this.a_city_name = a_city_name;
        this.a_street = a_street;
        this.a_building_number = a_building_number;
        this.a_apartment_number = a_apartment_number;
        this.a_zip_code = a_zip_code;
    }

    public Location(LocationDB locationDB, Addres addres){
        this(locationDB.location_id(), locationDB.location_name(),addres.city_name(),addres.street(),addres.building_number(),addres.apartment_number(),addres.zip_code());
    }
}
