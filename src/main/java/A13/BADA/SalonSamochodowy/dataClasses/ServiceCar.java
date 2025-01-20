package A13.BADA.SalonSamochodowy.dataClasses;

import java.util.Date;

public record ServiceCar(
        Integer service_id,
        Date start_date,
        Float cost,
        Integer location_id,
        ServiceStatus service_status,
        String description,

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
    public ServiceCar {
    }

    public ServiceCar(Service service, Car car){
        this(service.service_id(),service.start_date(),service.cost(),service.location_id(),service.service_status(),service.description(),car.registration(),car.manofactouring_date(),car.millage(),car.inspection_date(),car.state(),car.m_model_id(),car.m_model_name(),car.b_brand_id(),car.b_brand_name());
    }
}
