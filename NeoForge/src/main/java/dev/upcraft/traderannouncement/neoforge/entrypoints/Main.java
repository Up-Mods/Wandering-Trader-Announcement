package dev.upcraft.traderannouncement.neoforge.entrypoints;

import dev.upcraft.traderannouncement.WanderingTraderAnnouncement;
import net.minecraftforge.fml.common.Mod;

@Mod(WanderingTraderAnnouncement.MODID)
public class Main {

    public Main() {
        WanderingTraderAnnouncement.init();
    }
}
