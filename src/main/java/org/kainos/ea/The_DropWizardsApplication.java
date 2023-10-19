package org.kainos.ea;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.kainos.ea.resources.DatabaseConnectorTest;

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
        // TODO: application initialization
    }

    @Override
    public void run(final The_DropWizardsConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new DatabaseConnectorTest());
    }

}
