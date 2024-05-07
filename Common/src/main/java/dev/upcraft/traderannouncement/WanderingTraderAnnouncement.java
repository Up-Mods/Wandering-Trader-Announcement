package dev.upcraft.traderannouncement;

import com.mojang.logging.LogUtils;
import com.teamresourceful.resourcefulconfig.common.config.Configurator;
import dev.upcraft.traderannouncement.config.WanderingTraderAnnouncementConfig;
import org.slf4j.Logger;

public class WanderingTraderAnnouncement {

    public static final String MODID = "trader_announcement";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final Configurator CONFIGURATOR = new Configurator();

    public static void init() {
        CONFIGURATOR.registerConfig(WanderingTraderAnnouncementConfig.class);
    }
}
