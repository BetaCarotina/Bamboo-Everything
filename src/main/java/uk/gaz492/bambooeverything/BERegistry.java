package uk.gaz492.bambooeverything;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import uk.gaz492.bambooeverything.blocks.BambooFenceBlock;
import uk.gaz492.bambooeverything.blocks.BambooFenceGateBlock;
import uk.gaz492.bambooeverything.blocks.BambooLadderBlock;
import uk.gaz492.bambooeverything.util.ModInfo;

import java.util.function.Supplier;

public class BERegistry {

    //Ladder
    public static Block bambooLadderBlock;
    public static Item bambooLadderItem;

    //Fence
    public static Block bambooFenceBlock;
    public static Item bambooFenceItem;
    public static Block bambooFenceGateBlock;
    public static Item bambooFenceGateItem;

    //(Trap)Door
//    public final Block bambooDoorBlock;
//    public final Item bambooDoorItem;
//    public final Block bambooTrapDoorBlock;
//    public final Item bambooTrapDoorItem;

    public static ItemGroup creativeTab = FabricItemGroupBuilder.build(new Identifier(ModInfo.ID + ":bambooeverything"), new Supplier<ItemStack>() {
        @Override
        public ItemStack get() {
            return new ItemStack(bambooFenceBlock);
        }
    });

    private final Item.Settings defaultSettings = new Item.Settings().group(creativeTab);

    BERegistry(BambooEverything mod){
        //Ladder
        this.bambooLadderBlock = this.blockRegister("bamboo_ladder", new BambooLadderBlock(FabricBlockSettings.of(Material.BAMBOO).sounds(BlockSoundGroup.LADDER).build()));
        this.bambooLadderItem = this.itemRegister("bamboo_ladder", this.bambooLadderBlock, this.defaultSettings);
        //Fence
        this.bambooFenceBlock = this.blockRegister("bamboo_fence", new BambooFenceBlock(FabricBlockSettings.of(Material.BAMBOO).strength(2.0f, 3.0f).sounds(BlockSoundGroup.BAMBOO).build()));
        this.bambooFenceItem = this.itemRegister("bamboo_fence", this.bambooFenceBlock, this.defaultSettings);
        this.bambooFenceGateBlock = this.blockRegister("bamboo_fence_gate", new BambooFenceGateBlock(FabricBlockSettings.of(Material.BAMBOO).strength(2.0f, 3.0f).sounds(BlockSoundGroup.BAMBOO).build()));
        this.bambooFenceGateItem = this.itemRegister("bamboo_fence_gate", this.bambooFenceGateBlock, this.defaultSettings);
    }

    private Block blockRegister(String id, Block block){
        return Registry.BLOCK.add(new Identifier(ModInfo.ID, id), block);
    }

    private Item itemRegister (String id, Block block, Item.Settings settings){
        return Registry.ITEM.add(new Identifier(ModInfo.ID, id), new BlockItem(block, settings));
    }
}