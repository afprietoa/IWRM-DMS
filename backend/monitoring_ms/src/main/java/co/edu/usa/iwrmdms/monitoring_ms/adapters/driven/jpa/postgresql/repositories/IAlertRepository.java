package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.repositories;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.AlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlertRepository extends JpaRepository<AlertEntity, Integer> {
}
