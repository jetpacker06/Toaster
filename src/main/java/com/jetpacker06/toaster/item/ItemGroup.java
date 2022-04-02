package com.jetpacker06.toaster.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ItemGroup {
    public static final CreativeModeTab TOASTER = new CreativeModeTab("toaster") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TOAST.get());
        }
    };
}