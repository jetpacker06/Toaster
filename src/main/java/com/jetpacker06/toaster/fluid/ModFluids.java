package com.jetpacker06.toaster.fluid;

import com.jetpacker06.toaster.Toaster;
import com.jetpacker06.toaster.block.ModBlocks;
import com.jetpacker06.toaster.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.jetpacker06.toaster.Toaster.MOD_ID;

public class ModFluids {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, MOD_ID);


    //BUTTER FLUID
    public static final RegistryObject<FlowingFluid> BUTTER_FLUID
            = FLUIDS.register("butter_fluid", () -> new ForgeFlowingFluid.Source(ModFluids.BUTTER_PROPERTIES));

    public static final RegistryObject<FlowingFluid> BUTTER_FLOWING
            = FLUIDS.register("butter_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.BUTTER_PROPERTIES));

    public static final ForgeFlowingFluid.Properties BUTTER_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> BUTTER_FLUID.get(), () -> BUTTER_FLOWING.get(),
            FluidAttributes.Water.builder(WATER_STILL_RL, WATER_FLOWING_RL)
                    .temperature(300)
                    .sound(SoundEvents.COW_MILK)
                    .overlay(WATER_OVERLAY_RL)
                    .color(0xbffcba03)
                    .density(2)
                    .luminosity(2)
                    .viscosity(5)
                    )
                    .slopeFindDistance(2)
                    .levelDecreasePerBlock(2)
                    .block(() -> ModFluids.BUTTER_BLOCK.get())
                    .bucket(() -> ModItems.BUTTER_BUCKET.get());
    public static final RegistryObject<LiquidBlock> BUTTER_BLOCK = ModBlocks.BLOCKS.register("butter",
            () -> new LiquidBlock(() -> ModFluids.BUTTER_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER)
                    .noCollission()
                    .strength(100f)
                    .noDrops()
            ));

    //register method
    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
