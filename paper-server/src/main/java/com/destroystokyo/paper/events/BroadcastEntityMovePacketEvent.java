package com.destroystokyo.paper.events;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.network.protocol.game.ClientboundTeleportEntityPacket;
import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;

public class BroadcastEntityMovePacketEvent extends EntityEvent {
    private final Packet<?> packet;
    private final PacketType packetType;

    private static final HandlerList handlers = new HandlerList();

    public BroadcastEntityMovePacketEvent(@NotNull Entity what, Packet<?> packet) {
        super(what);
        this.packet = packet;

        if(packet instanceof ClientboundMoveEntityPacket.Pos) {
            this.packetType = PacketType.POS;
        } else if(packet instanceof ClientboundMoveEntityPacket.Rot) {
            this.packetType = PacketType.ROT;
        } else if(packet instanceof ClientboundMoveEntityPacket.PosRot) {
            this.packetType = PacketType.POS_ROT;
        } else if(packet instanceof ClientboundTeleportEntityPacket) {
            this.packetType = PacketType.TELEPORT;
        } else {
            this.packetType = PacketType.NONE;
        }
    }

    public Packet<?> getPacket() {
        return packet;
    }

    public ClientboundMoveEntityPacket.Pos getAsPosPacket() {
        return (ClientboundMoveEntityPacket.Pos) packet;
    }

    public ClientboundMoveEntityPacket.Rot getAsRotPacket() {
        return (ClientboundMoveEntityPacket.Rot) packet;
    }

    public ClientboundMoveEntityPacket.PosRot getAsPosRotPacket() {
        return (ClientboundMoveEntityPacket.PosRot) packet;
    }

    public ClientboundTeleportEntityPacket getAsTeleportPacket() {
        return (ClientboundTeleportEntityPacket) packet;
    }

    public PacketType getPacketType() {
        return packetType;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public enum PacketType {
        NONE,
        POS,
        ROT,
        POS_ROT,
        TELEPORT
    }
}
