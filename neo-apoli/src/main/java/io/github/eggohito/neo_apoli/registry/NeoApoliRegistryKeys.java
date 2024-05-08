package io.github.eggohito.neo_apoli.registry;

import io.github.eggohito.neo_apoli.NeoApoli;
import io.github.eggohito.neo_apoli.power.Power;
import io.github.eggohito.neo_apoli.power.type.PowerType;
import io.github.eggohito.neo_calio.data.Configuration;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class NeoApoliRegistryKeys {

    public static final RegistryKey<Registry<Power>> POWER = RegistryKey.ofRegistry(NeoApoli.identifier("power"));
    public static final RegistryKey<Registry<Configuration<? extends PowerType>>> POWER_TYPE = RegistryKey.ofRegistry(NeoApoli.identifier("power_type"));

    public static void registerAll() {

    }

}
