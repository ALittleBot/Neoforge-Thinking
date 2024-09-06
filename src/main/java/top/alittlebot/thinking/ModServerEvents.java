package top.alittlebot.thinking;

import net.minecraft.world.entity.animal.Cod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import top.alittlebot.thinking.entity.ModEntities;

@EventBusSubscriber(modid = Thinking.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ModServerEvents {
    @SubscribeEvent
    public static void onRegisterAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.ZAKO.get(), Cod.createAttributes().build());
    }
}
