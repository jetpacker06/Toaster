package com.jetpacker06.toaster.item;

import com.jetpacker06.toaster.Toaster;
import com.jetpacker06.toaster.fluid.ModFluids;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Toaster.MOD_ID);
//TOAST
    public static final RegistryObject<Item> TOAST = ITEMS.register("toast", () -> new Item(
        new Item.Properties()
            .tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(8).saturationMod(8).build())
            .tab(ItemGroup.TOASTER)
));
//BREAD SLICE
    public static final RegistryObject<Item> BREAD_SLICE = ITEMS.register("bread_slice", () -> new Item(
        new Item.Properties()
            .tab(CreativeModeTab.TAB_FOOD)
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(8).build())
            .tab(ItemGroup.TOASTER)
));
//CARAMEL CUBE
    public static final RegistryObject<Item> CARAMEL_CUBE = ITEMS.register("caramel_cube", () -> new Item(
        new Item.Properties()
                .tab(CreativeModeTab.TAB_FOOD)
                .food(new FoodProperties.Builder().nutrition(2).saturationMod(8).build())
                .tab(ItemGroup.TOASTER)
));
//BUTTER BUCKET
    public static final RegistryObject<Item> BUTTER_BUCKET = ITEMS.register("butter_bucket", () -> new BucketItem(ModFluids.BUTTER_FLUID,
        new Item.Properties()
                .tab(CreativeModeTab.TAB_FOOD)
                .food(new FoodProperties.Builder().nutrition(2).saturationMod(8).build())
                .tab(ItemGroup.TOASTER)
));
//BAKED CARAMEL APPLE
    public static final RegistryObject<Item> BAKED_CARAMEL_APPLE = ITEMS.register("baked_caramel_apple", () -> new Item(
        new Item.Properties()
                .tab(CreativeModeTab.TAB_FOOD)
                .food(new FoodProperties.Builder().nutrition(2).saturationMod(8).build())
                .tab(ItemGroup.TOASTER)
));
//CARAMEL APPLE
    public static final RegistryObject<Item> CARAMEL_APPLE = ITEMS.register("caramel_apple", () -> new Item(
        new Item.Properties()
                .tab(CreativeModeTab.TAB_FOOD)
                .food(new FoodProperties.Builder().nutrition(2).saturationMod(8).build())
                .tab(ItemGroup.TOASTER)
    ));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}