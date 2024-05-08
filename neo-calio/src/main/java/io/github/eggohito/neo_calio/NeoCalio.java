package io.github.eggohito.neo_calio;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NeoCalio implements ModInitializer {

    public static final String MOD_NAMESPACE = "neo-calio";
    public static final Logger LOGGER = LoggerFactory.getLogger("Neo-Calio");

    @Override
    public void onInitialize() {
        LOGGER.info("Loaded Neo-Calio!");
    }

}
