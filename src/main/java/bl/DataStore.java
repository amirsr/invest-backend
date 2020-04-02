package bl;

import entities.Instrument;
import entities.User;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class DataStore {
    private Map<Integer, Instrument> instrumentMap;
    private static DataStore dataStore = null;
    static Logger logger = Logger.getLogger(DataStore.class);

    private DataStore(){
        this.instrumentMap = new HashMap<>();
    }

    public static DataStore getInstance(){
        if(dataStore == null){
            dataStore = new DataStore();
        }
        return dataStore;
    }

    public Map<Integer, Instrument> getInstrumentMap() {
        return instrumentMap;
    }

}
