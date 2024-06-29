package co.edu.usa.iwrmdms.monitoring_ms.domains.api;

public interface IAuthenticationUserInfoServicePort {
    String getUsernameFromToken();
    Long getIdUserFromToken();
}
