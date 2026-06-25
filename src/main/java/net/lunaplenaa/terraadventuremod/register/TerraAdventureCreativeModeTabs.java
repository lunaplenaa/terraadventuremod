package net.lunaplenaa.terraadventuremod.register;

import net.lunaplenaa.terraadventuremod.TerraAdventureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TerraAdventureCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TerraAdventureMod.MODID);

    public static final Supplier<CreativeModeTab> TAA_ITEMS_TAB = CREATIVE_MODE_TAB.register("terra_adventure_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(TerraAdventureItems.ORIGINIUM_SHARD.get()))
                    .withTabsAfter(ResourceLocation.fromNamespaceAndPath(TerraAdventureMod.MODID, "terra_adventure_blocks_tab"))
                    .title(Component.translatable("creativetab.terraadventuremod.itemstab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(TerraAdventureItems.ORIGINIUM_SHARD);
                        output.accept(TerraAdventureItems.PURE_ORIGINIUM_SHARD);
                        output.accept(TerraAdventureItems.RAW_MANGANESE);
                    }).build());

    public static final Supplier<CreativeModeTab> TAA_BLOCKS_TAB = CREATIVE_MODE_TAB.register("terra_adventure_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(TerraAdventureBlocks.ORIGINIUM_ORE))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TerraAdventureMod.MODID, "terra_adventure_items_tab"))
                    .withTabsAfter(ResourceLocation.fromNamespaceAndPath(TerraAdventureMod.MODID, "terra_adventure_equipment_tab"))
                    .title(Component.translatable("creativetab.terraadventuremod.blockstab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(TerraAdventureBlocks.ORIGINIUM_ORE);
                        output.accept(TerraAdventureBlocks.DEEPSLATE_ORIGINIUM_ORE);
                        output.accept(TerraAdventureBlocks.NETHER_ORIGINIUM_ORE);
                        output.accept(TerraAdventureBlocks.CRYSTALLIZED_ORIGINIUM_BLOCK);
                        output.accept(TerraAdventureBlocks.MANGANESE_ORE);
                        output.accept(TerraAdventureBlocks.DEEPSLATE_MANGANESE_ORE);
                        output.accept(TerraAdventureBlocks.MANGANESE_BLOCK);
                    }).build());

    public static final Supplier<CreativeModeTab> TAA_EQUIPMENT_TAB = CREATIVE_MODE_TAB.register("terra_adventure_equipment_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.DIAMOND_SWORD))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TerraAdventureMod.MODID, "terra_adventure_blocks_tab"))
                    .withTabsAfter(ResourceLocation.fromNamespaceAndPath(TerraAdventureMod.MODID, "terra_adventure_spawneggs_tab"))
                    .title(Component.translatable("creativetab.terraadventuremod.equipmenttab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(TerraAdventureItems.ORIGINIUM_SHARD);
                    }).build());

    public static final Supplier<CreativeModeTab> TAA_SPAWNEGGS_TAB = CREATIVE_MODE_TAB.register("terra_adventure_spawneggs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.EGG))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TerraAdventureMod.MODID, "terra_adventure_equipment_tab"))
                    .withTabsAfter(ResourceLocation.fromNamespaceAndPath(TerraAdventureMod.MODID, "terra_adventure_misc_tab"))
                    .title(Component.translatable("creativetab.terraadventuremod.eggstab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(TerraAdventureItems.ORIGINIUM_SHARD);
                    }).build());

    public static final Supplier<CreativeModeTab> TAA_MSIC_TAB = CREATIVE_MODE_TAB.register("terra_adventure_misc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.ZOMBIE_HEAD))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TerraAdventureMod.MODID, "terra_adventure_spawneggs_tab"))
                    .title(Component.translatable("creativetab.terraadventuremod.misctab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(TerraAdventureItems.ORIGINIUM_SHARD);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
