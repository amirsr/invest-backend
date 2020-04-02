package dal;

import entities.Instrument;
import entities.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface PortfolioDAL {

    void getAllInstruments(Consumer<List<Instrument>> action);
    void getUser(Consumer<Optional<User>> action, String userName);
    void addUser(Consumer<Boolean> action, String userName);
    void deleteInstrumentForUser(String userName, Optional<String> instrumentIdsAsString);
    void initialize();

    void addInstrumentForUser(String userName, String instrumentIdsAsString);
}
