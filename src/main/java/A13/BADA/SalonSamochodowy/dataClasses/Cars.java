package A13.BADA.SalonSamochodowy.dataClasses;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Cars implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_id_seq")
        @SequenceGenerator(name = "car_id_seq", sequenceName = "car_id_seq", allocationSize = 1)
        private Integer car_id;
        private String registration;
        private Date manufacturing_date;
        private Integer millage;
        private Date next_inspection_date;
        @Enumerated(EnumType.STRING)
        private CarState technical_state;
        @ManyToOne
        @JoinColumn(name = "model_id")
        private Models model;

        protected Cars() {
        }

        public Cars(String registration, Date manufacturing_date, Integer millage, Date next_inspection_date, CarState technical_state, Models model) {
                this.registration = registration;
                this.manufacturing_date = manufacturing_date;
                this.millage = millage;
                this.next_inspection_date = next_inspection_date;
                this.technical_state = technical_state;
                this.model = model;
        }

        public Integer getCar_id() {
                return car_id;
        }

        public String getRegistration() {
                return registration;
        }

        public Date getManufacturing_date() {
                return manufacturing_date;
        }

        public Integer getMillage() {
                return millage;
        }

        public Date getNext_inspection_date() {
                return next_inspection_date;
        }

        public CarState getTechnical_state() {
                return technical_state;
        }

        public Models getModel() {
                return model;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Cars cars = (Cars) o;
                return Objects.equals(car_id, cars.car_id) && Objects.equals(registration, cars.registration) && Objects.equals(manufacturing_date, cars.manufacturing_date) && Objects.equals(millage, cars.millage) && Objects.equals(next_inspection_date, cars.next_inspection_date) && technical_state == cars.technical_state && Objects.equals(model, cars.model);
        }

        @Override
        public int hashCode() {
                return Objects.hash(car_id, registration, manufacturing_date, millage, next_inspection_date, technical_state, model);
        }

        @Override
        public String toString() {
                return "Cars{" +
                        "car_id=" + car_id +
                        ", registration='" + registration + '\'' +
                        ", manufacturing_date=" + manufacturing_date +
                        ", millage=" + millage +
                        ", next_inspection_date=" + next_inspection_date +
                        ", technical_state=" + technical_state +
                        ", model=" + model +
                        '}';
        }
}

