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
    public Workshop(Integer location_id, String location_name, Integer w_workstation_count, String a_city_name, String a_street, String a_building_number, String a_apartment_number, String a_zip_code) {
        this.location_id = location_id;
        this.location_name = location_name;
        this.w_workstation_count = w_workstation_count;
        this.a_city_name = a_city_name;
        this.a_street = a_street;
        this.a_building_number = a_building_number;
        this.a_apartment_number = a_apartment_number;
        this.a_zip_code = a_zip_code;
    }

    public Workshop(WorkshopDB workshopDB, LocationDB locationDB, Addres addres){
        this(locationDB.location_id(), locationDB.location_name(), workshopDB.w_workstation_count(),addres.city_name(),addres.street(),addres.building_number(),addres.apartment_number(),addres.zip_code() );
    }
}
