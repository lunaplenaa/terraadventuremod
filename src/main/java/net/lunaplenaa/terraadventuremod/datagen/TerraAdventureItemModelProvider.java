package net.lunaplenaa.terraadventuremod.datagen;

import net.lunaplenaa.terraadventuremod.TerraAdventureMod;
import net.lunaplenaa.terraadventuremod.register.TerraAdventureItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class TerraAdventureItemModelProvider extends ItemModelProvider {
    public TerraAdventureItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TerraAdventureMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(TerraAdventureItems.ORIGINIUM_SHARD.get());
        basicItem(TerraAdventureItems.PURE_ORIGINIUM_SHARD.get());
        basicItem(TerraAdventureItems.RAW_MANGANESE.get());
    }
}
