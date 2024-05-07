package dev.upcraft.traderannouncement.fabric.entrypoints;

import com.teamresourceful.resourcefulconfig.client.ConfigScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.upcraft.traderannouncement.TraderAnnouncement;
import dev.upcraft.traderannouncement.config.TraderAnnouncementConfig;

public class Modmenu implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> new ConfigScreen(parent, null, TraderAnnouncement.CONFIGURATOR.getConfig(TraderAnnouncementConfig.class));
    }
}
