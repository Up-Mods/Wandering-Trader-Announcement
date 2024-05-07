package dev.upcraft.traderannouncement.config;

import com.teamresourceful.resourcefulconfig.common.annotations.Config;
import com.teamresourceful.resourcefulconfig.common.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.common.config.EntryType;
import com.teamresourceful.resourcefulconfig.web.annotations.Link;
import com.teamresourceful.resourcefulconfig.web.annotations.WebInfo;
import dev.upcraft.traderannouncement.WanderingTraderAnnouncement;

@WebInfo(
        title = "Trader Announcement",
        description = "Announce when a wandering trader spawns",
        links = {
                @Link(
                        value = "https://modrinth.com/mod/sxx4Yagq",
                        icon = "modrinth",
                        title = "Modrinth"
                ),
                @Link(
                        value = "https://curseforge.com/projects/1014823",
                        icon = "curseforge",
                        title = "Curseforge"
                ),
                @Link(
                        value = "https://github.com/Up-Mods/Wandering-Trader-Announcement",
                        icon = "github",
                        title = "Github")
        }
)
@Config(WanderingTraderAnnouncement.MODID)
public final class WanderingTraderAnnouncementConfig {

    @ConfigEntry(id = "announce_globally", type = EntryType.BOOLEAN, translation = "config.trader_announcement.announce_globally")
    public static boolean announceGlobally = false;

    @ConfigEntry(id = "announcement_range", type = EntryType.INTEGER, translation = "config.trader_announcement.announcement_range")
    public static int announcementRange = 72;

    @ConfigEntry(id = "add_glowing_effect", type = EntryType.BOOLEAN, translation = "config.trader_announcement.add_glowing_effect")
    public static boolean addGlowingEffect = true;

    @ConfigEntry(id = "announcement_sound_enabled", type = EntryType.BOOLEAN, translation = "config.trader_announcement.announcement_sound_enabled")
    public static boolean announcementSoundEnabled = true;

    @ConfigEntry(id = "announcement_sound", type = EntryType.STRING, translation = "config.trader_announcement.announcement_sound")
    public static String announcementSound = "minecraft:entity.player.levelup";
}
