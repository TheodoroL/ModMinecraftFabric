package com.theodorol.modsapcagem.items;

import com.theodorol.modsapcagem.ModSapecagem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemsIds {
    public static  ResourceKey<Item> SUSPICIOUS_SUBSTANCE = create("suspicious_substance");
    public static ResourceKey<Item> APPLE_POISON = create("apple_poison");

    public static ResourceKey<Item> create(String name) {
        // Create the item key.
        return ResourceKey.create(Registries.ITEM, ModSapecagem.id(name));
    }
}
