package dev.upcraft.traderannouncement.config;

import com.teamresourceful.resourcefulconfig.common.annotations.Config;
import com.teamresourceful.resourcefulconfig.common.annotations.ConfigEntry;
import com.teamresourceful.resourcefulconfig.common.config.EntryType;
import com.teamresourceful.resourcefulconfig.web.annotations.Link;
import com.teamresourceful.resourcefulconfig.web.annotations.WebInfo;
import dev.upcraft.traderannouncement.TraderAnnouncement;

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
                        value = "https://github.com/Up-Mods/Trader-Announcement",
                        icon = "github",
                        title = "Github")
        }
)
@Config(TraderAnnouncement.MODID)
public final class TraderAnnouncementConfig {

    @ConfigEntry(id = "announce_globally", type = EntryType.BOOLEAN, translation = "config.trader_announcement.announce_globally")
    public static boolean announceGlobally = false;

    @ConfigEntry(id = "announce_distance", type = EntryType.INTEGER, translation = "config.trader_announcement.announce_distance")
    public static int announceDistance = 72;

    @ConfigEntry(id = "add_glowing_effect", type = EntryType.BOOLEAN, translation = "config.trader_announcement.add_glowing_effect")
    public static boolean addGlowingEffect = true;
}
