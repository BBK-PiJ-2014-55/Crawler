package Interfaces;

/**
 * Created by karolsudol on 21/04/15.
 */
public interface GetLocation {

    /**
     * receives address and returns location
     *
     * @param address
     *
     * @return Float[] {Latitude, Longitude}
     *
     */
    public Float[] getLongitudeLatitude (String address);

}
