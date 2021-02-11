package CoolingDevices;

/**
 *
 * @author bobgi
 */
public class FanTest extends Fan{
    static Fan myFan = new AirmasterFan();  //class.field
    static AirmasterFan yourFan = new AirmasterFan();
    static AirmasterFan thirdFan = new AirmasterFan();

    public static void main(String[] args)  {
        myFan.setRadius(4);
        System.out.println(myFan);
        System.out.println(yourFan);
        System.out.println(thirdFan);
    }
}
