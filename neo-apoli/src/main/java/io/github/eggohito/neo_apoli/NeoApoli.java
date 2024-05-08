package io.github.eggohito.neo_apoli;

import io.github.eggohito.neo_apoli.content.NeoApoliPowerTypes;
import io.github.eggohito.neo_apoli.power.Power;
import io.github.eggohito.neo_apoli.registry.NeoApoliRegistries;
import io.github.eggohito.neo_apoli.registry.NeoApoliRegistryKeys;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NeoApoli implements ModInitializer {

    public static final String MOD_NAMESPACE = "neo-apoli";
    public static final Logger LOGGER = LoggerFactory.getLogger("Neo-Apoli");

    @Override
    public void onInitialize() {

        NeoApoliRegistryKeys.registerAll();
        NeoApoliRegistries.registerAll();

        NeoApoliPowerTypes.registerAll();
        DynamicRegistries.registerSynced(NeoApoliRegistryKeys.POWER, Power.CODEC, DynamicRegistries.SyncOption.SKIP_WHEN_EMPTY);

        CommonLifecycleEvents.TAGS_LOADED.register((registries, client) -> {

            if (client) {
                return;
            }

            Registry<Power> powerRegistry = registries.get(NeoApoliRegistryKeys.POWER);

            LOGGER.info("Loaded " + powerRegistry.stream().count() + " power(s)");
            LOGGER.info("Loaded " + powerRegistry.streamTags().count() + " power tag(s)");

        });

        LOGGER.info("Loaded Neo-Apoli!");

    }

    public static Identifier identifier(String path) {
        return Identifier.of(MOD_NAMESPACE, path);
    }

}
