package CoolingDevices;

/**
 *
 * @author CSC161-601
 */

public abstract class Fan {
//    enum Speeds {
//        SLOW,
//        MEDIUM,
//        FAST;
//    }

    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    private String serialNumber;    //serialNumber or modelNumber??
    private int speed;
    private boolean isOn = false;
    private double radius = 5;
    private String color = "Blue";

    //Constructors
    protected Fan(){
        radius = 10;
        isOn = false;
        speed = 1;
    }

    protected Fan(int newSpeed, boolean newOn, double newRadius, String newColor)
    {
        speed = newSpeed;
        isOn = newOn;
        radius = newRadius;
        color = newColor;
    }

//    Fan(Speeds s){
//        this.f = s;
//        isOn = true;
//    }

    /**
     * @return a boolean describing whether or not the fan is on
     */
    public boolean isOn()
    {
        return this.isOn;
    } //end isOn()

    /*
     * sets the boolean for if the fan is on
     */
    public void setFanSetting(boolean newOnSetting)
    {
        isOn =  newOnSetting;
    } //end setFanSetting()

    /*
     * Set radius for fan
     */
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    } //ZL
    //Don’t allow negative values


    /*
     * @return the radius of the current fan
     */
    public double getRadius()
    {
        return this.radius;
    } //dB

    /*
     * method accessor to set the color of the fan
     */
    public void setColor(String newColor)
    {
        this.color = newColor;
    } //end setColor()

    /**
     * @return the current speed of the fan
     */
    public int getSpeed()
    {
        return speed;
    } //end getSpeed()

    /*
     * @return the correct speed in a String output of the current fan
     */
    public String getSpeedString(int i)
    {
        switch(i){
            case SLOW:
                return "Slow";
            case MEDIUM:
                return "Medium";
            case FAST:
                return "Fast";
            default:
                return "The fan speed is not set";
        }
    } //end getSpeedString()

    /**
     * @return the color of the fan
     */
    public String getColor()
    {
        return this.color;
    } //end getColor()

    @Override
// there are no other toString()- is @Override necessary? Yes toString comes //from object and will just return a memory location unless you Override it
//The override is because we have to override the default java toString
    public String toString() {
        if(isOn == true)
        {
            return "CoolingDevices.Fan speed: " + getSpeedString(speed) +
                    "\tCoolingDevices.Fan color: " + getColor() +
                    "\tCoolingDevices.Fan radius: " + getRadius();
        }
        else{
            return "CoolingDevices.Fan color: " + getColor() +
                    "\tCoolingDevices.Fan radius: " + getRadius() +
                    "\tThe fan is off";
        }
    } //end toString

    public abstract String powerSource();

} //end classFan
