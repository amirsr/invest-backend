package dal;

import bl.InvestingPropertyManager;
import com.google.inject.Inject;
import entities.ImmutableInstrument;
import entities.ImmutableUser;
import entities.Instrument;
import entities.User;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLClient;
import io.vertx.ext.sql.SQLConnection;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class DBPortfolioDAL implements PortfolioDAL {
    @Inject
    Vertx vertx;
    static Logger logger = Logger.getLogger(DBPortfolioDAL.class);
    SQLClient client;

    @Override
    public void initialize() {

        JsonObject config = new JsonObject()
                .put("url", InvestingPropertyManager.getPropMap().get("url"))
                .put("driver_class", InvestingPropertyManager.getPropMap().get("driver_class"))
                .put("max_pool_size", Integer.parseInt(InvestingPropertyManager.getPropMap().get("max_pool_size")))
                .put("user",InvestingPropertyManager.getPropMap().get("userName"))
                .put("password", InvestingPropertyManager.getPropMap().get("password"));

        this.client = JDBCClient.createShared(vertx, config);
    }

    @Override
    public void getAllInstruments(Consumer<List<Instrument>> action) {
        client.getConnection(connectionResult -> {
            if (connectionResult.succeeded()) {
                SQLConnection connection = connectionResult.result();
                try{
                    connection.query("SELECT * FROM instrument", res2 -> {
                    if (res2.succeeded()) {
                        ResultSet rs = res2.result();
                        // Do something with results
                        List<Instrument> instruments = rs.getResults().stream().map(jsonObject->ImmutableInstrument.builder()
                                .instrumentId(jsonObject.getInteger(0))
                                .name(jsonObject.getString(1))
                                .symbol(jsonObject.getString(2))
                                .instrumentType(jsonObject.getString(3))
                                .build()).collect(Collectors.toList());
                        action.accept(instruments);
                    }
                    connection.close();
                    });
                }catch (Exception e){
                    connection.close();
                    logger.warn(e.getMessage());
                }
            } else {
                logger.warn("could not get connection");
        }});
    }

    @Override
    public void getUser(Consumer<Optional<User>> action, String userName) {
        client.getConnection(connectionResult -> {
            if (connectionResult.succeeded()) {
                SQLConnection connection = connectionResult.result();
                try{
                connection.query("SELECT * FROM users where USER_NAME ='"+userName+"'", res2 -> {
                    if (res2.succeeded()) {
                        ResultSet rs = res2.result();
                        List<Integer> userData = new ArrayList<>();
                        User user;
                        if(rs.getResults().size()==0){
                            user = null;
                        }else{
                            rs.getResults().forEach(userRow ->{
                                if(userRow.getInteger(1) != -1){
                                    userData.add(userRow.getInteger(1));
                                }
                            });
                            user = ImmutableUser.builder().userName(userName)
                                        .instrumentList(userData).build();
                        }
                        action.accept(Optional.ofNullable(user));
                    }
                    connection.close();
                });
                }catch (Exception e){
                    connection.close();
                    logger.warn(e.getMessage());
                }
            } else {
                // Failed to get connection - deal with it
                logger.warn("could not get connection");
            }});
    }

    @Override
    public void addUser(Consumer<Boolean> action,String userName) {
        client.getConnection(connectionResult -> {
            if (connectionResult.succeeded()) {
                SQLConnection connection = connectionResult.result();
                try {
                    connection.query("INSERT INTO USERS (USER_NAME,INSTRUMENT_ID) VALUES ('" + userName + "',-1)", res2 -> {
                        if (res2.succeeded()) {
                            ResultSet rs = res2.result();
                            action.accept(true);
                            logger.info("create user operation completed");
                        } else {
                            logger.warn("create user operation did not complete");
                            action.accept(false);
                        }
                        connection.close();
                    });
                }catch (Exception e){
                    connection.close();
                    logger.warn(e.getMessage());
                }
            } else {
                action.accept(false);
                logger.warn("could not get connection");
            }});
    }

    @Override
    public void deleteInstrumentForUser(String userName,Optional<String> instrumentIdsAsString) {
        if(instrumentIdsAsString.isPresent()){
            client.getConnection(connectionResult -> {
                if (connectionResult.succeeded()) {
                    SQLConnection connection = connectionResult.result();
                    try {
                    connection.query("DELETE FROM USERS WHERE USER_NAME ='" + userName
                            + "' AND INSTRUMENT_ID IN ("+instrumentIdsAsString.get()+")", res2 -> {
                        if (res2.succeeded()) {

                        }else{

                        }
                        connection.close();
                    });
                    }catch (Exception e){
                        connection.close();
                        logger.warn(e.getMessage());
                    }
                } else {
                    logger.warn("could not get connection");
                }});
        }
    }
    @Override
    public void addInstrumentForUser(String userName, String instrumentIdsAsString) {
            client.getConnection(connectionResult -> {
                if (connectionResult.succeeded()) {
                    SQLConnection connection = connectionResult.result();
                    try{
                        connection.query("INSERT INTO USERS (USER_NAME,INSTRUMENT_ID) VALUES " + instrumentIdsAsString, res2 -> {
                        if (res2.succeeded()) {

                        }else{

                        }
                        connection.close();
                        });
                    }catch (Exception e){
                        connection.close();
                        logger.warn(e.getMessage());
                    }
                } else {
                    logger.warn("could not get connection");
                }});
        }
}
