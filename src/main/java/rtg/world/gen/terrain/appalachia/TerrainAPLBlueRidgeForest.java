package rtg.world.gen.terrain.appalachia;

import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.gen.terrain.BumpyHillsEffect;
import rtg.world.gen.terrain.TerrainBase;

public class TerrainAPLBlueRidgeForest extends TerrainBase {

    private float baseHeight = 64f;
    private float hillStrength = 50f;
    private BumpyHillsEffect hillEffect;
    private float hillWidth = 60f;
    private float hillBumpyness = 10f;
    private float hillBumpynessWidth = 20f;

    public TerrainAPLBlueRidgeForest() {

        hillEffect = new BumpyHillsEffect();
        hillEffect.hillHeight = hillStrength;
        hillEffect.hillWavelength = hillWidth;
        hillEffect.spikeHeight = hillBumpyness;
        hillEffect.spikeWavelength = this.hillBumpynessWidth;
    }

    public TerrainAPLBlueRidgeForest(float bh, float hs) {

        this();
        baseHeight = bh;
        hillStrength = hs;
    }

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {

        groundNoise = groundNoise(x, y, groundNoiseAmplitudeHills, simplex);


        float m = hillEffect.added(simplex, cell, x, y);

        return riverized(baseHeight, river) + (groundNoise + m) * river;
    }
}
