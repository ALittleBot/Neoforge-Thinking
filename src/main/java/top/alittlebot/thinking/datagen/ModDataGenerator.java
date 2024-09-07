package top.alittlebot.thinking.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import top.alittlebot.thinking.Thinking;
import top.alittlebot.thinking.datagen.provider.ModDatapackBuiltinEntriesProvider;
import top.alittlebot.thinking.datagen.provider.ModItemModelProvider;
import top.alittlebot.thinking.datagen.provider.ModLanguageProvider;
import top.alittlebot.thinking.datagen.provider.ModSoundDefinitionsProvider;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Thinking.MODID)
public class ModDataGenerator {
    // 订阅GatherDataEvent事件，当数据收集事件触发时执行该方法
    @SubscribeEvent
    public static void register(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // 为数据生成器添加一个自定义的数据包内置条目提供者
        generator.addProvider(event.includeServer(), new ModDatapackBuiltinEntriesProvider(output, lookupProvider));
        generator.addProvider(event.includeClient(), new ModLanguageProvider.EnglishLanguageProvider(output));
        generator.addProvider(event.includeClient(), new ModLanguageProvider.ChineseLanguageProvider(output));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModSoundDefinitionsProvider(output, event.getExistingFileHelper()));
    }
}
