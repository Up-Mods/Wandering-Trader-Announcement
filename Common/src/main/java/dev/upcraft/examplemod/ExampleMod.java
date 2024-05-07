package dev.upcraft.examplemod;

import com.teamresourceful.resourcefulconfig.common.config.Configurator;
import dev.upcraft.examplemod.config.ExampleModConfig;

public class ExampleMod {

    public static final String MODID = "examplemod";

    public static final Configurator CONFIGURATOR = new Configurator();

    public static void init() {
        CONFIGURATOR.registerConfig(ExampleModConfig.class);
    }
}
