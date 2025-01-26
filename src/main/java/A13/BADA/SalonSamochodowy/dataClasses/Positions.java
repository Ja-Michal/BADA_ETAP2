package A13.BADA.SalonSamochodowy.dataClasses;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Positions implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_id_seq")
        @SequenceGenerator(name = "position_id_seq", sequenceName = "position_id_seq", allocationSize = 1)
        private Integer position_id;
        private String position_name;
        private String description;

        public Positions() {
        }

        public Positions(String position_name, String description) {
                this.position_name = position_name;
                this.description = description;
        }

        public Integer getPosition_id() {
                return position_id;
        }

        public String getPosition_name() {
                return position_name;
        }

        public String getDescription() {
                return description;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Positions positions = (Positions) o;
                return Objects.equals(position_id, positions.position_id) && Objects.equals(position_name, positions.position_name) && Objects.equals(description, positions.description);
        }

        @Override
        public int hashCode() {
                return Objects.hash(position_id, position_name, description);
        }

        @Override
        public String toString() {
                return "Positions{" +
                        "position_id=" + position_id +
                        ", position_name='" + position_name + '\'' +
                        ", description='" + description + '\'' +
                        '}';
        }
}
