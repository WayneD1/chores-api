package ph.gcr.choresTracker.gateway.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.gcr.choresTracker.service.ChoresService;

@RestController
@RequestMapping("/chores")
public class ChoresController {

  @Autowired
  private ChoresService choresService;

  @GetMapping
  public List<ChoresWebModel> getChores() {
    return choresService.getAll();
  }

  @PostMapping
  public ChoresWebModel saveChore(@RequestBody ChoresWebModel choresWebModel) {
    return choresService.saveChore(choresWebModel);
  }

  @DeleteMapping("/{id}")
  public void deleteChore(@PathVariable Long id) {
    choresService.deleteChore(id);
  }

}
