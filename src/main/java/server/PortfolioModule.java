package server;

import bl.PortfolioBL;
import bl.PortfolioBLImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import dal.DBPortfolioDAL;
import dal.PortfolioDAL;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.CorsHandler;

import java.util.ServiceLoader;

public class PortfolioModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PortfolioDAL.class).to(DBPortfolioDAL.class);
        bind(PortfolioBL.class).to(PortfolioBLImpl.class);
    }

    @Provides
    @Singleton
    Vertx vertx(){
        VertxOptions options = new VertxOptions();
        options.setBlockedThreadCheckInterval(1000 * 60 * 60);
        Vertx vertx = Vertx.vertx(options);
        return vertx;
    }

    @Provides
    @Singleton
    Router router(Vertx vertx){
        Router router= Router.router(vertx);
        router.route().handler(CorsHandler.create("*")
                .allowedMethod(io.vertx.core.http.HttpMethod.GET)
                .allowedMethod(io.vertx.core.http.HttpMethod.POST)
                .allowedMethod(io.vertx.core.http.HttpMethod.OPTIONS)
                .allowCredentials(true)
                .allowedHeader("Access-Control-Request-Method")
                .allowedHeader("Access-Control-Allow-Credentials")
                .allowedHeader("Access-Control-Allow-Origin")
                .allowedHeader("Access-Control-Allow-Headers")
                .allowedHeader("Content-Type"));
        return router;
    }
    @Provides
    @Singleton
    Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        for (TypeAdapterFactory factory : ServiceLoader.load(TypeAdapterFactory.class)) {
            gsonBuilder.registerTypeAdapterFactory(factory);
        }
        Gson gson = gsonBuilder.create();
        return gson;
    }
}