package io.github.eggohito.neo_apoli.content;

import com.mojang.serialization.MapCodec;
import io.github.eggohito.neo_apoli.NeoApoli;
import io.github.eggohito.neo_apoli.power.type.DummyPowerType;
import io.github.eggohito.neo_apoli.power.type.MultiplePowerType;
import io.github.eggohito.neo_apoli.power.type.PowerType;
import io.github.eggohito.neo_apoli.registry.NeoApoliRegistries;
import io.github.eggohito.neo_calio.data.Configuration;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class NeoApoliPowerTypes {

    public static final Configuration<DummyPowerType> DUMMY = register(NeoApoli.identifier("dummy"), DummyPowerType.CODEC);
    public static final Configuration<MultiplePowerType> MULTIPLE = register(NeoApoli.identifier("multiple"), MultiplePowerType.CODEC);

    public static void registerAll() {

    }

    public static <T extends PowerType> Configuration<T> register(Identifier id, MapCodec<T> codec) {
        return Registry.register(NeoApoliRegistries.POWER_TYPE, id, new Configuration<>(codec));
    }

}
