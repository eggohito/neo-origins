package io.github.eggohito.neo_apoli.registry;

import io.github.eggohito.neo_apoli.power.type.PowerType;
import io.github.eggohito.neo_calio.data.Factory;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.registry.Registry;

public class NeoApoliRegistries {

    public static final Registry<Factory<? extends PowerType>> POWER_TYPE = FabricRegistryBuilder
        .createSimple(NeoApoliRegistryKeys.POWER_TYPE)
        .attribute(RegistryAttribute.SYNCED)
        .buildAndRegister();

    public static void registerAll() {

    }

}
