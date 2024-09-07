package top.alittlebot.thinking.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import top.alittlebot.thinking.Thinking;
import top.alittlebot.thinking.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.BILI_COIN_ITEM.get()),
                        RecipeCategory.MISC,
                        ModItems.COOKED_BILI_COIN_ITEM.get(),
                        0.1f,
                        200
                )
                .group(Thinking.MODID)
                .unlockedBy(getHasName(ModItems.BILI_COIN_ITEM.get()), has(ModItems.BILI_COIN_ITEM.get()))
                .save(recipeOutput);
    }
}
