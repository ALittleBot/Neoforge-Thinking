package top.alittlebot.thinking.datagen.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import top.alittlebot.thinking.Thinking;
import top.alittlebot.thinking.entity.ModEntities;
import top.alittlebot.thinking.item.ModItems;
import top.alittlebot.thinking.sound.ModSounds;
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

            this.add("item.thinking.game_checker_tool.title", "Test result");
            this.add("item.thinking.game_checker_tool.result", "The game is running (●'◡'●)");
            this.add("item.thinking.frame_tool.enabled", "The Frame tool is enabled ヾ(≧▽≦*)o");
            this.add("item.thinking.frame_tool.disabled", "The Frame tool is disabled w(ﾟДﾟ)w");
            this.add("item.thinking.mouse_checker_tool.checking", "Checking, please wait a few seconds…");
            this.add("item.thinking.hand_checker_tool.result", "Congratulations, the right mouse button is available ヾ(≧▽≦*)o");
            this.add("item.thinking.hand_checker_tool.empty", "Empty");
            this.add("item.thinking.hand_checker_tool.main_hand", "Items held in the main hand: ");
            this.add("item.thinking.hand_checker_tool.offhand", "Off-hand holding items: ");

            this.add(ModItems.SMILE_EMOJI_ITEM.get(), "Smile Mask");
            this.add(ModItems.BRAIN_ITEM.get(), "Brain");
            this.add(ModItems.POTION_THROWING_GLOVE_ITEM.get(), "Potion Throwing Glove");
            this.add(ModItems.ZAKO_ITEM.get(), "Raw Zako");
            this.add(ModItems.COOKED_ZAKO_ITEM.get(), "Cooked Zako");
            this.add(ModItems.CHARRED_ZAKO_ITEM.get(), "★ Zako | Scorched (Factory New)");
            this.add(ModItems.BILI_COIN_ITEM.get(), "Bili Coin");
            this.add(ModItems.COOKED_BILI_COIN_ITEM.get(), "Cooked Bili Coin");
            this.add(ModItems.GAME_CHECKER_TOOL_ITEM.get(), "Game Checker Tool");
            this.add(ModItems.FRAME_TOOL_ITEM.get(), "Frame Tool");
            this.add(ModItems.MOUSE_CHECKER_TOOL_ITEM.get(), "Mouse Checker Tool");
            this.add(ModItems.HAND_CHECKER_TOOL_ITEM.get(), "Two-handed Checker Tool");

            this.add(ModEntities.ZAKO.get(), "Zako");
            this.add(ModItems.ZAKO_SPAWN_EGG_ITEM.get(), "Zako Spawn Egg");

            this.add(ModSounds.BILI_COIN_THROW_TRANSLATE_KEY, "Bili Coin flies");

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
            this.add("enchantment.thinking.raining_knives", "§c天上下刀子");  // 不知道怎么设置诅咒, 凑合一下 ヾ(•ω•`)o

            this.add("item.thinking.game_checker_tool.title", "检测结果");
            this.add("item.thinking.game_checker_tool.result", "游戏正在运行中 (●'◡'●)");
            this.add("item.thinking.frame_tool.enabled", "画框工具已启用 ヾ(≧▽≦*)o");
            this.add("item.thinking.frame_tool.disabled", "画框工具已禁用 w(ﾟДﾟ)w");
            this.add("item.thinking.mouse_checker_tool.checking", "正在检测……");
            this.add("item.thinking.mouse_checker_tool.result", "恭喜您, 鼠标右键可用 ヾ(≧▽≦*)o (检测结果仅供参考, 请以实际为准)");
            this.add("item.thinking.hand_checker_tool.empty", "空");
            this.add("item.thinking.hand_checker_tool.main_hand", "主手持有物品: ");
            this.add("item.thinking.hand_checker_tool.offhand", "副手持有物品: ");

            this.add(ModItems.SMILE_EMOJI_ITEM.get(), "笑脸面具");
            this.add(ModItems.BRAIN_ITEM.get(), "大脑");
            this.add(ModItems.POTION_THROWING_GLOVE_ITEM.get(), "药水投掷手套");
            this.add(ModItems.ZAKO_ITEM.get(), "生杂鱼");
            this.add(ModItems.COOKED_ZAKO_ITEM.get(), "熟杂鱼");
            this.add(ModItems.CHARRED_ZAKO_ITEM.get(), "杂鱼（★） | 枯焦之色 (崭新出厂)");
            this.add(ModItems.BILI_COIN_ITEM.get(), "硬币");
            this.add(ModItems.COOKED_BILI_COIN_ITEM.get(), "熟硬币");
            this.add(ModItems.GAME_CHECKER_TOOL_ITEM.get(), "游戏是否运行检测工具");
            this.add(ModItems.FRAME_TOOL_ITEM.get(), "画框工具");
            this.add(ModItems.MOUSE_CHECKER_TOOL_ITEM.get(), "鼠标检测工具");
            this.add(ModItems.HAND_CHECKER_TOOL_ITEM.get(), "检测双手是否持有物品工具");

            this.add(ModEntities.ZAKO.get(), "杂鱼");
            this.add(ModItems.ZAKO_SPAWN_EGG_ITEM.get(), "杂鱼刷怪蛋");

            this.add(ModSounds.BILI_COIN_THROW_TRANSLATE_KEY, "硬币：飞出");

            this.add(ModCreativeTab.MOD_TAB_ID, "别吵, 我在思考");
        }
    }
}
