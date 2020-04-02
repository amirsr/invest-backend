package facades;

import bl.PortfolioBL;
import com.google.gson.Gson;
import com.google.inject.Inject;
import entities.Instrument;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;
import org.apache.log4j.Logger;

import java.util.List;

public class RequestHandler {
    @Inject
    Gson gson;

    @Inject
    PortfolioBL portfolioBl;
    static Logger logger = Logger.getLogger(RequestHandler.class);

    public void getInstruments(RoutingContext routingContext) {
        HttpServerResponse response = routingContext.response();
        response.putHeader("content-type", "application/json");
        String responseString = "";
        logger.info("received request for all instruments");
        List<Instrument>instruments = portfolioBl.getAllInstruments();
        responseString = gson.toJson(instruments);
        response.putHeader("content-length", responseString.length()+"");
        response.write(responseString);
        routingContext.end();
    }

    public void getUser(RoutingContext routingContext) {
        String userName = routingContext.queryParam("userName").get(0);
        logger.info("received request for user login");
        portfolioBl.getUser(user1 -> {
            HttpServerResponse response = routingContext.response();
            if(user1.isPresent()){
                String responseString = gson.toJson(user1.get());
                response.putHeader("content-type", "application/json");
                response.putHeader("content-length", responseString.length()+"");
                response.write(responseString);
            }else{
                   response.setStatusCode(404);
            }
            routingContext.end();
        },userName);
    }

    public void addUser(RoutingContext routingContext) {
        logger.info("received request to add user");
        String userName = routingContext.queryParam("userName").get(0);
        portfolioBl.addUser(user1 -> {
            HttpServerResponse response = routingContext.response();
            if(user1.isPresent()){
                String responseString = gson.toJson(user1.get());
                response.putHeader("content-type", "application/json");
                response.putHeader("content-length", responseString.length()+"");
                response.write(responseString);
            }else{
                response.setStatusCode(404);
            }
            routingContext.end();
        },userName);
    }

    public void addInstruments(RoutingContext routingContext) {
        String userName = routingContext.queryParam("userName").get(0);
        logger.info("received request to add instruments from user: "+userName);
        List<String> instrumentIds = routingContext.queryParam("addedIds");
        portfolioBl.addUserInstruments(userName,instrumentIds);
        routingContext.response().setStatusCode(200);
        routingContext.end();
    }
    public void removeInstruments(RoutingContext routingContext) {
        String userName = routingContext.queryParam("userName").get(0);
        logger.info("received request to remove instruments from user: "+userName);
        List<String> instrumentIds = routingContext.queryParam("removedIds");
        portfolioBl.removeUserInstruments(userName,instrumentIds);
        routingContext.response().setStatusCode(200);
        routingContext.end();
    }
}
