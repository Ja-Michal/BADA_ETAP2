package A13.BADA.SalonSamochodowy.ServiceManager;

import A13.BADA.SalonSamochodowy.Mechanic.CarsDAO;
import A13.BADA.SalonSamochodowy.dataClasses.Car;
import A13.BADA.SalonSamochodowy.dataClasses.Service;
import A13.BADA.SalonSamochodowy.dataClasses.ServiceCar;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServicesDAOM {
    private final JdbcClient jdbcClient;
    private final CarsDAO carsDAO;

    public ServicesDAOM(JdbcClient jdbcClient, CarsDAO carsDAO){
        this.jdbcClient = jdbcClient;
        this.carsDAO = carsDAO;
    }

    public List<Service> findServicesForWorkshop(Integer id){
        return jdbcClient.sql("Select * from services where location_id =:id and service_status != 'COMPLETED'")
                .param("id",id)
                .query(Service.class)
                .list();
    }
    public List<Service> findServicesForWorkshopHist(Integer id){
        return jdbcClient.sql("Select * from services where location_id =:id and service_status = 'COMPLETED'")
                .param("id",id)
                .query(Service.class)
                .list();
    }

    public List<ServiceCar> serviceCars(List<Service> serviceList){
        List<ServiceCar> serviceCarList = new ArrayList<>();
        for (Service s: serviceList) {
            Car car = carsDAO.carFindByID(s.car_id()).get();
            serviceCarList.add(new ServiceCar(s,car));
        }
        return serviceCarList;
    }
}
