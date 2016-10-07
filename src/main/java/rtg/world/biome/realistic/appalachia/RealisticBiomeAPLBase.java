package rtg.world.biome.realistic.appalachia;

import net.minecraft.world.biome.Biome;

import net.minecraftforge.fml.common.Loader;

import appalachia.api.AppalachiaBiomes;

import rtg.api.biome.BiomeConfig;
import rtg.api.biome.appalachia.config.BiomeConfigAPL;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.SurfaceBase;
import rtg.world.gen.terrain.TerrainBase;

public class RealisticBiomeAPLBase extends RealisticBiomeBase {

    public static RealisticBiomeBase aplAppalachianMountains;
    public static RealisticBiomeBase aplAutumnBlueRidgeForest;
    public static RealisticBiomeBase aplBlueRidgeForest;
    public static RealisticBiomeBase aplBlueRidgeMountains;
    public static RealisticBiomeBase aplPrairie;
    public static RealisticBiomeBase aplSmokyMountains;

    public RealisticBiomeAPLBase(BiomeConfig config, Biome b, Biome riverbiome, TerrainBase t, SurfaceBase s) {

        super(config, b, riverbiome, t, s);

        this.waterSurfaceLakeChance = 0;
        this.lavaSurfaceLakeChance = 0;
    }

    public static void addBiomes() {

        if (Loader.isModLoaded("appalachia")) {
            if (AppalachiaBiomes.appalachianMountains != null) {
                aplAppalachianMountains = new RealisticBiomeAPLAppalachianMountains(BiomeConfigAPL.biomeConfigAPLAppalachianMountains);
            }
            if (AppalachiaBiomes.autumnBlueRidgeForest != null) {
                aplAutumnBlueRidgeForest = new RealisticBiomeAPLAutumnBlueRidgeForest(BiomeConfigAPL.biomeConfigAPLAutumnBlueRidgeForest);
            }
            if (AppalachiaBiomes.blueRidgeForest != null) {
                aplBlueRidgeForest = new RealisticBiomeAPLBlueRidgeForest(BiomeConfigAPL.biomeConfigAPLBlueRidgeForest);
            }
            if (AppalachiaBiomes.blueRidgeMountains != null) {
                aplBlueRidgeMountains = new RealisticBiomeAPLBlueRidgeMountains(BiomeConfigAPL.biomeConfigAPLBlueRidgeMountains);
            }
            if (AppalachiaBiomes.prairie != null) {
                aplPrairie = new RealisticBiomeAPLPrairie(BiomeConfigAPL.biomeConfigAPLPrairie);
            }
            if (AppalachiaBiomes.smokyMountains != null) {
                aplSmokyMountains = new RealisticBiomeAPLSmokyMountains(BiomeConfigAPL.biomeConfigAPLSmokyMountains);
            }
        }
    }
}
