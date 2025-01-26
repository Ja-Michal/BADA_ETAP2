package A13.BADA.SalonSamochodowy.dataClasses;

import jakarta.persistence.*;

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
        @ManyToOne
        @JoinColumn(name = "locationId")
        private Locations location;
        @ManyToOne
        @JoinColumn(name = "position_id")
        private Positions position;
        @ManyToOne
        @JoinColumn(name = "addres_id")
        private Address addres;
        @ManyToMany(mappedBy = "assignedEmployees")
        private Set<Services> assigned_services;

        protected Employees() {
        }

        public Employees(String name, String surname, String pesel, String telephone_number, Locations location, Positions position, Address addres) {
                this.name = name;
                this.surname = surname;
                this.pesel = pesel;
                this.telephone_number = telephone_number;
                this.location = location;
                this.position = position;
                this.addres = addres;
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

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Employees employees = (Employees) o;
                return Objects.equals(employeeId, employees.employeeId) && Objects.equals(name, employees.name) && Objects.equals(surname, employees.surname) && Objects.equals(pesel, employees.pesel) && Objects.equals(telephone_number, employees.telephone_number) && Objects.equals(location, employees.location) && Objects.equals(position, employees.position) && Objects.equals(addres, employees.addres);
        }

        @Override
        public int hashCode() {
                return Objects.hash(employeeId, name, surname, pesel, telephone_number, location, position, addres);
        }

        @Override
        public String toString() {
                return "Employees{" +
                        "employee_id=" + employeeId +
                        ", name='" + name + '\'' +
                        ", surname='" + surname + '\'' +
                        ", pesel='" + pesel + '\'' +
                        ", telephone_number='" + telephone_number + '\'' +
                        ", location=" + location +
                        ", position=" + position +
                        ", addres=" + addres +
                        '}';
        }
}
