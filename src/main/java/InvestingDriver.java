import bl.InvestingPropertyManager;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.log4j.Logger;
import server.InvestingServer;
import server.PortfolioModule;

public class InvestingDriver {
    static Logger logger = Logger.getLogger(InvestingDriver.class);
    public static void main(String[] args) {
        InvestingPropertyManager.getPropMap();
        logger.info("loaded properties successfully");
        Injector guice = Guice.createInjector(new PortfolioModule());
        InvestingServer doctorsServer = guice.getInstance(InvestingServer.class);
        doctorsServer.start();
    }
}
