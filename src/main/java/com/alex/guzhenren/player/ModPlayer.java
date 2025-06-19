package com.alex.guzhenren.player;

import com.alex.guzhenren.Guzhenren;
import com.alex.guzhenren.utils.enums.GuMasterRank;
import com.alex.guzhenren.utils.enums.GuMasterTalent;
import com.alex.guzhenren.utils.enums.ModTenExtremePhysique;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModPlayer {

    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Guzhenren.MOD_ID);

    // FLOATS
    public static final Supplier<AttachmentType<Float>> LIFESPAN = ATTACHMENT_TYPES.register("guzhenren.player.lifespan", () -> AttachmentType.builder(() -> 100f).serialize(Codec.FLOAT).build());

    // INTEGERS
    public static final Supplier<AttachmentType<Integer>> LUCK = ATTACHMENT_TYPES.register("guzhenren.player.luck", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());
    public static final Supplier<AttachmentType<Integer>> SOUL = ATTACHMENT_TYPES.register("guzhenren.player.soul", () -> AttachmentType.builder(() -> 100).serialize(Codec.INT).build());
    public static final Supplier<AttachmentType<Integer>> MORAL = ATTACHMENT_TYPES.register("guzhenren.player.moral", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());

    // BOOLEAN
    public static final Supplier<AttachmentType<Boolean>> IS_AWAKEN = ATTACHMENT_TYPES.register("guzhenren.player.is_awaken", () -> AttachmentType.builder(() -> false).serialize(Codec.BOOL).build());

    // ENUMS
    public static final Supplier<AttachmentType<GuMasterTalent>> PLAYER_TALENT = ATTACHMENT_TYPES.register(
            "guzhenren.player.talent", () -> AttachmentType.builder(() -> GuMasterTalent.NULL)
                    .serialize(Codec.STRING.xmap(GuMasterTalent::valueOf, GuMasterTalent::name)).build());

    public static final Supplier<AttachmentType<GuMasterRank>> PLAYER_RANK = ATTACHMENT_TYPES.register(
            "guzhenren.player.rank", () -> AttachmentType.builder(() -> GuMasterRank.MORTAL)
                    .serialize(Codec.STRING.xmap(GuMasterRank::valueOf, GuMasterRank::name)).build());

    public static final Supplier<AttachmentType<ModTenExtremePhysique>> PLAYER_EXTREME_PHYSIQUE = ATTACHMENT_TYPES.register(
            "guzhenren.player.extreme_physique", () -> AttachmentType.builder(() -> ModTenExtremePhysique.NULL)
                    .serialize(Codec.STRING.xmap(ModTenExtremePhysique::valueOf, ModTenExtremePhysique::name)).build());

    // ESSENCE SYSTEM
    public static final Codec<ModEssenceSystem> ESSENCE_CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("maxEssence").forGetter(ModEssenceSystem::maxVal),
            Codec.FLOAT.fieldOf("currentEssence").forGetter(ModEssenceSystem::currentVal)
    ).apply(instance, ModEssenceSystem::new));

    public static final Supplier<AttachmentType<ModEssenceSystem>> ESSENCE =
            ATTACHMENT_TYPES.register("guzhenren.player.essence",
                    () -> AttachmentType.builder(() -> new ModEssenceSystem(0, 0f))
                            .serialize(ESSENCE_CODEC).build());

    public static void register(IEventBus modBus) {
        ATTACHMENT_TYPES.register(modBus);
    }
}
