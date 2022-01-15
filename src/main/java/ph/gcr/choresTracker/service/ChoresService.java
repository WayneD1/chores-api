package ph.gcr.choresTracker.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import ph.gcr.choresTracker.gateway.db.ChoresEntity;
import ph.gcr.choresTracker.gateway.db.service.ChoresRepository;
import ph.gcr.choresTracker.gateway.web.ChoresWebModel;

@Service
public class ChoresService {

  @Autowired
  private ChoresRepository choresRepository;


  public List<ChoresWebModel> getAll() {

    Iterable<ChoresEntity> chores = choresRepository.findAll();

    return StreamSupport.stream(chores.spliterator(), false).map(
        choresEntity -> new ChoresWebModel(choresEntity.getId(), choresEntity.getChoreName(),
            choresEntity.getChoreDescription(), choresEntity.getDoneBy(),
            choresEntity.getDifficulty()
        )).collect(Collectors.toList());
  }

  @Transactional
  public void deleteChore( Long id) {
    choresRepository.deleteById(id);
  }

  @Transactional
  public ChoresWebModel saveChore(ChoresWebModel choresWebModel) {

    ChoresEntity choresEntity = Optional.ofNullable(choresWebModel)
        .map(choreWebModel -> new ChoresEntity(choresWebModel.getId(), choreWebModel.getChoreName(),
            choreWebModel.getChoreDescription(), choresWebModel.getDoneBy(),
            choresWebModel.getDifficulty()))
        .orElseThrow(() -> new IllegalArgumentException());

    ChoresEntity savedChoresEntity = choresRepository.save(choresEntity);

    return Optional.of(savedChoresEntity).map(savedChore -> new ChoresWebModel(savedChore.getId(),
        savedChore.getChoreName(), savedChore.getChoreDescription(), savedChore.getDoneBy(),
        savedChore.getDifficulty())).orElseThrow(() -> new IllegalArgumentException());
  }


}
