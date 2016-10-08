package appalachia.api;

import net.minecraft.world.biome.Biome;

public class AppalachiaBiomes {

    public static Biome appalachianMountains;
    public static Biome blueRidgeForest;
    public static Biome blueRidgeMountains;
    public static Biome prairie;
    public static Biome smokyMountains;

    public static Biome autumnBlueRidgeForest;

    public static enum AppalachiaBiomeProps {

        APPALACHIAN_MOUNTAINS("Appalachian Mountains", 1.0F, 0.5F, 0.2F, 0.3F, 2368150, false),
        BLUE_RIDGE_MOUNTAINS("Blue Ridge Mountains", 1.0F, 0.5F, 0.2F, 0.3F, 2368150, false),
        AUTUMN_BLUE_RIDGE_FOREST("Autumn Blue Ridge Forest", 0.2F, 0.2F, 0.3F, 0.8F, 4540477, false),
        BLUE_RIDGE_FOREST("Blue Ridge Forest", 0.125F, 0.05F, 0.8F, 0.4F, 2368150, false),
        PRAIRIE("Prairie", 0.125F, 0.05F, 0.8F, 0.4F, 2368150, false),
        SMOKY_MOUNTAINS("Smoky Mountains", 1.0F, 0.5F, 0.2F, 0.3F, 2368150, false);

        private final String biomeName;
        private final float baseHeight;
        private final float heightVariation;
        private final float temperature;
        private final float rainfall;
        private final int waterColour;
        private final boolean snowEnabled;
        private final Biome.BiomeProperties props;

        AppalachiaBiomeProps(String biomeName, float baseHeight, float heightVariation, float temperature, float rainfall, int waterColour, boolean snowEnabled) {

            this.biomeName = biomeName;
            this.baseHeight = baseHeight;
            this.heightVariation = heightVariation;
            this.temperature = temperature;
            this.rainfall = rainfall;
            this.waterColour = waterColour;
            this.snowEnabled = snowEnabled;

            this.props = new Biome.BiomeProperties(this.biomeName)
                .setBaseHeight(this.baseHeight)
                .setHeightVariation(this.heightVariation)
                .setTemperature(this.temperature)
                .setRainfall(this.rainfall)
                .setWaterColor(this.waterColour);

            if (this.snowEnabled) {
                this.props.setSnowEnabled();
            }
        }

        public String getBiomeName() {

            return this.biomeName;
        }

        public float getBaseHeight() {

            return this.baseHeight;
        }

        public float getHeightVariation() {

            return this.heightVariation;
        }

        public float getTemperature() {

            return this.temperature;
        }

        public float getRainfall() {

            return this.rainfall;
        }

        public int getWaterColour() {

            return this.waterColour;
        }

        public boolean getSnowEnabled() {

            return this.snowEnabled;
        }

        public Biome.BiomeProperties getProps() {

            return this.props;
        }
    }
}
