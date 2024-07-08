package net.tozzifan6717.provamod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/*
Librerie da tenere in considerazione:
- Block
- BlockBehaviour
- IForgeBlock
ci sono tanti metodi belli da sovrascrivere.
 */

public class SoundBlock extends Block {
    public SoundBlock(Properties pProperties) {
        super(pProperties);
    }
    //anche se Deprecated, puoi usare tutti i metodi.

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        //quando questo blocco viene cliccato, produrrerà un suono.
        pLevel.playSound(pPlayer, pPos, SoundEvents.NOTE_BLOCK_DIDGERIDOO.get(), SoundSource.BLOCKS, 1f,1f);

        //InteractionResult.SUCCESS; è per avere l'animazione della mano.
        return InteractionResult.SUCCESS;
    }
}
