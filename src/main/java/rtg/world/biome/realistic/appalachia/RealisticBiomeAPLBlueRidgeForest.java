package rtg.world.biome.realistic.appalachia;

import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import appalachia.api.AppalachiaBiomes;
import appalachia.api.world.gen.feature.tree.AppalachiaTree;
import appalachia.api.world.gen.feature.tree.TreeAbiesGrandis;

import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoGrass;
import rtg.world.biome.deco.DecoTree;
import rtg.world.gen.feature.tree.rtg.TreeRTG;
import rtg.world.gen.feature.tree.rtg.TreeRTGPinusPonderosa;
import rtg.world.gen.surface.appalachia.SurfaceAPLBlueRidgeForest;
import rtg.world.gen.terrain.appalachia.TerrainAPLBlueRidgeForest;
import static rtg.world.biome.deco.DecoTree.TreeCondition;
import static rtg.world.biome.deco.DecoTree.TreeType;

public class RealisticBiomeAPLBlueRidgeForest extends RealisticBiomeAPLBase {

    public static Biome biome = AppalachiaBiomes.blueRidgeForest;
    public static Biome river = Biomes.RIVER;
    private static int treeMaxY = 140;
    private static int shrubMaxY = 140;

    public RealisticBiomeAPLBlueRidgeForest(BiomeConfig config) {

        super(config, biome, river,
            new TerrainAPLBlueRidgeForest(),
            new SurfaceAPLBlueRidgeForest(config, biome.topBlock, biome.fillerBlock, 0f, 1.5f, 60f, 65f, 1.5f, Blocks.DIRT.getStateFromMeta(2), 0.15f)
        );

//        AppalachiaTree aplRedMaple = new TreeAcerRubrum();
//        aplRedMaple.logBlock = Blocks.LOG.getDefaultState();
//        aplRedMaple.leavesBlock = Blocks.LEAVES.getDefaultState();
//        aplRedMaple.minTrunkSize = 11;
//        aplRedMaple.maxTrunkSize = 21;
//        aplRedMaple.minCrownSize = 15;
//        aplRedMaple.maxCrownSize = 29;
//        DecoTree oakRedMaple = new DecoTree(aplRedMaple);
//        oakRedMaple.loops = 2;
//        oakRedMaple.treeType = TreeType.WORLDGEN;
//        oakRedMaple.distribution.noiseDivisor = 100f;
//        oakRedMaple.distribution.noiseFactor = 6f;
//        oakRedMaple.distribution.noiseAddend = 0.8f;
//        oakRedMaple.treeCondition = TreeCondition.NOISE_GREATER_AND_RANDOM_CHANCE;
//        oakRedMaple.treeConditionNoise = -0.2f;
//        oakRedMaple.treeConditionChance = 1;
//        oakRedMaple.maxY = treeMaxY;
//        this.addDeco(oakRedMaple);

        AppalachiaTree aplGrandFirTree = new TreeAbiesGrandis();
        aplGrandFirTree.logBlock = Blocks.LOG.getDefaultState();
        aplGrandFirTree.leavesBlock = Blocks.LEAVES.getDefaultState();
        aplGrandFirTree.minTrunkSize = 10;
        aplGrandFirTree.maxTrunkSize = 20;
        aplGrandFirTree.minCrownSize = 15;
        aplGrandFirTree.maxCrownSize = 30;
        DecoTree oakFir = new DecoTree(aplGrandFirTree);
        oakFir.loops = 1;
        oakFir.treeType = TreeType.WORLDGEN;
        oakFir.distribution.noiseDivisor = 100f;
        oakFir.distribution.noiseFactor = 6f;
        oakFir.distribution.noiseAddend = 0.8f;
        oakFir.treeCondition = TreeCondition.NOISE_GREATER_AND_RANDOM_CHANCE;
        oakFir.treeConditionNoise = -0.8f;
        oakFir.treeConditionChance = 2;
        oakFir.maxY = treeMaxY;
        this.addDeco(oakFir);

        TreeRTG ponderosaOakTree = new TreeRTGPinusPonderosa();
        ponderosaOakTree.logBlock = Blocks.LOG.getDefaultState();
        ponderosaOakTree.leavesBlock = Blocks.LEAVES.getDefaultState();
        ponderosaOakTree.minTrunkSize = 11;
        ponderosaOakTree.maxTrunkSize = 21;
        ponderosaOakTree.minCrownSize = 15;
        ponderosaOakTree.maxCrownSize = 29;
        this.addTree(ponderosaOakTree);
        DecoTree oakPines = new DecoTree(ponderosaOakTree);
        oakPines.strengthFactorForLoops = 4f;
        oakPines.treeType = TreeType.RTG_TREE;
        oakPines.distribution.noiseDivisor = 100f;
        oakPines.distribution.noiseFactor = 6f;
        oakPines.distribution.noiseAddend = 0.8f;
        oakPines.treeCondition = TreeCondition.NOISE_LESSER_AND_RANDOM_CHANCE;
        oakPines.treeConditionNoise = 0.2f;
        oakPines.treeConditionChance = 1;
        oakPines.maxY = treeMaxY;
        this.addDeco(oakPines);

//        TreeRTG sitchensisTree = new TreeRTGPiceaSitchensis();
//        sitchensisTree.logBlock = Blocks.LOG.getDefaultState();
//        sitchensisTree.leavesBlock = Blocks.LEAVES.getDefaultState();
//        sitchensisTree.minTrunkSize = 4;
//        sitchensisTree.maxTrunkSize = 10;
//        sitchensisTree.minCrownSize = 6;
//        sitchensisTree.maxCrownSize = 14;
//        this.addTree(sitchensisTree);
//        DecoTree oakPine = new DecoTree(sitchensisTree);
//        oakPine.strengthFactorForLoops = 3f;
//        oakPine.treeType = TreeType.RTG_TREE;
//        oakPine.treeCondition = TreeCondition.RANDOM_CHANCE;
//        oakPine.treeConditionChance = 4;
//        oakPine.maxY = treeMaxY;
//        WorldGenerator vanillaTreeDefinition = new WorldGenTrees(false);
//        DecoTree vanillaTrees = new DecoTree(vanillaTreeDefinition);
//        vanillaTrees.strengthFactorForLoops = 3f;
//        vanillaTrees.treeType = TreeType.WORLDGEN;
//        vanillaTrees.treeCondition = TreeCondition.RANDOM_CHANCE;
//        vanillaTrees.treeConditionChance = 4;
//        vanillaTrees.maxY = treeMaxY;
//        DecoHelperRandomSplit decoHelperRandomSplit = new DecoHelperRandomSplit();
//        decoHelperRandomSplit.decos = new DecoBase[]{oakPine, vanillaTrees};
//        decoHelperRandomSplit.chances = new int[]{8, 4};
//        this.addDeco(decoHelperRandomSplit);
//
//        // Add some fallen trees of the oak and spruce variety (50/50 distribution).
//        DecoFallenTree decoFallenOak = new DecoFallenTree();
//        decoFallenOak.logCondition = LogCondition.RANDOM_CHANCE;
//        decoFallenOak.logConditionChance = 16;
//        decoFallenOak.maxY = 80;
//        decoFallenOak.logBlock = Blocks.LOG.getDefaultState();
//        decoFallenOak.leavesBlock = Blocks.LEAVES.getDefaultState();
//        decoFallenOak.minSize = 3;
//        decoFallenOak.maxSize = 6;
//
//        DecoFallenTree decoFallenSpruce = new DecoFallenTree();
//        decoFallenSpruce.logCondition = LogCondition.RANDOM_CHANCE;
//        decoFallenSpruce.logConditionChance = 24;
//        decoFallenSpruce.maxY = 80;
//        decoFallenSpruce.logBlock = Blocks.LOG.getDefaultState();
//        decoFallenSpruce.leavesBlock = Blocks.LEAVES.getDefaultState();
//        decoFallenSpruce.minSize = 3;
//        decoFallenSpruce.maxSize = 6;
//
//        DecoHelper5050 decoFallenTree = new DecoHelper5050(decoFallenOak, decoFallenSpruce);
//        this.addDeco(decoFallenTree, this.config._boolean(BiomeConfigAPLBlueRidgeForest.decorationLogsId));
//
//        // Shrubs to fill in the blanks.
//        DecoShrub decoShrubOak = new DecoShrub();
//        decoShrubOak.maxY = shrubMaxY;
//        decoShrubOak.strengthFactor = 8f;
//        decoShrubOak.chance = 2;
//        this.addDeco(decoShrubOak);
//
//        // Only 1-block tall flowers so we can see the trees better.
//        DecoFlowersRTG decoFlowersRTG = new DecoFlowersRTG();
//        decoFlowersRTG.flowers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        decoFlowersRTG.maxY = shrubMaxY;
//        decoFlowersRTG.strengthFactor = 6f;
//        this.addDeco(decoFlowersRTG);

        // Grass filler.
        DecoGrass decoGrass = new DecoGrass();
        decoGrass.minY = 60;
        decoGrass.maxY = shrubMaxY;
        decoGrass.loops = 8;
        this.addDeco(decoGrass);
    }
}
