package dev.upcraft.traderannouncement.neoforge.entrypoints;

import com.teamresourceful.resourcefulconfig.client.ConfigScreen;
import dev.upcraft.traderannouncement.TraderAnnouncement;
import dev.upcraft.traderannouncement.config.TraderAnnouncementConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TraderAnnouncement.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Client {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory((minecraft, parent) -> new ConfigScreen(parent, null, TraderAnnouncement.CONFIGURATOR.getConfig(TraderAnnouncementConfig.class)))));
    }
}
