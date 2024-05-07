package dev.upcraft.examplemod.config;

import com.teamresourceful.resourcefulconfig.common.annotations.Config;
import com.teamresourceful.resourcefulconfig.web.annotations.Link;
import com.teamresourceful.resourcefulconfig.web.annotations.WebInfo;
import dev.upcraft.examplemod.ExampleMod;

@WebInfo(
        title = "Example Mod",
        description = "This is an example mod.",
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
                        value = "https://github.com/Up-Mods/",
                        icon = "github",
                        title = "Github")
        }
)
@Config(ExampleMod.MODID)
public final class ExampleModConfig {
}
