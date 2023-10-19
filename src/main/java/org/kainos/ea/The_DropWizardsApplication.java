package org.kainos.ea;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.kainos.ea.resources.DatabaseConnectorTest;
import org.kainos.ea.resources.EmployeeController;

public class The_DropWizardsApplication extends Application<The_DropWizardsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new The_DropWizardsApplication().run(args);
    }

    @Override
    public String getName() {
        return "The_DropWizards";
    }

    @Override
    public void initialize(final Bootstrap<The_DropWizardsConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<The_DropWizardsConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(The_DropWizardsConfiguration dropwizardWebServiceConfiguration) {
                return dropwizardWebServiceConfiguration.getSwagger();
            }
        });
    }

    @Override
    public void run(final The_DropWizardsConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new DatabaseConnectorTest());
        environment.jersey().register(new EmployeeController());
    }

}
