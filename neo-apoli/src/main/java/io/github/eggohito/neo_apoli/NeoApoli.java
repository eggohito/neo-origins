package io.github.eggohito.neo_apoli;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NeoApoli implements ModInitializer {

    public static final String MOD_NAMESPACE = "neo-apoli";
    public static final Logger LOGGER = LoggerFactory.getLogger("Neo-Apoli");

    @Override
    public void onInitialize() {
        LOGGER.info("Loaded Neo-Apoli!");
    }

}
