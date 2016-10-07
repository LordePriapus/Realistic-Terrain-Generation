package rtg.world.biome.realistic.appalachia;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

import appalachia.api.AppalachiaBiomes;

import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.appalachia.SurfaceAPLAppalachianMountains;
import rtg.world.gen.terrain.appalachia.TerrainAPLAppalachianMountains;

public class RealisticBiomeAPLAppalachianMountains extends RealisticBiomeAPLBase {

    public static Biome biome = AppalachiaBiomes.appalachianMountains;
    public static Biome river = Biomes.RIVER;

    public RealisticBiomeAPLAppalachianMountains(BiomeConfig config) {

        super(config, biome, river,
            new TerrainAPLAppalachianMountains(),
            new SurfaceAPLAppalachianMountains(config, biome.topBlock, biome.fillerBlock, 0.45f)
        );

        this.noLakes = true;

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}
