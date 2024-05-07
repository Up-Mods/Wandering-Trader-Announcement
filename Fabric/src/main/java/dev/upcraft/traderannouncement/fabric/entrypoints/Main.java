package dev.upcraft.traderannouncement.fabric.entrypoints;

import dev.upcraft.traderannouncement.TraderAnnouncement;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {

    @Override
    public void onInitialize() {
        TraderAnnouncement.init();
    }
}
