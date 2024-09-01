package top.alittlebot.thinking.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.alittlebot.thinking.Thinking;

import java.util.function.Supplier;

public class ModEntity {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, Thinking.MODID);

    public static final String ZAKO_ID = "zako";

    public static final Supplier<EntityType<Zako>> ZAKO;

    static {
        ZAKO = ENTITIES.register(ZAKO_ID, () -> EntityType.Builder.of(Zako::new, MobCategory.WATER_AMBIENT)
                .sized(0.5F, 0.3F)
                .eyeHeight(0.195F)
                .clientTrackingRange(4)
                .build(ZAKO_ID));
    }
}
