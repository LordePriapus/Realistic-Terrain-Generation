package rtg.world.gen.surface.mithwoodforest;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import rtg.api.biome.BiomeConfig;
import rtg.api.biome.vanilla.config.BiomeConfigVanillaForest;
import rtg.util.CellNoise;
import rtg.util.CliffCalculator;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.surface.SurfaceBase;

public class SurfaceMFMithwoodForest extends SurfaceBase {

    private float min;

    private float sCliff = 1.5f;
    private float sHeight = 60f;
    private float sStrength = 65f;
    private float cCliff = 1.5f;

    private IBlockState mixBlock;
    private float mixHeight;

    public SurfaceMFMithwoodForest(BiomeConfig config, IBlockState top, IBlockState fill, float minCliff, float stoneCliff,
                                float stoneHeight, float stoneStrength, float clayCliff, IBlockState mix, float mixSize) {

        super(config, top, fill);
        min = minCliff;

        sCliff = stoneCliff;
        sHeight = stoneHeight;
        sStrength = stoneStrength;
        cCliff = clayCliff;

        mixBlock = this.getConfigBlock(config, BiomeConfigVanillaForest.surfaceMixBlockId,
            BiomeConfigVanillaForest.surfaceMixBlockMetaId,
            mix);
        mixHeight = mixSize;
    }

    @Override
    public void paintTerrain(ChunkPrimer primer, int i, int j, int x, int y, int depth, World world, Random rand,
                             OpenSimplexNoise simplex, CellNoise cell, float[] noise, float river, Biome[] base) {

        float c = CliffCalculator.calc(x, y, noise);
        int cliff = 0;
        boolean m = false;

        Block b;
        for (int k = 255; k > -1; k--) {
            b = primer.getBlockState(x, k, y).getBlock();
            if (b == Blocks.AIR) {
                depth = -1;
            }
            else if (b == Blocks.STONE) {
                depth++;

                if (depth == 0) {

                    float p = simplex.noise3(i / 8f, j / 8f, k / 8f) * 0.5f;
                    if (c > min && c > sCliff - ((k - sHeight) / sStrength) + p) {
                        cliff = 1;
                    }
                    if (c > cCliff) {
                        cliff = 2;
                    }

                    if (cliff == 1) {
                        if (rand.nextInt(3) == 0) {

                            primer.setBlockState(x, k, y, hcCobble(world, i, j, x, y, k));
                        }
                        else {

                            primer.setBlockState(x, k, y, hcStone(world, i, j, x, y, k));
                        }
                    }
                    else if (cliff == 2) {
                        primer.setBlockState(x, k, y, getShadowStoneBlock(world, i, j, x, y, k));
                    }
                    else if (k < 63) {
                        if (k < 62) {
                            primer.setBlockState(x, k, y, fillerBlock);
                        }
                        else {
                            primer.setBlockState(x, k, y, topBlock);
                        }
                    }
                    else if (simplex.noise2(i / 12f, j / 12f) > mixHeight) {
                        primer.setBlockState(x, k, y, mixBlock);
                        m = true;
                    }
                    else {
                        primer.setBlockState(x, k, y, topBlock);
                    }
                }
                else if (depth < 6) {
                    if (cliff == 1) {
                        primer.setBlockState(x, k, y, hcStone(world, i, j, x, y, k));
                    }
                    else if (cliff == 2) {
                        primer.setBlockState(x, k, y, getShadowStoneBlock(world, i, j, x, y, k));
                    }
                    else {
                        primer.setBlockState(x, k, y, fillerBlock);
                    }
                }
            }
        }
    }
    
}
