package top.alittlebot.thinking;

import net.minecraft.world.entity.animal.Cod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import top.alittlebot.thinking.entity.ModEntity;

@EventBusSubscriber(modid = Thinking.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void onRegisterAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntity.ZAKO.get(), Cod.createAttributes().build());
    }
}
