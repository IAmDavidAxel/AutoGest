package server;

import javafx.beans.property.Property;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import server.context.Context;
import server.database.Database;
import utility.datamanager.ApplicationConfiguration;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoGestServer {

	private static final Logger SERVER_LOGGER = Logger.getLogger(AutoGestServer.class.getName());

	private Server server;

	public static void main(String[] args) throws Exception{

		SERVER_LOGGER.info("Loading application configuration parameters");
		PropertyConfiguration property = new PropertyConfiguration(ApplicationConfiguration.PROPERTIES_FILE_NAME);
		property.initialize();
		property.apply();

		SERVER_LOGGER.info("loading application context parameters, registering and initializing services");
		Context applicationContext = Context.create();
		applicationContext.registerServices();
		applicationContext.initializeResource();

		SERVER_LOGGER.info("Configuring the database");
		Database database = new Database();
		database.createDatabase(ApplicationConfiguration.sqliteDbName);

		AutoGestServer server = new AutoGestServer();
		server.start(ApplicationConfiguration.serverPort, applicationContext);
		server.join();

	}

	private void join() {
		try {
			server.join();
		} catch (Exception exception) {
			Logger.getGlobal().log(Level.SEVERE, exception.getMessage());
		} finally {
			tryStopServer();
		}
	}

	private void start(int serverPort, Context applicationContext)  throws Exception{
		server = new Server(serverPort);

		ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
		ContextHandlerCollection contextHandlerCollection = configureJersey(servletContext, applicationContext);
		server.setHandler(contextHandlerCollection);

		try {
			server.start();
			SERVER_LOGGER.info("Server started at " + server.getURI());
		} catch (Exception exception) {
			Logger.getGlobal().log(Level.SEVERE, exception.getMessage());
		} finally {
			tryStopServer();
		}

	}

	private void tryStopServer() {
		try {
			server.destroy();
		} catch (Exception e) {
			return;
		}
	}

	public void stop() {
		try {
			server.stop();
		} catch (Exception exception) {
			Logger.getGlobal().log(Level.SEVERE, exception.getMessage());
		}
	}

	private ContextHandlerCollection configureJersey(ServletContextHandler servletContext, Context applicationContext) {

		servletContext.setContextPath("/api");

		SERVER_LOGGER.info("Registering resources");

		ResourceConfig resourceConfig = ResourceConfig.forApplication( new Application(){
			@Override
			public Set<Object> getSingletons() {
				HashSet<Object> resources = new HashSet<>();
				resources.addAll(applicationContext.getResourcesContext());
				return resources;
			}
		});

		ServletContainer servletContainer = new ServletContainer(resourceConfig);
		ServletHolder servletHolder = new ServletHolder(servletContainer);
		servletContext.addServlet(servletHolder, "/*");

		// Setup http server
		ContextHandlerCollection contexts = new ContextHandlerCollection();
		contexts.setHandlers(new Handler[] { servletContext });


		return contexts;

	}
}
