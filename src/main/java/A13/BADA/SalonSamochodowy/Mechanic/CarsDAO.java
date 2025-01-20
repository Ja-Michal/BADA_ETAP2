package A13.BADA.SalonSamochodowy.Mechanic;

import A13.BADA.SalonSamochodowy.dataClasses.Brand;
import A13.BADA.SalonSamochodowy.dataClasses.Car;
import A13.BADA.SalonSamochodowy.dataClasses.CarDB;
import A13.BADA.SalonSamochodowy.dataClasses.Model;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarsDAO {
    private final JdbcClient jdbcClient;

    public CarsDAO(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public Optional<Car> carFindByID(Integer id){
        Optional<CarDB> carDB = jdbcClient.sql("select * from cars where car_id=:id")
                .param("id",id)
                .query(CarDB.class)
                .optional();
        if(carDB.isEmpty()){
            return Optional.empty();
        }
        Model model = jdbcClient.sql("select * from models where model_id=:id")
                .param("id",carDB.get().model_id())
                .query(Model.class).single();
        Brand brand = jdbcClient.sql("select * from brands where brand_id=:id")
                .param("id",model.brand_id())
                .query(Brand.class).single();
        return Optional.of(new Car(carDB.get(),brand,model));
    }
}
