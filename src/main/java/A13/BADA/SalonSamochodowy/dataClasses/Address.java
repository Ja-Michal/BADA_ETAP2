package A13.BADA.SalonSamochodowy.dataClasses;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Address implements Serializable{
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addres_id_seq")
        @SequenceGenerator(name = "addres_id_seq", sequenceName = "addres_id_seq", allocationSize = 1)
        private Integer addres_id;
        private String city_name;
        private String street;
        private String building_number;
        private String apartment_number;
        private String zip_code;

        protected Address() {
        }

        public Address(String city_name, String street, String building_number, String apartment_number, String zip_code) {
                this.city_name = city_name;
                this.street = street;
                this.building_number = building_number;
                this.apartment_number = apartment_number;
                this.zip_code = zip_code;
        }

        public Integer getAddres_id() {
                return addres_id;
        }

        public String getCity_name() {
                return city_name;
        }

        public String getStreet() {
                return street;
        }

        public void setAddres_id(Integer addres_id) {
                this.addres_id = addres_id;
        }

        public String getBuilding_number() {
                return building_number;
        }

        public String getApartment_number() {
                return apartment_number;
        }

        public String getZip_code() {
                return zip_code;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Address address = (Address) o;
                return Objects.equals(addres_id, address.addres_id) && Objects.equals(city_name, address.city_name) && Objects.equals(street, address.street) && Objects.equals(building_number, address.building_number) && Objects.equals(apartment_number, address.apartment_number) && Objects.equals(zip_code, address.zip_code);
        }

        @Override
        public int hashCode() {
                return Objects.hash(addres_id, city_name, street, building_number, apartment_number, zip_code);
        }

        @Override
        public String toString() {
                return "Address{" +
                        "addres_id=" + addres_id +
                        ", city_name='" + city_name + '\'' +
                        ", street='" + street + '\'' +
                        ", building_number='" + building_number + '\'' +
                        ", apartment_number='" + apartment_number + '\'' +
                        ", zip_code='" + zip_code + '\'' +
                        '}';
        }
}
