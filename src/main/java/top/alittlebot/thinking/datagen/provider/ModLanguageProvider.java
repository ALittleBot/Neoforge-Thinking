package top.alittlebot.thinking.datagen.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.alittlebot.thinking.Thinking;
import top.alittlebot.thinking.item.ModItems;
import top.alittlebot.thinking.ui.ModCreativeTab;

public class ModLanguageProvider {

    public static class EnglishLanguageProvider extends LanguageProvider {
        public EnglishLanguageProvider(PackOutput gen) {
            super(gen, Thinking.MODID, "en_us");
        }

        @Override
        protected void addTranslations() {
            this.add("enchantment.thinking.automatic", "Automatic");
            this.add("enchantment.thinking.damaged", "Damaged");
            this.add("enchantment.thinking.raining_knives", "§cRaining Knives");

            this.add(ModItems.SMILE_EMOJI_ITEM.get(), "Smile Mask");
            this.add(ModItems.BRAIN_ITEM.get(), "Brain");

            this.add(ModCreativeTab.MOD_TAB_ID, "Thinking");
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
            this.add("enchantment.thinking.raining_knives", "§c天上下刀子");  // 不知道怎么设置诅咒, 凑活一下 ヾ(•ω•`)o

            this.add(ModItems.SMILE_EMOJI_ITEM.get(), "笑脸面具");
            this.add(ModItems.BRAIN_ITEM.get(), "大脑");

            this.add(ModCreativeTab.MOD_TAB_ID, "别吵, 我在思考");
        }
    }
}
