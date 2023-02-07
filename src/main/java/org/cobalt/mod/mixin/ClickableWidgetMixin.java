package org.cobalt.mod.mixin;

import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClickableWidget.class)
public class ClickableWidgetMixin {
    @Inject(method="playDownSound(Lnet/minecraft/client/sound/SoundManager;)V", at=@At(value="HEAD"), cancellable=true)
    private static void playSound(SoundManager soundManager, CallbackInfo ci) {
        soundManager.play(PositionedSoundInstance.master(SoundEvent.of(new Identifier("cobalt:click.ogg")), 1.0F));
        ci.cancel();
    }
}
