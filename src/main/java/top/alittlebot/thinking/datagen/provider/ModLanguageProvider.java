package top.alittlebot.thinking.datagen.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.alittlebot.thinking.Thinking;
import top.alittlebot.thinking.item.ModItems;

public class ModLanguageProvider {

    public static class EnglishLanguageProvider extends LanguageProvider {
        public EnglishLanguageProvider(PackOutput gen) {
            super(gen, Thinking.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            this.add("enchantment.thinking.automatic", "Automatic");
            this.add("enchantment.thinking.damaged", "Damaged");
            this.add("enchantment.thinking.raining_knives", "Raining Knives");
            this.add(ModItems.SMILE_EMOJI_ITEM.get(), "Smile Mask");
        }
    }


    public static class ChineseLanguageProvider extends LanguageProvider {
        public ChineseLanguageProvider(PackOutput gen) {
            super(gen, Thinking.MODID, "zh_cn");
        }

        @Override
        protected void addTranslations() {
            this.add("enchantment.thinking.automatic", "自动化");
            this.add("enchantment.thinking.damaged", "损坏");
            this.add("enchantment.thinking.raining_knives", "天上下刀子");
            this.add(ModItems.SMILE_EMOJI_ITEM.get(), "笑脸面具");
        }
    }
    /*
    public String enchantment_add(ResourceKey<Enchantment> key) {
        String registry = key.registry().getPath();
        ResourceLocation location = key.location();
        return registry + "." + location.getNamespace() + "." + location.getPath();
    }
    */
}
