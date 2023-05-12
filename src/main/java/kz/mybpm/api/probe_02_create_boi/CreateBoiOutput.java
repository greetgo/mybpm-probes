package kz.mybpm.api.probe_02_create_boi;

import java.util.HashMap;
import java.util.Map;

public class CreateBoiOutput {
  public String               boiId;
  public String               boCode;
  public CreateBoiOutputState state;
  public Map<String, String>  fieldValues = new HashMap<>();

  @Override
  public String toString() {
    return "CreateBoiOutput{" +
      "boiId='" + boiId + '\'' +
      ", boCode='" + boCode + '\'' +
      ", state=" + state +
      ", fieldValues=" + fieldValues +
      '}';
  }
}
