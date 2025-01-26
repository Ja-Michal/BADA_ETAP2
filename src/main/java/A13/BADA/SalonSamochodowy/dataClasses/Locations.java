package A13.BADA.SalonSamochodowy.dataClasses;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Locations implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_id_seq")
        @SequenceGenerator(name = "location_id_seq", sequenceName = "location_id_seq",allocationSize = 1)
        private Integer locationId;
        private String location_name;
        @ManyToOne
        @JoinColumn(name = "addres_id")
        private Address addres;

        protected Locations() {
        }

        public Locations(String location_name, Address addres) {
                this.location_name = location_name;
                this.addres = addres;
        }

        public Integer getLocationId() {
                return locationId;
        }

        public String getLocation_name() {
                return location_name;
        }

        public Address getAddres() {
                return addres;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Locations locations = (Locations) o;
                return Objects.equals(locationId, locations.locationId) && Objects.equals(location_name, locations.location_name) && Objects.equals(addres, locations.addres);
        }

        @Override
        public int hashCode() {
                return Objects.hash(locationId, location_name, addres);
        }

        @Override
        public String toString() {
                return "Locations{" +
                        "location_id=" + locationId +
                        ", location_name='" + location_name + '\'' +
                        ", addres_id=" + addres +
                        '}';
        }
}
