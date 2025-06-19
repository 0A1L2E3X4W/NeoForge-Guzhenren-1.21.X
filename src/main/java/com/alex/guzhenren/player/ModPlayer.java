package com.alex.guzhenren.player;

import com.alex.guzhenren.Guzhenren;
import com.alex.guzhenren.utils.enums.ModTalent;
import com.mojang.serialization.Codec;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModPlayer {

    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Guzhenren.MOD_ID);

    public static final Supplier<AttachmentType<ModTalent>> PLAYER_TALENT = ATTACHMENT_TYPES.register(
        "player.talent", () -> AttachmentType.builder(() -> ModTalent.NULL)
                    .serialize(Codec.STRING.xmap(ModTalent::valueOf, ModTalent::name)).build());
}
