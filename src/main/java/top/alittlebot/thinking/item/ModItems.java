package top.alittlebot.thinking.item;

import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.alittlebot.thinking.Thinking;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Thinking.MODID);

    public static final String SMILE_EMOJI_ID = "smile_emoji";

    public static final Supplier<Item> SMILE_EMOJI_ITEM;

    static {
        /*
        SMILE_EMOJI_ITEM = ITEMS.register(SMILE_EMOJI_ID, () -> new ArmorItem(
                ArmorMaterials.IRON,
                ArmorItem.Type.HELMET,
                new Item.Properties().stacksTo(1)
        ));
         */
        SMILE_EMOJI_ITEM = ITEMS.registerSimpleItem(SMILE_EMOJI_ID);
    }
}
