package net.tozzifan6717.provamod.Item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tozzifan6717.provamod.Item.custom.FuelItem;
import net.tozzifan6717.provamod.Item.custom.MetalDetectorItem;
import net.tozzifan6717.provamod.ProvaMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProvaMod.MOD_ID);
    //ricorda, 20ticks = 1sec.
    //creare un Oggetto:
    public static final RegistryObject<Item> ZAFFIRO = ITEMS.register("zaffiro",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZAFFIRO_PURO = ITEMS.register("zaffiro_puro",
            ()-> new Item(new Item.Properties()));
    //creare un Oggetto Funzionale Personalizzato:
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(50)));
    //creare un Cibo:
    public static final RegistryObject<Item> FRAGOLA = ITEMS.register("fragola",
            ()-> new Item(new Item.Properties().food(ModFoods.FRAGOLA)));
    //creare un Combustibile: (l'attributo burnTime si conta in Ticks)
    public static final RegistryObject<Item> PIGNA = ITEMS.register("pigna",
            ()-> new FuelItem(new Item.Properties(), 400));
    //creare un item con una texture inventario 2D, in game 3D:
    public static final RegistryObject<Item> ZAFFIRO_STAFFA = ITEMS.register("zaffiro_staffa",
            ()-> new Item(new Item.Properties().stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}