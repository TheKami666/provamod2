package net.tozzifan6717.provamod.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    //click centrale su FoodProperties per aprire tutti i metodi, per poi cliccare su Foods con CTRL+H per vedere i cibi vanilla.
    //crea un oggetto fragola, che da 2 punti nutrizione e dà Velocità per 200ticks con una probabilità del 10%.
    public static final FoodProperties FRAGOLA = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).fast()
            .effect(()-> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build();

}
