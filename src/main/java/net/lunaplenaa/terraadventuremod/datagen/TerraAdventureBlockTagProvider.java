package net.lunaplenaa.terraadventuremod.datagen;

import net.lunaplenaa.terraadventuremod.TerraAdventureMod;
import net.lunaplenaa.terraadventuremod.register.TerraAdventureBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TerraAdventureBlockTagProvider extends BlockTagsProvider {
    public TerraAdventureBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TerraAdventureMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(TerraAdventureBlocks.ORIGINIUM_ORE.get())
                .add(TerraAdventureBlocks.DEEPSLATE_ORIGINIUM_ORE.get())
                .add(TerraAdventureBlocks.NETHER_ORIGINIUM_ORE.get())
                .add(TerraAdventureBlocks.CRYSTALLIZED_ORIGINIUM_BLOCK.get())
                .add(TerraAdventureBlocks.MANGANESE_ORE.get())
                .add(TerraAdventureBlocks.DEEPSLATE_MANGANESE_ORE.get())
                .add(TerraAdventureBlocks.MANGANESE_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(TerraAdventureBlocks.CRYSTALLIZED_ORIGINIUM_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(TerraAdventureBlocks.ORIGINIUM_ORE.get())
                .add(TerraAdventureBlocks.DEEPSLATE_ORIGINIUM_ORE.get())
                .add(TerraAdventureBlocks.NETHER_ORIGINIUM_ORE.get())
                .add(TerraAdventureBlocks.MANGANESE_ORE.get())
                .add(TerraAdventureBlocks.DEEPSLATE_MANGANESE_ORE.get())
                .add(TerraAdventureBlocks.MANGANESE_BLOCK.get());
    }
}
