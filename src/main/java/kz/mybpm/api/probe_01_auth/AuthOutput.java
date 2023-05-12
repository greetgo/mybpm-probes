package kz.mybpm.api.probe_01_auth;

public class AuthOutput {
  public String token;

  @Override
  public String toString() {
    return "AuthResponse{" +
      "token='" + token + '\'' +
      '}';
  }
}
