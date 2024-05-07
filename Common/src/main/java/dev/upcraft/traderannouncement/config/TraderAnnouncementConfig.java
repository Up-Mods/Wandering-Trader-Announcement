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
                        value = "https://modrinth.com/mod/0",
                        icon = "modrinth",
                        title = "Modrinth"
                ),
                @Link(
                        value = "https://curseforge.com/projects/0",
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

    @ConfigEntry(id = "announce_radius", type = EntryType.INTEGER, translation = "config.trader_announcement.announce_radius")
    public static int announceRadius = 72;
}
