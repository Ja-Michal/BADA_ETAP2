package A13.BADA.SalonSamochodowy.dataClasses;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Brands implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_id_seq")
        @SequenceGenerator(name = "brand_id_seq", sequenceName = "brand_id_seq", allocationSize = 1)
        private Integer brand_id;
        private String brand_name;
        @ManyToMany(mappedBy = "serviced_brands", cascade = CascadeType.ALL)
        private Set<Workshops> serviced_by;

        protected Brands() {
        }

        public Brands(String brand_name, Set<Workshops> serviced_by) {
                this.brand_name = brand_name;
                this.serviced_by = serviced_by;
        }

        public Integer getBrand_id() {
                return brand_id;
        }

        public String getBrand_name() {
                return brand_name;
        }

        public Set<Workshops> getServiced_by() {return serviced_by;}

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Brands brands = (Brands) o;
                return Objects.equals(brand_id, brands.brand_id) && Objects.equals(brand_name, brands.brand_name) && Objects.equals(serviced_by, brands.serviced_by);
        }

        @Override
        public int hashCode() {
                return Objects.hash(brand_id, brand_name, serviced_by);
        }

        @Override
        public String toString() {
                return "Brands{" +
                        "brand_id=" + brand_id +
                        ", brand_name='" + brand_name + '\'' +
                        ", serviced_by=" + serviced_by +
                        '}';
        }
}
