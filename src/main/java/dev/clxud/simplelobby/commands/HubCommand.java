package dev.clxud.simplelobby.commands;

import com.velocitypowered.api.command.RawCommand;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import java.util.Optional;

public class HubCommand implements SimpleCommand {

    private final ProxyServer server;

    public HubCommand(ProxyServer server) {
        this.server = server;
    }

    @Override
    public void execute(final Invocation invocation) {
        Player player = (Player) invocation.source();
        Optional<RegisteredServer> lobby = server.getServer("lobby");
        if (lobby.isEmpty()) {
            player.sendMessage(Component.text("The server you are trying to connect to is offline.", NamedTextColor.RED));
            return;
        }
        player.sendMessage(Component.text("Teleporting to hub...", NamedTextColor.GRAY));
        player.createConnectionRequest(lobby.get()).fireAndForget();

    }
}
