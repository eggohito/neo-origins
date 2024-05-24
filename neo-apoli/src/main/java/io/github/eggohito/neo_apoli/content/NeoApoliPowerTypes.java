package io.github.eggohito.neo_apoli.content;

import com.mojang.serialization.MapCodec;
import io.github.eggohito.neo_apoli.NeoApoli;
import io.github.eggohito.neo_apoli.power.type.DummyPowerType;
import io.github.eggohito.neo_apoli.power.type.MultiplePowerType;
import io.github.eggohito.neo_apoli.power.type.PowerType;
import io.github.eggohito.neo_apoli.registry.NeoApoliRegistries;
import io.github.eggohito.neo_calio.data.Factory;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class NeoApoliPowerTypes {

    public static final Factory<DummyPowerType> DUMMY = register("dummy", DummyPowerType.CODEC);
    public static final Factory<MultiplePowerType> MULTIPLE = register("multiple", MultiplePowerType.CODEC);

    public static void registerAll() {

    }

    public static <T extends PowerType> Factory<T> register(String path, MapCodec<T> codec) {
        Identifier id = NeoApoli.identifier(path);
        return Registry.register(NeoApoliRegistries.POWER_TYPE, id, new Factory<>(id, codec));
    }

}
