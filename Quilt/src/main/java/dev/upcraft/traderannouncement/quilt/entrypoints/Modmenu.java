package dev.upcraft.traderannouncement.quilt.entrypoints;

import com.teamresourceful.resourcefulconfig.client.ConfigScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.upcraft.traderannouncement.WanderingTraderAnnouncement;
import dev.upcraft.traderannouncement.config.WanderingTraderAnnouncementConfig;

public class Modmenu implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> new ConfigScreen(parent, null, WanderingTraderAnnouncement.CONFIGURATOR.getConfig(WanderingTraderAnnouncementConfig.class));
    }
}
