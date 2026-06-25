package net.lunaplenaa.terraadventuremod.datagen;

import net.lunaplenaa.terraadventuremod.register.TerraAdventureBlocks;
import net.lunaplenaa.terraadventuremod.register.TerraAdventureItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class TerraAdventureBlockLootProvider extends BlockLootSubProvider {
    protected TerraAdventureBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(TerraAdventureBlocks.CRYSTALLIZED_ORIGINIUM_BLOCK.get(),
                block -> createMultipleOreDrops(TerraAdventureBlocks.CRYSTALLIZED_ORIGINIUM_BLOCK.get(), TerraAdventureItems.ORIGINIUM_SHARD.get(), 1, 2));
        add(TerraAdventureBlocks.ORIGINIUM_ORE.get(),
                block -> createMultipleOreDrops(TerraAdventureBlocks.ORIGINIUM_ORE.get(), TerraAdventureItems.ORIGINIUM_SHARD.get(), 1, 3));
        add(TerraAdventureBlocks.DEEPSLATE_ORIGINIUM_ORE.get(),
                block -> createMultipleOreDrops(TerraAdventureBlocks.DEEPSLATE_ORIGINIUM_ORE.get(), TerraAdventureItems.ORIGINIUM_SHARD.get(), 1, 3));
        add(TerraAdventureBlocks.NETHER_ORIGINIUM_ORE.get(),
                block -> createMultipleOreDrops(TerraAdventureBlocks.NETHER_ORIGINIUM_ORE.get(), TerraAdventureItems.ORIGINIUM_SHARD.get(), 1, 3));

        add(TerraAdventureBlocks.MANGANESE_ORE.get(),
                block -> createMultipleOreDrops(TerraAdventureBlocks.MANGANESE_ORE.get(), TerraAdventureItems.RAW_MANGANESE.get(), 1, 2));
        add(TerraAdventureBlocks.DEEPSLATE_MANGANESE_ORE.get(),
                block -> createMultipleOreDrops(TerraAdventureBlocks.MANGANESE_ORE.get(), TerraAdventureItems.RAW_MANGANESE.get(), 1, 2));
        dropSelf(TerraAdventureBlocks.MANGANESE_BLOCK.get());
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return TerraAdventureBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
