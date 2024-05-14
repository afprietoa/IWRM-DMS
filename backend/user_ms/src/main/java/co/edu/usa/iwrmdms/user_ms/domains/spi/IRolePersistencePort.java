package co.edu.usa.iwrmdms.user_ms.domains.spi;

import co.edu.usa.iwrmdms.user_ms.domains.model.Role;

import java.util.List;

public interface IRolePersistencePort {
    List<Role> getAllRoles();
}
