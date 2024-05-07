package dev.upcraft.traderannouncement.neoforge.entrypoints;

import dev.upcraft.traderannouncement.TraderAnnouncement;
import net.minecraftforge.fml.common.Mod;

@Mod(TraderAnnouncement.MODID)
public class Main {

    public Main() {
        TraderAnnouncement.init();
    }
}
