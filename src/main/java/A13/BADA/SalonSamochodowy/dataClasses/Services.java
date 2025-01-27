package A13.BADA.SalonSamochodowy.dataClasses;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Services implements Serializable  {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_id_seq")
        @SequenceGenerator(name = "service_id_seq", sequenceName = "service_id_seq", allocationSize = 1)
        private Integer service_id;
        private Date start_date;
        private Float cost;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "car_id")
        private Cars car;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "locationId")
        private Locations location;
        @Enumerated(EnumType.STRING)
        private ServiceStatus serviceStatus;
        private String description;
        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(
                name = "assigned_employees",
                joinColumns = @JoinColumn(name = "service_id"),
                inverseJoinColumns = @JoinColumn(name = "employee_id")
        )
        private Set<Employees> assignedEmployees;

        protected Services() {
        }

        public Services(Date start_date, Float cost, Cars car, Locations location, ServiceStatus serviceStatus, String description, Set<Employees> assignedEmployees) {
                this.start_date = start_date;
                this.cost = cost;
                this.car = car;
                this.location = location;
                this.serviceStatus = serviceStatus;
                this.description = description;
                this.assignedEmployees = assignedEmployees;
        }

        public Integer getService_id() {
                return service_id;
        }

        public Date getStart_date() {
                return start_date;
        }

        public Float getCost() {
                return cost;
        }

        public Cars getCar() {
                return car;
        }

        public Locations getLocation() {
                return location;
        }

        public ServiceStatus getServiceStatus() {
                return serviceStatus;
        }

        public String getDescription() {
                return description;
        }

        public Set<Employees> getAssignedEmployees(){return assignedEmployees;}

        public void setService_id(Integer service_id) {
                this.service_id = service_id;
        }

        public void setStart_date(Date start_date) {
                this.start_date = start_date;
        }

        public void setCost(Float cost) {
                this.cost = cost;
        }

        public void setCar(Cars car) {
                this.car = car;
        }

        public void setLocation(Locations location) {
                this.location = location;
        }

        public void setServiceStatus(ServiceStatus serviceStatus) {
                this.serviceStatus = serviceStatus;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public void setAssignedEmployees(Set<Employees> assignedEmployees) {
                this.assignedEmployees = assignedEmployees;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Services services = (Services) o;
                return Objects.equals(service_id, services.service_id) && Objects.equals(start_date, services.start_date) && Objects.equals(cost, services.cost) && Objects.equals(car, services.car) && Objects.equals(location, services.location) && serviceStatus == services.serviceStatus && Objects.equals(description, services.description) && Objects.equals(assignedEmployees, services.assignedEmployees);
        }

        @Override
        public int hashCode() {
                return Objects.hash(service_id, start_date, cost, car, location, serviceStatus, description, assignedEmployees);
        }

        @Override
        public String toString() {
                return "Services{" +
                        "service_id=" + service_id +
                        ", start_date=" + start_date +
                        ", cost=" + cost +
                        ", car=" + car +
                        ", location=" + location +
                        ", serviceStatus=" + serviceStatus +
                        ", description='" + description + '\'' +
                        ", assignedEmployees=" + assignedEmployees +
                        '}';
        }
}
