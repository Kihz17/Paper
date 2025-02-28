package com.destroystokyo.paper.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerTrackEntityEvent extends PlayerEvent {
    private final TrackType type;
    private final Entity tracked;

    private static final HandlerList handlers = new HandlerList();

    public PlayerTrackEntityEvent(@NotNull Player who, @NotNull Entity tracked, TrackType type) {
        super(who);
        this.tracked = tracked;
        this.type = type;
    }

    public Entity getTracked() {
        return tracked;
    }

    public TrackType getTrackType() {
        return type;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public enum TrackType {
        START,
        STOP
    }
}
