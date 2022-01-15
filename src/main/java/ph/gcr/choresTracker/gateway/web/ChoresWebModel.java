package ph.gcr.choresTracker.gateway.web;

public class ChoresWebModel {

  private Long id;
  private String choreName;
  private String choreDescription;
  private String doneBy;
  private Integer difficulty;

  public ChoresWebModel(){

  }

  public ChoresWebModel(Long id, String choreName, String choreDescription, String doneBy, Integer difficulty) {
    this.id = id;
    this.choreName = choreName;
    this.choreDescription = choreDescription;
    this.doneBy = doneBy;
    this.difficulty= difficulty;
  }

  public Integer getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(Integer difficulty) {
    this.difficulty = difficulty;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getChoreName() {
    return choreName;
  }

  public void setChoreName(String choreName) {
    this.choreName = choreName;
  }

  public String getChoreDescription() {
    return choreDescription;
  }

  public void setChoreDescription(String choreDescription) {
    this.choreDescription = choreDescription;
  }

  public String getDoneBy() {
    return doneBy;
  }

  public void setDoneBy(String doneBy) {
    this.doneBy = doneBy;
  }
}
