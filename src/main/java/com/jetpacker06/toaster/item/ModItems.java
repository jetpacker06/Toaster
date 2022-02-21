package com.jetpacker06.toaster.item;

import com.jetpacker06.toaster.Toaster;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Toaster.MOD_ID);
//TOAST
    public static final RegistryObject<Item> TOASTED_BREAD = ITEMS.register("toasted_bread", () -> new Item(
        new Item.Properties()
            .tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(8).saturationMod(8).build())
            ));
//BREAD SLICE
    public static final RegistryObject<Item> BREAD_SLICE = ITEMS.register("bread_slice", () -> new Item(
        new Item.Properties()
            .tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(8).build())
            ));
//CARAMEL CUBE
    public static final RegistryObject<Item> CARAMEL_CUBE = ITEMS.register("caramel_cube", () -> new Item(
        new Item.Properties()
                .tab(CreativeModeTab.TAB_FOOD)
                .food(new FoodProperties.Builder().nutrition(2).saturationMod(8).build())
            ));
//CARAMEL APPLE
    public static final RegistryObject<Item> CARAMEL_APPLE = ITEMS.register("caramel_apple", () -> new Item(
        new Item.Properties()
                .tab(CreativeModeTab.TAB_FOOD)
                .food(new FoodProperties.Builder().nutrition(2).saturationMod(8).build())
            ));
//BAKED CARAMEL APPLE
    public static final RegistryObject<Item> BAKED_CARAMEL_APPLE = ITEMS.register("baked_caramel_apple", () -> new Item(
        new Item.Properties()
                .tab(CreativeModeTab.TAB_FOOD)
                .food(new FoodProperties.Builder().nutrition(2).saturationMod(8).build())
)           );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}