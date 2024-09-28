package top.alittlebot.thinking.ui;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.alittlebot.thinking.Thinking;
import top.alittlebot.thinking.item.ModItems;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Thinking.MODID);
    public static final String MOD_TAB_ID = "item_group." + Thinking.MODID + ".name";
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOD_TAB;

    static {
        MOD_TAB = TABS.register(Thinking.MODID, ()-> CreativeModeTab.builder()
                .title(Component.translatable(MOD_TAB_ID))
                .icon(() -> new ItemStack(ModItems.BRAIN_ITEM.get()))
                .displayItems((parameters, output) -> {
                    output.accept(ModItems.SMILE_EMOJI_ITEM.get());
                    output.accept(ModItems.BRAIN_ITEM.get());
                    output.accept(ModItems.POTION_THROWING_GLOVE_ITEM.get());
                    output.accept(ModItems.ZAKO_SPAWN_EGG_ITEM.get());
                    output.accept(ModItems.ZAKO_ITEM.get());
                    output.accept(ModItems.COOKED_ZAKO_ITEM.get());
                    output.accept(ModItems.CHARRED_ZAKO_ITEM.get());
                    output.accept(ModItems.BILI_COIN_ITEM.get());
                    output.accept(ModItems.COOKED_BILI_COIN_ITEM.get());
                }).build());
    }
}
