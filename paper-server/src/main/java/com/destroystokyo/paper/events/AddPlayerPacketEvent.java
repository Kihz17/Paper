package com.destroystokyo.paper.events;

import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class AddPlayerPacketEvent extends PlayerEvent implements Cancellable {
    private ClientboundAddEntityPacket packet;
    private boolean cancelled;

    private static final HandlerList handlers = new HandlerList();

    public AddPlayerPacketEvent(@NotNull Player who, ClientboundAddEntityPacket packet) {
        super(who);
        this.packet = packet;
    }

    public ClientboundAddEntityPacket getPacket() {
        return packet;
    }

    public void setPacket(ClientboundAddEntityPacket packet) {
        this.packet = packet;
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
