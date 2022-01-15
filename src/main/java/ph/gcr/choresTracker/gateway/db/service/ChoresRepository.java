package ph.gcr.choresTracker.gateway.db.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ph.gcr.choresTracker.gateway.db.ChoresEntity;

@Repository
public interface ChoresRepository extends CrudRepository<ChoresEntity, Long> {

}
