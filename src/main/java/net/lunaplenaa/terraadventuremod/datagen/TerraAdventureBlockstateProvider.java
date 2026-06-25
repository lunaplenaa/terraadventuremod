package net.lunaplenaa.terraadventuremod.datagen;

import net.lunaplenaa.terraadventuremod.TerraAdventureMod;
import net.lunaplenaa.terraadventuremod.register.TerraAdventureBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class TerraAdventureBlockstateProvider extends BlockStateProvider {
    public TerraAdventureBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TerraAdventureMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(TerraAdventureBlocks.ORIGINIUM_ORE);
        blockWithItem(TerraAdventureBlocks.DEEPSLATE_ORIGINIUM_ORE);
        blockWithItem(TerraAdventureBlocks.NETHER_ORIGINIUM_ORE);
        blockWithItem(TerraAdventureBlocks.CRYSTALLIZED_ORIGINIUM_BLOCK);

        blockWithItem(TerraAdventureBlocks.MANGANESE_ORE);
        blockWithItem(TerraAdventureBlocks.DEEPSLATE_MANGANESE_ORE);
        blockWithItem(TerraAdventureBlocks.MANGANESE_BLOCK);


    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
