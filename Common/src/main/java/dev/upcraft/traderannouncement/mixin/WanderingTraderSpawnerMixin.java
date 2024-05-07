package dev.upcraft.traderannouncement.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import dev.upcraft.traderannouncement.config.TraderAnnouncementConfig;
import net.minecraft.network.chat.Component;
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
        var players = TraderAnnouncementConfig.announceGlobally ? level.players() : level.getPlayers(serverPlayer -> serverPlayer.distanceToSqr(trader.getX(), trader.getY(), trader.getZ()) < TraderAnnouncementConfig.announceDistance * TraderAnnouncementConfig.announceDistance);
        players.forEach(serverPlayer -> serverPlayer.sendSystemMessage(Component.translatable("message.trader_announcement.spawned"), true));
        if (TraderAnnouncementConfig.addGlowingEffect) {
            trader.addEffect(new MobEffectInstance(MobEffects.GLOWING, 30 * 20, 0));
        }
    }
}
