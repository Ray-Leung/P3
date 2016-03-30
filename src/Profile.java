/**
 * Created by Administrator on 2015/11/13.
 */
public class Profile {
    public String aperture;
    public String value1;

    public Profile(String aperture, String value1) {
        this.aperture = aperture;
        this.value1 = value1;
    }
    public String getAperture() {return this.aperture;}
    public String getValue1() {return this.value1;}

    /**
     * Return a string of profile.
     * @return a string of profile
     */
    public String toString() {
        return this.value1 + " " + aperture;
    }

    /**
     * Return a string in output form of profile.
     * @return a string in output form of profile.
     */
    public String toOutput() {
        return this.aperture + "," + this.value1 + "\n";
    }
}
