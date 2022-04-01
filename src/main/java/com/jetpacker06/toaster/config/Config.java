package com.jetpacker06.toaster.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static void register() {
        registerClientConfigs();
        registerServerConfigs();
        registerCommonConfigs();
    }

    private static void registerCommonConfigs() {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    }

    private static void registerServerConfigs() {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
    }

    private static void registerClientConfigs() {
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
    }
}
