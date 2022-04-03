package com.jetpacker06.toaster.recipe;

import com.jetpacker06.toaster.Toaster;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Toaster.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ToasterRecipe>> RECIPE_SERIALIZER = SERIALIZERS.register("toasting", () -> ToasterRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        eventBus.addGenericListener(RecipeSerializer.class, (RegistryEvent.Register<RecipeSerializer<?>> event) -> {
            ToasterRecipe.Type.INSTANCE = new ToasterRecipe.Type();
            Registry.register(Registry.RECIPE_TYPE, ToasterRecipe.Type.ID, ToasterRecipe.Type.INSTANCE);

        });
        SERIALIZERS.register(eventBus);
    }
}
