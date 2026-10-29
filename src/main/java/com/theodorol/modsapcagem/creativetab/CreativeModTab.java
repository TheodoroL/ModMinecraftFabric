package com.theodorol.modsapcagem.creativetab;

import com.theodorol.modsapcagem.ModSapecagem;
import com.theodorol.modsapcagem.items.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeModTab {
    public static final ResourceKey<CreativeModeTab> CUSTOM_MY_TAB_Key = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), ModSapecagem.id("creative_tab")
    );

    public  static CreativeModeTab  CUSTOM_MY_TAB = FabricCreativeModeTab.builder()
            .icon(()-> new ItemStack(ModItems.POISONOUS_APPLE))
            .title(Component.translatable("creative.mod.tab"))
            .displayItems(((parameters, output) -> {
                output.accept(ModItems.SUSPICIOUS_SUBSTANCE);
                output.accept(ModItems.POISONOUS_APPLE);
            }))
            .build();

    public static  void onInitialize(){
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_MY_TAB_Key, CUSTOM_MY_TAB);

    }
}
