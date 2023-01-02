
public class Pixel implements Comparable<Pixel>{

    /* ATTRIBUTES */
    public int intensity = 0, count = 1, cummulativeGreater = 0, adjustedIntensity = 0;
    
    /* CONSTRUCTORS */
    public Pixel(){};
    public Pixel(int intensity){
        this.intensity = intensity;
    };

    /* METHODS */
    @Override
    public int compareTo(Pixel o){
        return this.intensity - o.intensity;
    };
};