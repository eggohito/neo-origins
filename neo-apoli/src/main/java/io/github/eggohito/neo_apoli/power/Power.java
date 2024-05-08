package io.github.eggohito.neo_apoli.power;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.eggohito.neo_apoli.power.type.MultiplePowerType;
import io.github.eggohito.neo_apoli.power.type.PowerType;
import io.github.eggohito.neo_apoli.registry.NeoApoliRegistryKeys;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.Registry;
import net.minecraft.text.PlainTextContent;
import net.minecraft.text.Text;
import net.minecraft.text.TextCodecs;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.ApiStatus;

public class Power {

    public static final Codec<Power> SUB_CODEC = RecordCodecBuilder.create(instance -> instance.group(
        MultiplePowerType.NON_RECURSIVE_DISPATCH_CODEC.fieldOf("type").forGetter(Power::type),
        TextCodecs.CODEC.optionalFieldOf("name", Text.empty()).forGetter(Power::name),
        TextCodecs.CODEC.optionalFieldOf("description", Text.empty()).forGetter(Power::description),
        Codec.unit(() -> true).fieldOf("hidden").forGetter(Power::hidden)
    ).apply(instance, Power::new));
    public static final Codec<Power> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        PowerType.DISPATCH_CODEC.fieldOf("type").forGetter(Power::type),
        TextCodecs.CODEC.optionalFieldOf("name", Text.empty()).forGetter(Power::name),
        TextCodecs.CODEC.optionalFieldOf("description", Text.empty()).forGetter(Power::description),
        Codec.BOOL.optionalFieldOf("hidden", false).forGetter(Power::hidden)
    ).apply(instance, Power::new));

    private final PowerType type;
    private final boolean hidden;

    private Text name;
    private Text description;

    public Power(PowerType type, Text name, Text description, boolean hidden) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.hidden = hidden;
    }

    @ApiStatus.Internal
    public final void init(LivingEntity holder) {

        Registry<Power> powerRegistry = holder.getRegistryManager().get(NeoApoliRegistryKeys.POWER);
        Identifier powerId = powerRegistry.getId(this);

        if (powerId != null) {

            String namespace = powerId.getNamespace();
            String path = powerId.getPath();

            this.name = name.getContent() == PlainTextContent.EMPTY
                ? Text.translatable("power." + namespace + "." + path + ".name")
                : name;
            this.description = description.getContent() == PlainTextContent.EMPTY
                ? Text.translatable("power." + namespace + "." + path + ".description")
                : description;

        }

        this.type.init(holder, this);

    }

    public PowerType type() {
        return type;
    }

    public Text name() {
        return name;
    }

    public Text description() {
        return description;
    }

    public boolean hidden() {
        return hidden;
    }

}
