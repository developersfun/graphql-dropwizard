import com.tdf.Config;
import com.tdf.Device;
import com.tdf.DeviceDAO;
import com.tdf.MyController;
import com.tdf.graphql.DeviceDataFetcher;
import com.tdf.graphql.MyGraphQLSchema;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Bootstrap Class for Dropwizard Application.
 * @version 1.0
 * @since 2020
 * @author thedevelopersfun
 */
public class MainApp extends Application<Config> {

    /**
     * Runner Method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Running");
        new MainApp().run(args);
    }

    /**
     * Run configuration
     * @param config
     * @param environment
     * @throws Exception
     */
    public void run(Config config, Environment environment) throws Exception {

        final DeviceDAO deviceDAO = new DeviceDAO(hibernate.getSessionFactory());
        final DeviceDataFetcher df = new DeviceDataFetcher(deviceDAO);
        final MyGraphQLSchema sch = new MyGraphQLSchema(df);
        sch.init();
        final MyController resource = new MyController(deviceDAO, sch);
        environment.
                jersey().register(resource);

        System.out.println("conf "+config.getPerson());
    }

    /**
     * Hibernate configuration.
     */
    public HibernateBundle<Config> hibernate = new HibernateBundle<Config>(Device.class) {
        public DataSourceFactory getDataSourceFactory(Config configuration) {
            final DataSourceFactory database = configuration.getDatabase();
            return database;
        }
    };

    @Override
    public void initialize(Bootstrap<Config> bootstrap) {
        bootstrap.addBundle(hibernate);
    }
}
