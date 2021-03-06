package com.jetpacker06.toaster;

import com.jetpacker06.toaster.block.ModBlocks;
import com.jetpacker06.toaster.block.entity.ModBlockEntities;
import com.jetpacker06.toaster.fluid.ModFluids;
import com.jetpacker06.toaster.item.ModItems;
import com.jetpacker06.toaster.recipe.ModRecipes;
import com.jetpacker06.toaster.screen.ModMenuTypes;
import com.jetpacker06.toaster.screen.ToasterScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Toaster.MOD_ID)
public class Toaster {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "toaster";

    public Toaster() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModFluids.register(eventBus);
        ModRecipes.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModBlockEntities.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TOASTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.BUTTER_FLUID.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.BUTTER_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.BUTTER_FLOWING.get(), RenderType.translucent());
        MenuScreens.register(ModMenuTypes.TOASTER_MENU.get(), ToasterScreen::new);
    }



    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

    }
}
