package com.jetpacker06.toaster.block.entity;

import com.jetpacker06.toaster.Toaster;
import com.jetpacker06.toaster.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Toaster.MOD_ID);


    public static final RegistryObject<BlockEntityType<ToasterBlockEntity>> TOASTER = BLOCK_ENTITIES.register("toaster_block_entity", () -> BlockEntityType.Builder.of(ToasterBlockEntity::new, ModBlocks.TOASTER.get()).build(null));
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------