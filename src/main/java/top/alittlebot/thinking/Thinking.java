package top.alittlebot.thinking;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import top.alittlebot.thinking.item.ModItems;

@Mod(Thinking.MODID)
public class Thinking {
    public static final String MODID = "thinking";

    public Thinking(IEventBus modEventBus) {
        ModItems.ITEMS.register(modEventBus);
        // EmojiArmorMaterials.ARMOR_MATERIALS.register(modEventBus);
    }
}
