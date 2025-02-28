package com.destroystokyo.paper.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerUpdateEntityLineOfSightEvent extends PlayerEvent {
    private final Entity entityInLOS;
    private final boolean isInLOS;

    private static final HandlerList handlers = new HandlerList();

    public PlayerUpdateEntityLineOfSightEvent(@NotNull Player player, @NotNull Entity entity, boolean isInLOS) {
        super(player);
        this.entityInLOS = entity;
        this.isInLOS = isInLOS;
    }

    public Entity getEntity() {
        return entityInLOS;
    }

    public boolean isInLOS() {
        return isInLOS;
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
