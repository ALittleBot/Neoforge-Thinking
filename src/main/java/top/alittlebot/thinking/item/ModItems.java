package top.alittlebot.thinking.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.alittlebot.thinking.Thinking;
import top.alittlebot.thinking.entity.ModEntities;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Thinking.MODID);

    public static final String SMILE_EMOJI_ID = "smile_emoji";
    public static final String BRAIN_ID = "brain";
    public static final String POTION_THROWING_GLOVE_ID = "potion_throwing_glove";
    public static final String ZAKO_SPAWN_EGG_ID = "zako_spawn_egg";
    public static final String ZAKO_ID = "zako";
    public static final String BILI_COIN_ID = "bili_coin";
    public static final String COOKED_BILI_COIN_ID = "cooked_bili_coin";

    public static final Supplier<Item> SMILE_EMOJI_ITEM;
    public static final Supplier<Item> BRAIN_ITEM;
    public static final Supplier<Item> POTION_THROWING_GLOVE_ITEM;
    public static final Supplier<Item> ZAKO_SPAWN_EGG_ITEM;
    public static final Supplier<Item> ZAKO_ITEM;
    public static final Supplier<Item> BILI_COIN_ITEM;
    public static final Supplier<Item> COOKED_BILI_COIN_ITEM;

    static {
        /*
        SMILE_EMOJI_ITEM = ITEMS.register(SMILE_EMOJI_ID, () -> new ArmorItem(
                ArmorMaterials.IRON,
                ArmorItem.Type.HELMET,
                new Item.Properties().stacksTo(1)
        ));
        */
        SMILE_EMOJI_ITEM = ITEMS.registerSimpleItem(SMILE_EMOJI_ID);
        BRAIN_ITEM = ITEMS.registerSimpleItem(BRAIN_ID);
        POTION_THROWING_GLOVE_ITEM = ITEMS.register(POTION_THROWING_GLOVE_ID, () -> new PotionThrowingGloveItem(new Item.Properties().stacksTo(1)));
        ZAKO_ITEM = ITEMS.register(ZAKO_ID, () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.4F).build())));
        ZAKO_SPAWN_EGG_ITEM = ITEMS.register(ZAKO_SPAWN_EGG_ID, () -> new SpawnEggItem(ModEntities.ZAKO.get(), 0xFFFFFF, 0xFFFFFF, new Item.Properties()));  // 只能这么写, 麻将能不能优化一下 (╬▔皿▔)╯
        BILI_COIN_ITEM = ITEMS.register(BILI_COIN_ID, () -> new BiliCoinItem(new Item.Properties().stacksTo(16)));
        COOKED_BILI_COIN_ITEM = ITEMS.register(COOKED_BILI_COIN_ID, () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(6)
                .saturationModifier(9.6F)
                .alwaysEdible()
                .build())));
    }
}
