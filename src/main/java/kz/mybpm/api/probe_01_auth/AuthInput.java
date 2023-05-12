package kz.mybpm.api.probe_01_auth;

public class AuthInput {
  public String email;
  public String password;
  public String timezone;

  @Override
  public String toString() {
    return "AuthRequest{" +
      "email='" + email + '\'' +
      ", password='" + password + '\'' +
      ", timezone='" + timezone + '\'' +
      '}';
  }
}
