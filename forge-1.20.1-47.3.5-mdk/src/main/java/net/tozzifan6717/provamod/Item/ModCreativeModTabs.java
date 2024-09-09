package net.tozzifan6717.provamod.Item;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tozzifan6717.provamod.ProvaMod;
import net.tozzifan6717.provamod.block.ModBlocks;

//tabs personalizzate per la Mod in Creativa.
public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProvaMod.MOD_ID);

    //creando la TAB
    public static final RegistryObject<CreativeModeTab> PROVA_TAB = CREATIVE_MODE_TABS.register("prova_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.ZAFFIRO.get()))
                    .title(Component.translatable("creativetab.prova_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //formula: pOutput.accept(ModTipo.OGGETTO.get());
                        pOutput.accept(ModItems.ZAFFIRO.get());
                        pOutput.accept(ModItems.ZAFFIRO_PURO.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.FRAGOLA.get());
                        pOutput.accept(ModItems.PIGNA.get());
                        pOutput.accept(ModItems.ZAFFIRO_STAFFA.get());

                        pOutput.accept(ModBlocks.ZAFFIRO_BLOCCO.get());
                        pOutput.accept(ModBlocks.ZAFFIRO_GREZZO_BLOCCO.get());

                        pOutput.accept(ModBlocks.ZAFFIRO_MINERALE.get());
                        pOutput.accept(ModBlocks.ZAFFIRO_MINERALE_DEEPSLATE.get());
                        pOutput.accept(ModBlocks.ZAFFIRO_MINERALE_NETHER.get());
                        pOutput.accept(ModBlocks.ZAFFIRO_MINERALE_END.get());
                        pOutput.accept(ModBlocks.SOUNDBLOCK.get());

                        pOutput.accept(ModBlocks.ZAFFIRO_SCALE.get());
                        pOutput.accept(ModBlocks.ZAFFIRO_SLAB.get());
                        pOutput.accept(ModBlocks.ZAFFIRO_BOTTONE.get());
                        pOutput.accept(ModBlocks.ZAFFIRO_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.ZAFFIRO_FENCE.get());
                        pOutput.accept(ModBlocks.ZAFFIRO_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.ZAFFIRO_MURO.get());
                        pOutput.accept(ModBlocks.ZAFFIRO_PORTA.get());
                        pOutput.accept(ModBlocks.ZAFFIRO_BOTOLA.get());


                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
