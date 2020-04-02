package bl;

import entities.Instrument;
import entities.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface PortfolioBL {

    List<Instrument> getAllInstruments();

    void addUserInstruments(String userName, List<String> instrumentToAdd);

    void removeUserInstruments(String userName, List<String> instrumentToRemove);

    void addUser(Consumer<Optional<User>> consumer, String userName);

    void initialize();

    void getUser(Consumer<Optional<User>> consumer, String userName);
}
