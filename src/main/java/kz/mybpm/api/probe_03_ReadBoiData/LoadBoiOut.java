package kz.mybpm.api.probe_03_ReadBoiData;

import java.util.Map;

public class LoadBoiOut {
  public String              boiId;
  public String              boCode;
  public LoadBoiOutState     state;
  public Map<String, String> fieldValues;

  @Override
  public String toString() {
    return "ReadBoiOut{" +
      "boiId='" + boiId + '\'' +
      ", boCode='" + boCode + '\'' +
      ", state=" + state +
      ", fieldValues=" + fieldValues +
      '}';
  }
}
