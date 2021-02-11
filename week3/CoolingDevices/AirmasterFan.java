package CoolingDevices;
// import CoolingDevices.Fan; unnecessary, but optional and works

/**
 *
 * @author bobgi
 */
class AirmasterFan extends Fan{
    private boolean hasStand;
    private double standRadius;
    private double standHeight;
    private boolean oscillating;
    private double horsePower;

    //Constructors

//    AirmasterFan(int s)
//    {
//        super();    //keyword for invoking superclass constructor -Amanda
//    }

    AirmasterFan()
    {
        super();

        hasStand = true;
        setStandRadius(2.0);
        setStandHeight(5.0);
        oscillating = false;
        setHorsePower(10.0);
    }

    AirmasterFan(int newSpeed, boolean newOn, double newRadius, String newColor, boolean newHasStand, double newStandRadius, double newStandHeight, boolean newOscillating, double newHorsePower)
    {

        super(newSpeed, newOn, newRadius, newColor);
        hasStand = newHasStand;
        setStandRadius(newRadius);
        setStandHeight(newStandHeight);
        oscillating = newOscillating;
        setHorsePower(newHorsePower);
    }



    //AirmasterFan Methods

    /**
     * sets the boolean for if the current fan has a stand
     */
    public void setHasStand(boolean newStandValue)
    {
        this.hasStand = newStandValue;
    } //end setHasStand()

    /**
     * @return true if the fan has a stand, false otherwise
     */
    public boolean getHasStand(){
        return this.hasStand;
    } //end getHasStand()

    /**
     *@return The stand height
     */
    public double getStandHeight()
    {
        return this.standHeight;
    } //RO

    /**
     * Sets the height of the stand
     * @param standHeight which height to set the stand to
     */
    public void setStandHeight(double standHeight)
    {
        if (standHeight > 0)
            this.standHeight = standHeight;
        else
            this.standHeight = 0;
    } //RO


    /**
     * Sets the oscillating status of the fan
     * @param oscillating true to designate the fan an oscillating fan, false otherwise
     */
    public void setOscillating(boolean oscillating)
    {
        this.oscillating = oscillating;
    } //RO

    /**
     *@return True if the fan is oscillating
     */
    public boolean isOscillating()
    {
        return this.oscillating;
    } //RO

    /*
     * @return gets the stand radius for the current fan
     */
    public double getStandRadius(){
        return this.standRadius;
    } //end getStandRadius()

    /*
     * sets the radius for the current fan
     */
    public void setStandRadius(double standRadius){
        this.standRadius = standRadius;
    } //end setStandRadius

    /*
     * sets the HP for the current fan
     * @param newHorsePower
     */
    public void setHorsePower(double newHorsePower){
        if( newHorsePower > 0)
            this.horsePower = newHorsePower;
        else
            this.horsePower = 0;
    } //end setHorsePower()

    /**
     * @return the horsepower of the fan
     */
    public double getHorsePower() {
        return this.horsePower;
    } //end getHorsePower()

    //Should we use getters to populate these? For future validation?
//I don’t see why not?
//Need to change %. %f for double, right?
    @Override
    public String toString(){
        return String.format("Speed: %f On: %b Radius: %f Color: %f Stand: %b Stand Radius: %f " +
                "Stand Height: %f Oscillating: %b Horsepower: %f",
                this.getSpeed(), this.isOn(), this.getRadius(), this.getColor(), this.getHasStand(),
                this.getStandRadius(), this.getStandHeight(), this.isOscillating(), this.getHorsePower() );
    }


} //end class CoolingDevices.AirmasterFan