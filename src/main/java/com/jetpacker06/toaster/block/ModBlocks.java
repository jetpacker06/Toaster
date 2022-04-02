package com.jetpacker06.toaster.block;

import com.jetpacker06.toaster.Toaster;
import com.jetpacker06.toaster.block.custom.ChurnBlock;
import com.jetpacker06.toaster.block.custom.ToasterBlock;
import com.jetpacker06.toaster.item.ItemGroup;
import com.jetpacker06.toaster.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Toaster.MOD_ID);
    //begin blocks

    //Caramel Block
    public static final RegistryObject<Block> CARAMEL_BLOCK = registerBlock("caramel_block",
        () -> new SlabBlock(BlockBehaviour.Properties.of(Material.DIRT)
            .strength(0.5f)
            .sound(SoundType.HONEY_BLOCK)

            ), ItemGroup.TOASTER);
    //Toaster
    public static final RegistryObject<Block> TOASTER = registerBlock("toaster",
        () -> new ToasterBlock(BlockBehaviour.Properties.of(Material.METAL)
            .strength(6f)
            .sound(SoundType.METAL)

            ), ItemGroup.TOASTER);
    //Churn
    public static final RegistryObject<Block> CHURN = registerBlock("churn",
        () -> new ChurnBlock(BlockBehaviour.Properties.of(Material.WOOD)
            .strength(6f)

            ), ItemGroup.TOASTER);

    //end blocks
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name,
        RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
