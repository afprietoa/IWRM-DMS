package co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.repositories;

import co.edu.usa.iwrmdms.monitoring_ms.adapters.driven.jpa.postgresql.entity.PollutantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPollutantRepository extends JpaRepository<PollutantEntity, Integer> {
}
