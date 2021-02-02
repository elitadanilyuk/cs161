public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    Fan(){
        this.speed = 0;
        this.on = false;
        this.radius = 5;
        this.color = "Blue";
    }

    Fan(int speed, double radius, String color){
        this.speed = speed;
        if(speed > 0)
            on = true;
        else
            on = false;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String toString() {
        String result;
        if (on == true) {
            result = "Fan speed: " + speed +
                    "\tFan color: " + color +
                    "\tFan radius: " + radius;
        } else {
            result = "Fan color: " + color +
                    "\tFan radius: " + radius +
                    "\tThe fan is off";
        }
        return result;
    }
} //end class Fan

// inheritance  - "is-a"    ie. my airmaster fan is-a Fan