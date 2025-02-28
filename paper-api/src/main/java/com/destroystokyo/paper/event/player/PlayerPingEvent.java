package com.destroystokyo.paper.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerPingEvent extends PlayerEvent {
    private final int latency;

    private static final HandlerList handlers = new HandlerList();

    public PlayerPingEvent(@NotNull Player who, int latency) {
        super(who);
        this.latency = latency;
    }

    public int getLatency() {
        return latency;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
