package dev.upcraft.traderannouncement.neoforge.entrypoints;

import com.teamresourceful.resourcefulconfig.client.ConfigScreen;
import dev.upcraft.traderannouncement.WanderingTraderAnnouncement;
import dev.upcraft.traderannouncement.config.WanderingTraderAnnouncementConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = WanderingTraderAnnouncement.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Client {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory((minecraft, parent) -> new ConfigScreen(parent, null, WanderingTraderAnnouncement.CONFIGURATOR.getConfig(WanderingTraderAnnouncementConfig.class)))));
    }
}
