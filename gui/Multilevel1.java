
class Car
{ public Car()
{ System.out.println(“class Car”);
}
 public void vehicleType
{ System.out.println(“Vehicle type: car”);
}
Class Maruti extends Car
{ public Maruti()
{ System.out.println(“class Maruti”);
} 
public void brand()
{ System.out.println(“Brand: Maruti”);
} 
public void speed()
{ System.out.println(“Max:90kmph”);
}
}
public class Maruti800 extends Maruti
{ public Maruti800()
{ { System.out.println(“Maruti model:800”);
} 
public void speed()
{ System.out.println(“Max:800kmph”);
}
public static void main(String args[])
{ Maruti800 obj= new Maruti800();
obj.vehicleType();
obj.brand();
obj.speed();
}
}
