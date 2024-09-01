package top.alittlebot.thinking;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import top.alittlebot.thinking.entity.ModEntity;
import top.alittlebot.thinking.item.ModItems;
import top.alittlebot.thinking.ui.ModCreativeTab;

@Mod(Thinking.MODID)
public class Thinking {
    public static final String MODID = "thinking";

    public Thinking(IEventBus modEventBus) {
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTab.TABS.register(modEventBus);
        ModEntity.ENTITIES.register(modEventBus);
        // EmojiArmorMaterials.ARMOR_MATERIALS.register(modEventBus);
    }
}
