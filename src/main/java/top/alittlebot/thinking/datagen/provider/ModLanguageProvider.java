package top.alittlebot.thinking.datagen.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.alittlebot.thinking.Thinking;

public class ModLanguageProvider {

    public static class EnglishLanguageProvider extends LanguageProvider {
        public EnglishLanguageProvider(PackOutput gen) {
            super(gen, Thinking.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            this.add("enchantment.thinking.automatic", "Automatic");
        }
    }


    public static class ChineseLanguageProvider extends LanguageProvider {
        public ChineseLanguageProvider(PackOutput gen) {
            super(gen, Thinking.MODID, "zh_cn");
        }

        @Override
        protected void addTranslations() {
            this.add("enchantment.thinking.automatic", "自动化");
        }
    }
}
