package io.quarkus.workshop.superheroes.villain;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.configuration.ConfigUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.jboss.logging.Logger;

@ApplicationScoped
public class VillainApplicationLifeCycle {

    private static final Logger LOGGER = Logger.getLogger(VillainApplicationLifeCycle.class);

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info(" _   _ _           _____  _____  _____    ___ ");
        LOGGER.info("| \\ | (_)         |  __ \\/ __  \\|  _  |  /   |");
        LOGGER.info("|  \\| |_  ___ ___ | |  \\/`' / /'| |/' | / /| |");
        LOGGER.info("| . ` | |/ __/ _ \\| | __   / /  |  /| |/ /_| |");
        LOGGER.info("| |\\  | | (_| (_) | |_\\ \\./ /___\\ |_/ /\\___  |");
        LOGGER.info("\\_| \\_/_|\\___\\___/ \\____/\\_____/ \\___/     |_/");
        LOGGER.info("                                              ");
        LOGGER.info("The application VILLAIN is starting with profile " + ConfigUtils.getProfiles());
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application VILLAIN is stopping...");
    }
}
