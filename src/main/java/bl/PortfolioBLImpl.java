package bl;

import com.google.inject.Inject;
import dal.DBPortfolioDAL;
import dal.PortfolioDAL;
import entities.ImmutableUser;
import entities.Instrument;
import entities.User;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.function.Consumer;

public class PortfolioBLImpl implements PortfolioBL {
    private PortfolioDAL portfolioDAL;
    static Logger logger = Logger.getLogger(PortfolioBLImpl.class);

    @Inject
    public PortfolioBLImpl(PortfolioDAL portfolioDAL) {
        this.portfolioDAL = portfolioDAL;
        this.portfolioDAL.initialize();
    }
    @Override
    public void initialize() {
        this.loadInstruments();
    }

    public void loadInstruments() {
        this.portfolioDAL.getAllInstruments(instrumentList -> {
            instrumentList.forEach(instrument->{
                DataStore.getInstance().getInstrumentMap().put(instrument.instrumentId(),instrument);
            });
        });
        ;
        logger.debug("finished setting data store");
    }

    @Override
    public List<Instrument> getAllInstruments() {
        return new ArrayList<>(DataStore.getInstance().getInstrumentMap().values());
    }
    @Override
    public void addUserInstruments(String userName, List<String> instrumentToAdd) {
        if(instrumentToAdd.size()>0){
            StringBuilder buildString = new StringBuilder();
            instrumentToAdd.stream().forEach(instToAdd-> {
                buildString.append("('").append(userName).append("',").append(instToAdd).append("),");
            });
            buildString.deleteCharAt(buildString.length()-1);
            portfolioDAL.addInstrumentForUser(userName,buildString.toString());
        }
    }
    @Override
    public void removeUserInstruments(String userName, List<String> instrumentToRemove) {
        portfolioDAL.deleteInstrumentForUser(userName,
                instrumentToRemove.stream().reduce((init,sec)->init+","+sec));
    }

    @Override
    public void addUser(Consumer<Optional<User>>consumer, String userName) {
        this.portfolioDAL.addUser(result->{
            User createdUser;
            if(result){
                createdUser = ImmutableUser.builder().userName(userName)
                        .instrumentList(Collections.EMPTY_LIST).build();
            }else{
                createdUser = null;
            }
            consumer.accept(Optional.ofNullable(createdUser));
        },userName);
    }

    @Override
    public void getUser(Consumer<Optional<User>> consumer, String userName) {
        this.portfolioDAL.getUser(consumer,userName);
    }


}
