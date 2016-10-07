package rtg.api.biome.appalachia.config;

import rtg.api.biome.BiomeConfig;

public class BiomeConfigAPL {

    public static BiomeConfig biomeConfigAPLAppalachianMountains;
    public static BiomeConfig biomeConfigAPLAutumnBlueRidgeForest;
    public static BiomeConfig biomeConfigAPLBlueRidgeForest;
    public static BiomeConfig biomeConfigAPLBlueRidgeMountains;
    public static BiomeConfig biomeConfigAPLPrairie;
    public static BiomeConfig biomeConfigAPLSmokyMountains;

    public static BiomeConfig[] getBiomeConfigs() {

        BiomeConfig[] biomeConfigs = new BiomeConfig[]{
            biomeConfigAPLAppalachianMountains,
            biomeConfigAPLAutumnBlueRidgeForest,
            biomeConfigAPLBlueRidgeForest,
            biomeConfigAPLBlueRidgeMountains,
            biomeConfigAPLPrairie,
            biomeConfigAPLSmokyMountains
        };

        return biomeConfigs;
    }
}
