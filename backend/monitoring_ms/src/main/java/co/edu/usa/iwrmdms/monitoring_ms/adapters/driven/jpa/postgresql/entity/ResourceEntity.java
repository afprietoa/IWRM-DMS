package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity;


import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="resources")
@Data
public class ResourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resourceId;
    private String name;
    private Type type;
    private Float latitude;
    private Float longitude;
    private String location;
}
