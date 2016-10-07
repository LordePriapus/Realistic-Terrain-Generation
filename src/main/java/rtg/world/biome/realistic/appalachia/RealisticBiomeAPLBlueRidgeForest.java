package rtg.world.biome.realistic.appalachia;

import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

import appalachia.api.AppalachiaBiomes;

import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.appalachia.SurfaceAPLBlueRidgeForest;
import rtg.world.gen.terrain.appalachia.TerrainAPLBlueRidgeForest;

public class RealisticBiomeAPLBlueRidgeForest extends RealisticBiomeAPLBase {

    public static Biome biome = AppalachiaBiomes.blueRidgeForest;
    public static Biome river = Biomes.RIVER;

    public RealisticBiomeAPLBlueRidgeForest(BiomeConfig config) {

        super(config, biome, river,
            new TerrainAPLBlueRidgeForest(),
            new SurfaceAPLBlueRidgeForest(config, biome.topBlock, biome.fillerBlock, 0f, 1.5f, 60f, 65f, 1.5f, Blocks.DIRT.getStateFromMeta(2), 0.15f)
        );

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}
