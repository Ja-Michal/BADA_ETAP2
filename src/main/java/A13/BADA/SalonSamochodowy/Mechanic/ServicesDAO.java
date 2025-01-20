package A13.BADA.SalonSamochodowy.Mechanic;

import A13.BADA.SalonSamochodowy.dataClasses.Car;
import A13.BADA.SalonSamochodowy.dataClasses.Service;
import A13.BADA.SalonSamochodowy.dataClasses.ServiceCar;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServicesDAO {
    private final JdbcClient jdbcClient;
    private final CarsDAO carsDAO;

    public ServicesDAO(JdbcClient jdbcClient, CarsDAO carsDAO){
        this.jdbcClient = jdbcClient;
        this.carsDAO = carsDAO;
    }

    public List<Service> findServicesForWorker(Integer id){
        return jdbcClient.sql("Select * from services where service_id IN (Select service_id from ASSIGNED_EMPLOYEES where employee_id = :id) and service_status != 'COMPLETED'")
                .param("id",id)
                .query(Service.class)
                .list();
    }
    public List<Service> findServicesForWorkerHist(Integer id){
        return jdbcClient.sql("Select * from services where service_id IN (Select service_id from ASSIGNED_EMPLOYEES where employee_id = :id) and service_status = 'COMPLETED'")
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
