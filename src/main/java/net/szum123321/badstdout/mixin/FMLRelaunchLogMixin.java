package net.szum123321.badstdout.mixin;

import cpw.mods.fml.relauncher.FMLRelaunchLog;
import net.szum123321.badstdout.SourceAwarePrintStream;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = FMLRelaunchLog.class, remap = false)
public class FMLRelaunchLogMixin {
    @Inject(method = "Lcpw/mods/fml/relauncher/FMLRelaunchLog;configureLogging()V", at = @At("RETURN"))
    private void configureLogging(CallbackInfo ci) {
        System.setOut(new SourceAwarePrintStream("STDOUT", System.out));
        System.setOut(new SourceAwarePrintStream("STDERR", System.err));
    }
}
