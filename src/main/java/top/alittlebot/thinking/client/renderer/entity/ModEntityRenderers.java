package top.alittlebot.thinking.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import top.alittlebot.thinking.Thinking;
import top.alittlebot.thinking.entity.ModEntity;

@EventBusSubscriber(modid = Thinking.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityRenderers {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntity.ZAKO.get(), ZakoRenderer::new);
    }
}
