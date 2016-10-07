package rtg.world.biome.realistic.appalachia;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

import appalachia.api.AppalachiaBiomes;

import rtg.api.biome.BiomeConfig;
import rtg.world.biome.deco.DecoBaseBiomeDecorations;
import rtg.world.gen.surface.appalachia.SurfaceAPLPrairie;
import rtg.world.gen.terrain.appalachia.TerrainAPLPrairie;

public class RealisticBiomeAPLPrairie extends RealisticBiomeAPLBase {

    public static Biome biome = AppalachiaBiomes.prairie;
    public static Biome river = Biomes.RIVER;

    public RealisticBiomeAPLPrairie(BiomeConfig config) {

        super(config, biome, river,
            new TerrainAPLPrairie(65f, 80f, 25f),
            new SurfaceAPLPrairie(config, biome.topBlock, biome.fillerBlock)
        );

        DecoBaseBiomeDecorations decoBaseBiomeDecorations = new DecoBaseBiomeDecorations();
        this.addDeco(decoBaseBiomeDecorations);
    }
}
