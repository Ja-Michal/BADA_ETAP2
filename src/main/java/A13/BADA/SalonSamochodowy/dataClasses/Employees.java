package A13.BADA.SalonSamochodowy.dataClasses;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Employees implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_seq")
        @SequenceGenerator(name = "employee_id_seq", sequenceName = "employee_id_seq", allocationSize = 17)
        private Integer employeeId;
        private String name;
        private String surname;
        private String pesel;
        private String telephone_number;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "locationId")
        private Locations location;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "position_id")
        private Positions position;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "addres_id")
        private Address addres;
        @ManyToMany(mappedBy = "assignedEmployees", cascade = CascadeType.ALL)
        private Set<Services> assigned_services;

        public Employees() {
        }

        public Employees(String name, String surname, String pesel, String telephone_number, Locations location, Positions position, Address addres, Set<Services> assigned_services) {
                this.name = name;
                this.surname = surname;
                this.pesel = pesel;
                this.telephone_number = telephone_number;
                this.location = location;
                this.position = position;
                this.addres = addres;
                this.assigned_services = assigned_services;
        }

        public Integer getEmployeeId() {
                return employeeId;
        }

        public String getName() {
                return name;
        }

        public String getSurname() {
                return surname;
        }

        public String getPesel() {
                return pesel;
        }

        public String getTelephone_number() {
                return telephone_number;
        }

        public Locations getLocation() {
                return location;
        }

        public Positions getPosition() {
                return position;
        }

        public Address getAddres() {
                return addres;
        }

        public Set<Services> getAssigned_services() {
                return assigned_services;
        }

        public void setEmployeeId(Integer employeeId) {
                this.employeeId = employeeId;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setSurname(String surname) {
                this.surname = surname;
        }

        public void setPesel(String pesel) {
                this.pesel = pesel;
        }

        public void setTelephone_number(String telephone_number) {
                this.telephone_number = telephone_number;
        }

        public void setLocation(Locations location) {
                this.location = location;
        }

        public void setPosition(Positions position) {
                this.position = position;
        }

        public void setAddres(Address addres) {
                this.addres = addres;
        }

        public void setAssigned_services(Set<Services> assigned_services) {
                this.assigned_services = assigned_services;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Employees employees = (Employees) o;
                return Objects.equals(employeeId, employees.employeeId) && Objects.equals(name, employees.name) && Objects.equals(surname, employees.surname) && Objects.equals(pesel, employees.pesel) && Objects.equals(telephone_number, employees.telephone_number) && Objects.equals(location, employees.location) && Objects.equals(position, employees.position) && Objects.equals(addres, employees.addres) && Objects.equals(assigned_services, employees.assigned_services);
        }

        @Override
        public int hashCode() {
                return Objects.hash(employeeId, name, surname, pesel, telephone_number, location, position, addres, assigned_services);
        }

        @Override
        public String toString() {
                return "Employees{" +
                        "employeeId=" + employeeId +
                        ", name='" + name + '\'' +
                        ", surname='" + surname + '\'' +
                        ", pesel='" + pesel + '\'' +
                        ", telephone_number='" + telephone_number + '\'' +
                        ", location=" + location +
                        ", position=" + position +
                        ", addres=" + addres +
                        ", assigned_services=" + assigned_services +
                        '}';
        }
}
