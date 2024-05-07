package dev.upcraft.traderannouncement.quilt.entrypoints;

import dev.upcraft.traderannouncement.WanderingTraderAnnouncement;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class Main implements ModInitializer {

    @Override
    public void onInitialize(ModContainer mod) {
        WanderingTraderAnnouncement.init();
    }
}
