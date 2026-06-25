package net.lunaplenaa.terraadventuremod.register;

import net.lunaplenaa.terraadventuremod.TerraAdventureMod;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TerraAdventureBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TerraAdventureMod.MODID);

    // ORIGINIUM CRYSTAL BLOCKS
    public static final DeferredBlock<Block> CRYSTALLIZED_ORIGINIUM_BLOCK = registerBlock("originium_crystal_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.0F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    // ORE BLOCKS
    public static final DeferredBlock<Block> ORIGINIUM_ORE = registerBlock("originium_ore",
            () -> new DropExperienceBlock(UniformInt.of(0, 3),
                    BlockBehaviour.Properties.of()
                            .strength(3.0F).explosionResistance(3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_ORIGINIUM_ORE = registerBlock("originium_ore_deepslate",
            () -> new DropExperienceBlock(UniformInt.of(1, 3),
                    BlockBehaviour.Properties.of()
                            .strength(4.5F).explosionResistance(3.0F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> NETHER_ORIGINIUM_ORE = registerBlock("originium_ore_netherrack",
            () -> new DropExperienceBlock(UniformInt.of(1, 3),
                    BlockBehaviour.Properties.of()
                            .strength(3.0F).explosionResistance(3.0F).requiresCorrectToolForDrops().sound(SoundType.NETHERRACK)));

    public static final DeferredBlock<Block> MANGANESE_ORE = registerBlock("manganese_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.of()
                            .strength(3.0F).explosionResistance(3.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_MANGANESE_ORE = registerBlock("manganese_ore_deepslate",
            () -> new DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.of()
                            .strength(4.5F).explosionResistance(3.0F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    // BASIC BLOCKS
    public static final DeferredBlock<Block> MANGANESE_BLOCK = registerBlock("manganese_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4.0F).explosionResistance(5.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        TerraAdventureItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
