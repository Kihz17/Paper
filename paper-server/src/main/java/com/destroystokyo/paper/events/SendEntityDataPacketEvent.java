package com.destroystokyo.paper.events;

import net.minecraft.network.syncher.SynchedEntityData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class SendEntityDataPacketEvent extends PlayerEvent implements Cancellable {
    private final List<SynchedEntityData.DataValue<?>> dataItems;
    private final Entity entity;
    private boolean cancelled;

    private static final HandlerList handlers = new HandlerList();

    public SendEntityDataPacketEvent(@NotNull Player who, Entity entity, List<SynchedEntityData.DataValue<?>> dataItems) {
        super(who);
        this.entity = entity;
        this.dataItems = dataItems;
    }

    public List<SynchedEntityData.DataValue<?>> getDataItems() {
        return dataItems;
    }

    public Entity getEntity() {
        return entity;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
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
