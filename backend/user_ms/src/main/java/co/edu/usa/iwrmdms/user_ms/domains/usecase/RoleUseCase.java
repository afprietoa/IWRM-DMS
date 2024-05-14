package co.edu.usa.iwrmdms.user_ms.domains.usecase;

import co.edu.usa.iwrmdms.user_ms.domains.api.IRoleServicePort;
import co.edu.usa.iwrmdms.user_ms.domains.model.Role;
import co.edu.usa.iwrmdms.user_ms.domains.spi.IRolePersistencePort;

import java.util.List;

public class RoleUseCase implements IRoleServicePort {
    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public List<Role> getAllRoles() {
        return rolePersistencePort.getAllRoles();
    }
}
