package dev.upcraft.traderannouncement.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.upcraft.traderannouncement.WanderingTraderAnnouncement;
import dev.upcraft.traderannouncement.config.WanderingTraderAnnouncementConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.npc.WanderingTraderSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WanderingTraderSpawner.class)
public class WanderingTraderSpawnerMixin {

    @Inject(method = "spawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/ServerLevelData;setWanderingTraderId(Ljava/util/UUID;)V", shift = At.Shift.AFTER))
    private void announceWanderingTrader(ServerLevel level, CallbackInfoReturnable<Boolean> cir, @Local WanderingTrader trader) {
        var players = WanderingTraderAnnouncementConfig.announceGlobally ? level.players() : level.getPlayers(serverPlayer -> serverPlayer.distanceToSqr(trader.getX(), trader.getY(), trader.getZ()) < WanderingTraderAnnouncementConfig.announcementRange * WanderingTraderAnnouncementConfig.announcementRange);

        players.forEach(serverPlayer -> serverPlayer.sendSystemMessage(Component.translatable(WanderingTraderAnnouncementConfig.announceGlobally ? "message.trader_announcement.spawned_global" : "message.trader_announcement.spawned_local").withStyle(ChatFormatting.BLUE, ChatFormatting.ITALIC), true));

        if (WanderingTraderAnnouncementConfig.addGlowingEffect) {
            trader.addEffect(new MobEffectInstance(MobEffects.GLOWING, 30 * 20, 0));
        }

        if (WanderingTraderAnnouncementConfig.announcementSoundEnabled && WanderingTraderAnnouncementConfig.announcementSound != null) {
            ResourceLocation soundId = ResourceLocation.tryParse(WanderingTraderAnnouncementConfig.announcementSound);
            if(soundId != null) {
                var value = BuiltInRegistries.SOUND_EVENT.getHolder(ResourceKey.create(Registries.SOUND_EVENT, soundId)).map(ref -> ref.isBound() ? ref.value() : null);
                // play sound for each player
                value.ifPresent(soundEvent -> players.forEach(serverPlayer -> level.playSound(null, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), soundEvent, trader.getSoundSource(), 1.0F, 1.0F)));
            }
            else {
                WanderingTraderAnnouncement.LOGGER.warn("Invalid sound event for trader announcement: {}", WanderingTraderAnnouncementConfig.announcementSound);
            }

        }
    }
}
