package server;

import bl.InvestingPropertyManager;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import facades.RequestHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import org.apache.log4j.Logger;

public class ServerVerticle extends AbstractVerticle {
    private Integer port;
    private RequestHandler requestHandler;
    private Router router;
    static Logger logger = Logger.getLogger(ServerVerticle.class);

    @Inject
    public ServerVerticle(Router router, RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
        this.router = router;
        try{
            this.port = Integer.parseInt(InvestingPropertyManager.getPropMap().get("port"));
            logger.trace("server port is:" + this.port);
        }catch (NumberFormatException ex){
            logger.error("no port given, fallback port is 3500");
            this.port = 8080;
        }
    }

    public void start(){
        HttpServer server = vertx.createHttpServer();
        Router router = this.createRouterFromRoutes();
        server.requestHandler(router).listen(this.port);
        logger.trace("server is up and running...");
    }
    Router createRouterFromRoutes(){
        router.route("/*").handler(BodyHandler.create());
        router.get("/allInstruments").handler(requestHandler::getInstruments);
        router.get("/signUp").handler(requestHandler::addUser);
        router.get("/login").handler(requestHandler::getUser);
        router.get("/removeInstrument").handler(requestHandler::removeInstruments);
        router.get("/addInstrument").handler(requestHandler::addInstruments);
        return router;
    }
}
