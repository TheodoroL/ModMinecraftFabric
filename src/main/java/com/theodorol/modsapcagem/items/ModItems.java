package com.theodorol.modsapcagem.items;

import com.theodorol.modsapcagem.ModSapecagem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.advancements.predicates.FoodPredicate;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {


    public static final Item SUSPICIOUS_SUBSTANCE = register(ModItemsIds.SUSPICIOUS_SUBSTANCE, Item::new, new Item.Properties());

    public static final Consumable POISON_FOOD_CONSUMABLE_COMPONENT = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, 6*20,1)))
            .build();

    public static final FoodProperties POISON_FOOD_COMPONENT = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(4)
            .alwaysEdible()
            .build();

    public static final Item POISONOUS_APPLE = register(
            ModItemsIds.APPLE_POISON,
            Item::new,
            new Item.Properties().food(POISON_FOOD_COMPONENT, POISON_FOOD_CONSUMABLE_COMPONENT)
    );
    //vai registrar o item
    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory,Item.Properties settings ){
        Item item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    public static void initialize(){
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((creativeTab)-> creativeTab.accept(ModItems.SUSPICIOUS_SUBSTANCE));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register((crativeTab)-> crativeTab.accept(ModItems.POISONOUS_APPLE));


    }
}
