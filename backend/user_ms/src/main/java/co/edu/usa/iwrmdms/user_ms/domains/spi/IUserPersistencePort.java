package co.edu.usa.iwrmdms.user_ms.domains.spi;

import co.edu.usa.iwrmdms.user_ms.domains.model.User;

import java.util.List;

public interface IUserPersistencePort {
    void saveUser(User user);
    void deleteUser(User user);
    List<User> getAllInspectors(int page);
    List<User> getAllSpecialists(int page);
    List<User> getAllAssistants(int page);
    List<User> getAllVolunteers(int page);
    User getInspector(Long id);
    User getSpecialist(Long id);
    User getAssistant(Long id);
    User getVolunteer(Long id);

}
