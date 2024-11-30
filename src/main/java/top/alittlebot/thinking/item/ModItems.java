package top.alittlebot.thinking.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
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
    public static final String COOKED_ZAKO_ID = "cooked_zako";
    public static final String BILI_COIN_ID = "bili_coin";
    public static final String COOKED_BILI_COIN_ID = "cooked_bili_coin";
    public static final String CHARRED_ZAKO_ID = "charred_zako";
    public static final String GAME_CHECKER_TOOL_ID = "game_checker_tool";
    public static final String FRAME_TOOL_ID = "frame_tool";
    public static final String MOUSE_CHECKER_TOOL_ID = "mouse_checker_tool";
    public static final String HAND_CHECKER_TOOL_ID = "hand_checker_tool";
    public static final String REPEATER_TOOL_ID = "repeater_tool";
    public static final String EXIT_GAME_TOOL_ID = "exit_game_tool";
    public static final String MINUS_HEALTH_TOOL_ID = "minus_health_tool";

    public static final Supplier<Item> SMILE_EMOJI_ITEM;
    public static final Supplier<Item> BRAIN_ITEM;
    public static final Supplier<Item> POTION_THROWING_GLOVE_ITEM;
    public static final Supplier<Item> ZAKO_SPAWN_EGG_ITEM;
    public static final Supplier<Item> ZAKO_ITEM;
    public static final Supplier<Item> COOKED_ZAKO_ITEM;
    public static final Supplier<Item> BILI_COIN_ITEM;
    public static final Supplier<Item> COOKED_BILI_COIN_ITEM;
    public static final Supplier<Item> CHARRED_ZAKO_ITEM;
    public static final Supplier<Item> GAME_CHECKER_TOOL_ITEM;
    public static final Supplier<Item> FRAME_TOOL_ITEM;
    public static final Supplier<Item> MOUSE_CHECKER_TOOL_ITEM;
    public static final Supplier<Item> HAND_CHECKER_TOOL_ITEM;
    public static final Supplier<Item> REPEATER_TOOL_ITEM;
    public static final Supplier<Item> EXIT_GAME_TOOL_ITEM;
    public static final Supplier<Item> MINUS_HEALTH_TOOL_ITEM;

    static {
        SMILE_EMOJI_ITEM = ITEMS.register(SMILE_EMOJI_ID, () -> new SmileEmojiItem(new Item.Properties().stacksTo(1)));
        BRAIN_ITEM = ITEMS.registerSimpleItem(BRAIN_ID);
        POTION_THROWING_GLOVE_ITEM = ITEMS.register(POTION_THROWING_GLOVE_ID, () -> new PotionThrowingGloveItem(new Item.Properties().stacksTo(1)));
        ZAKO_ITEM = ITEMS.register(ZAKO_ID, () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.4F).build())));
        COOKED_ZAKO_ITEM = ITEMS.register(COOKED_ZAKO_ID, () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(6F).build())));
        ZAKO_SPAWN_EGG_ITEM = ITEMS.register(ZAKO_SPAWN_EGG_ID, () -> new DeferredSpawnEggItem(ModEntities.ZAKO, 0xFFFFFF, 0xFFFFFF, new Item.Properties()));
        BILI_COIN_ITEM = ITEMS.register(BILI_COIN_ID, () -> new BiliCoinItem(new Item.Properties().stacksTo(16)));
        COOKED_BILI_COIN_ITEM = ITEMS.register(COOKED_BILI_COIN_ID, () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(6)
                .saturationModifier(9.6F)
                .alwaysEdible()
                .build())));
        CHARRED_ZAKO_ITEM = ITEMS.register(CHARRED_ZAKO_ID, () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(6)
                .saturationModifier(9.6F)
                .alwaysEdible()
                .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600), 1.0F)
                .build())));
        GAME_CHECKER_TOOL_ITEM = ITEMS.register(GAME_CHECKER_TOOL_ID, () -> new GameCheckerToolItem(new Item.Properties().stacksTo(1)));
        FRAME_TOOL_ITEM = ITEMS.register(FRAME_TOOL_ID, () -> new FrameToolItem(new Item.Properties().stacksTo(1)));
        MOUSE_CHECKER_TOOL_ITEM = ITEMS.register(MOUSE_CHECKER_TOOL_ID, () -> new MouseCheckerToolItem(new Item.Properties().stacksTo(1)));
        HAND_CHECKER_TOOL_ITEM = ITEMS.register(HAND_CHECKER_TOOL_ID, () -> new HandCheckerToolItem(new Item.Properties().stacksTo(1)));
        REPEATER_TOOL_ITEM = ITEMS.register(REPEATER_TOOL_ID, () -> new RepeaterToolItem(new Item.Properties().stacksTo(1)));
        EXIT_GAME_TOOL_ITEM = ITEMS.register(EXIT_GAME_TOOL_ID, () -> new ExitGameToolItem(new Item.Properties().stacksTo(1)));
        MINUS_HEALTH_TOOL_ITEM = ITEMS.register(MINUS_HEALTH_TOOL_ID, () -> new MinusHealthToolItem(new Item.Properties().stacksTo(1)));
    }
}
