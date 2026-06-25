package net.lunaplenaa.terraadventuremod.register;

import net.lunaplenaa.terraadventuremod.TerraAdventureMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TerraAdventureItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TerraAdventureMod.MODID);

    // basic items
    public static final DeferredItem<Item> ORIGINIUM_SHARD = ITEMS.register("originium_shard",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PURE_ORIGINIUM_SHARD = ITEMS.register("pure_originium_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_MANGANESE = ITEMS.register("raw_manganese",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
