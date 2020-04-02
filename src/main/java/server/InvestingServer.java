package server;

import bl.PortfolioBL;
import com.google.inject.Inject;
import io.vertx.core.Vertx;
import org.apache.log4j.Logger;

public class InvestingServer {
    private Vertx vertex;
    private ServerVerticle serverVerticle;
    private PortfolioBL portfolioBl;
    static Logger logger = Logger.getLogger(InvestingServer.class);
    @Inject
    public InvestingServer(Vertx vertex, ServerVerticle serverVerticle, PortfolioBL portfolioBl) {
        this.vertex = vertex;
        this.serverVerticle = serverVerticle;
        this.portfolioBl = portfolioBl;
    }

    public void start() {
       this.portfolioBl.initialize();
       this.vertex.deployVerticle(serverVerticle).onSuccess(success->{
           logger.info("**************************** Server deployed ****************************");
       });
    }
}
