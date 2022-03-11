package com.jetpacker06.toaster.recipe;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ToastingRecipe extends AbstractCookingRecipe {

    public ToastingRecipe(RecipeType<?> pType, ResourceLocation pId, String pGroup, Ingredient pIngredient, ItemStack pResult, float pExperience, int pCookingTime) {
        super(pType, pId, pGroup, pIngredient, pResult, pExperience, pCookingTime);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }
}
