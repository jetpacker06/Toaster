package com.jetpacker06.toaster.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TOASTER = new CreativeModeTab("toaster") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TOASTED_BREAD.get());
        }
    };
}