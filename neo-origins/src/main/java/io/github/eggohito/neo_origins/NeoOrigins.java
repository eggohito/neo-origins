package io.github.eggohito.neo_origins;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NeoOrigins implements ModInitializer {

    public static final String MOD_NAMESPACE = "neo-origins";
    public static final Logger LOGGER = LoggerFactory.getLogger("Neo-Origins");

    @Override
    public void onInitialize() {
        LOGGER.info("Loaded Neo-Origins!");
    }

}
