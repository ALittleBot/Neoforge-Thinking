package top.alittlebot.thinking.datagen.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.alittlebot.thinking.Thinking;
import top.alittlebot.thinking.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput gen, ExistingFileHelper helper) {
        super(gen, Thinking.MODID, helper);
    }

    @Override
    protected void registerModels() {
        this.singleTexture(ModItems.BRAIN_ID, ResourceLocation.withDefaultNamespace("item/generated"), "layer0", ResourceLocation.fromNamespaceAndPath(Thinking.MODID, "item/" + ModItems.BRAIN_ID));
        this.singleTexture(ModItems.POTION_THROWING_GLOVE_ID, ResourceLocation.withDefaultNamespace("item/handheld"), "layer0", ResourceLocation.fromNamespaceAndPath(Thinking.MODID, "item/" + ModItems.POTION_THROWING_GLOVE_ID));
    }
}
