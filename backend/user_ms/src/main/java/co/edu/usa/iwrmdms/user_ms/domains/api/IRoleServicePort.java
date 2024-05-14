package co.edu.usa.iwrmdms.user_ms.domains.api;

import co.edu.usa.iwrmdms.user_ms.domains.model.Role;

import java.util.List;

public interface IRoleServicePort {
    List<Role> getAllRoles();
}
