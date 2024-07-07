package net.tozzifan6717.provamod.Item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tozzifan6717.provamod.ProvaMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProvaMod.MOD_ID);

    //creare un Oggetto:
    public static final RegistryObject<Item> ZAFFIRO = ITEMS.register("zaffiro",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZAFFIRO_PURO = ITEMS.register("zaffiro_puro",
            ()-> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}