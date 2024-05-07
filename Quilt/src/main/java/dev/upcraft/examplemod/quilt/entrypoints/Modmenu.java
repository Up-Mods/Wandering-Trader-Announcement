package dev.upcraft.examplemod.quilt.entrypoints;

import com.teamresourceful.resourcefulconfig.client.ConfigScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.upcraft.examplemod.ExampleMod;
import dev.upcraft.examplemod.config.ExampleModConfig;

public class Modmenu implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> new ConfigScreen(parent, null, ExampleMod.CONFIGURATOR.getConfig(ExampleModConfig.class));
    }
}
