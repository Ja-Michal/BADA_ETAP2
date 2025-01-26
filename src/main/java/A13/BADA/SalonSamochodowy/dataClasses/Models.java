package A13.BADA.SalonSamochodowy.dataClasses;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Models implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_id_seq")
        @SequenceGenerator(name = "model_id_seq", sequenceName = "model_id_seq",allocationSize = 1)
        private Integer model_id;
        private String model_name;
        @ManyToOne
        @JoinColumn(name = "brand_id")
        private Brands brand;

        protected Models() {
        }

        public Models(String model_name, Brands brand) {
                this.model_name = model_name;
                this.brand = brand;
        }

        public Integer getModel_id() {
                return model_id;
        }

        public String getModel_name() {
                return model_name;
        }

        public Brands getBrand() {
                return brand;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Models models = (Models) o;
                return Objects.equals(model_id, models.model_id) && Objects.equals(model_name, models.model_name) && Objects.equals(brand, models.brand);
        }

        @Override
        public int hashCode() {
                return Objects.hash(model_id, model_name, brand);
        }

        @Override
        public String toString() {
                return "Models{" +
                        "model_id=" + model_id +
                        ", model_name='" + model_name + '\'' +
                        ", brand=" + brand +
                        '}';
        }
}
