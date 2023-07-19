package net.noirex.tutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.noirex.tutorialmod.TutorialMod;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =  DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
        TutorialMod.MOD_ID);

    public static RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DIRTY_MOON_FRAGMENT.get()))
                    .title(Component.translatable("creativemodtab.tutorial_tab")).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
