package A13.BADA.SalonSamochodowy.dataClasses;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Workshops implements Serializable {
        @Id
        private Integer locationId;
        @OneToOne(orphanRemoval = true)
        @JoinColumn(name = "locationId")
        private Locations location;
        private Integer workstation_count;
        @ManyToMany
        @JoinTable(
                name = "serviced_brands",
                joinColumns = @JoinColumn(name = "locationId"),
                inverseJoinColumns = @JoinColumn(name = "brand_id")
        )
        private Set<Brands> serviced_brands;

        protected Workshops(){

        }

        public Workshops(Locations location, Integer workstation_count,Set<Brands> serviced_brands) {
                this.location = location;
                this.workstation_count = workstation_count;
                this.serviced_brands = serviced_brands;
        }

        public Integer getLocation_id() {
                return locationId;
        }

        public Locations getLocation() {
                return location;
        }

        public Integer getWorkstation_count() {
                return workstation_count;
        }

        public Set<Brands> getServiced_brands() {return serviced_brands;}

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Workshops workshops = (Workshops) o;
                return Objects.equals(locationId, workshops.locationId) && Objects.equals(location, workshops.location) && Objects.equals(workstation_count, workshops.workstation_count) && Objects.equals(serviced_brands, workshops.serviced_brands);
        }

        @Override
        public int hashCode() {
                return Objects.hash(locationId, location, workstation_count, serviced_brands);
        }

        @Override
        public String toString() {
                return "Workshops{" +
                        "location_id=" + locationId +
                        ", location=" + location +
                        ", workstation_count=" + workstation_count +
                        ", serviced_brands=" + serviced_brands +
                        '}';
        }
}
