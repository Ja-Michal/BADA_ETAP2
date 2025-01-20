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
    public Car(Integer car_id, String registration, Date manofactouring_date, Integer millage, Date inspection_date, CarState state, Integer m_model_id, String m_model_name, Integer b_brand_id, String b_brand_name) {
        this.car_id = car_id;
        this.registration = registration;
        this.manofactouring_date = manofactouring_date;
        this.millage = millage;
        this.inspection_date = inspection_date;
        this.state = state;
        this.m_model_id = m_model_id;
        this.m_model_name = m_model_name;
        this.b_brand_id = b_brand_id;
        this.b_brand_name = b_brand_name;
    }

    public Car(CarDB carDB, Brand brand, Model model){
        this(carDB.car_id(), carDB.registration(), carDB.manufacturing_date(),carDB.millage(),carDB.next_inspection_date(),carDB.technical_state(), model.model_id(), model.model_name(), brand.brand_id(), brand.brand_name());
    }
}
