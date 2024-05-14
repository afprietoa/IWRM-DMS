package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.repositories;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMeasurementRepository extends JpaRepository<MeasurementEntity, Integer> {
}
