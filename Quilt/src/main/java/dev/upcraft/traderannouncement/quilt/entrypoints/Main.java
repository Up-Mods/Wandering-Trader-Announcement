package dev.upcraft.traderannouncement.quilt.entrypoints;

import dev.upcraft.traderannouncement.TraderAnnouncement;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class Main implements ModInitializer {

    @Override
    public void onInitialize(ModContainer mod) {
        TraderAnnouncement.init();
    }
}
