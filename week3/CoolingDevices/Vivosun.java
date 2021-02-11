package CoolingDevices;

class Vivosun extends Fan{

    private boolean isInLine;
    private double airFlow;

    Vivosun(){
        super();
        setInLine(this.isInLine);
        setAirFlow(this.airFlow);
    }

    public void setInLine(boolean isInLine){
        this.isInLine = isInLine;
    }

    public boolean getInLine(){
        return this.isInLine;
    }

    public void setAirFlow(double airFlow){
        this.airFlow = airFlow;
    }

    public double getAirFlow(){
        return airFlow;
    }

    @Override
    public String powerSource() {
        return "Cord";
    }
}
