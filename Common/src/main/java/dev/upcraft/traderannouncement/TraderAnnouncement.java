package dev.upcraft.traderannouncement;

import com.teamresourceful.resourcefulconfig.common.config.Configurator;
import dev.upcraft.traderannouncement.config.TraderAnnouncementConfig;

public class TraderAnnouncement {

    public static final String MODID = "trader_announcement";

    public static final Configurator CONFIGURATOR = new Configurator();

    public static void init() {
        CONFIGURATOR.registerConfig(TraderAnnouncementConfig.class);
    }
}
