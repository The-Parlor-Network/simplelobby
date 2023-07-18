package dev.clxud.simplelobby;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.proxy.ProxyServer;
import dev.clxud.simplelobby.commands.HubCommand;
import org.slf4j.Logger;

@com.velocitypowered.api.plugin.Plugin(
        id = "simplelobby",
        name = "simplelobby-velocity",
        version = BuildConstants.VERSION
)
public class Plugin {

    @Inject
    private Logger logger;
    private final ProxyServer proxy;

    @Inject
    public Plugin(ProxyServer proxy) {
        this.proxy = proxy;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        proxy.getCommandManager().register("hub", new HubCommand(proxy), "lobby", "l");
        logger.info("SimpleLobby has been enabled!");
        
    }



}
