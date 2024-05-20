// Practice 1
// Abstract classes


// Task 1
// Create an abstract Engine class. Create a Ferrari Engine class that inherits from the Engine class. 
// Create a RenaultEnigine Engine class that inherits from the Engine class.
// In the Main Main class, create 5 objects of the Ferrari Engine and Renault Megane class each with different values.
// Add everything to the array of the Engine class.
// Output the maximum speeds of each object.

public class Main {
    public static void main(String[] args) {
        Engine[] Engine = new Engine[10];
        Engine[0] = new FerrariEngine(10.2,2,3.1);
        Engine[1] = new FerrariEngine(10.4,3,3.2);
        Engine[2] = new FerrariEngine(10.5,4,3.3);
        Engine[3] = new FerrariEngine(10.52,5,3.4);
        Engine[4] = new FerrariEngine(10.45,6,3.5);
        Engine[5] = new RenaultEnigine(7.1,2,2.1,1.1);
        Engine[6] = new RenaultEnigine(7.2,3,2.2,1.2);
        Engine[7] = new RenaultEnigine(7.3,4,2.3,1.3);
        Engine[8] = new RenaultEnigine(7.4,5,2.4,1.4);
        Engine[9] = new RenaultEnigine(7.5,6,2.5,1.5);
        int k=1;
        for(int i=0;i<10;i++){
            System.out.printf("Car " + k + " max speed: %.2f km/h%n", Engine[i].getMaxSpeed());
            k++;
        }
    }
}


public abstract class Engine {
    double engineVolume;
    int cylinderAmount;
    double engineWeight;

    public Engine(double engineVolume, int cylinderAmount, double engineWeight) {
        this.engineVolume = engineVolume;
        this.cylinderAmount = cylinderAmount;
        this.engineWeight = engineWeight;
    }
    public double getEngineVolume() {
        return engineVolume;
    }
    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }
    public int getCylinderAmount() {
        return cylinderAmount;
    }
    public void setCylinderAmount(int cylinderAmount) {
        this.cylinderAmount = cylinderAmount;
    }
    public double getEngineWeight() {
        return engineWeight;
    }
    public void setEngineWeight(double engineWeight) {
        this.engineWeight = engineWeight;
    }
    public abstract double efficiency();
    public abstract double throttleEnergy();
    public abstract double breakEnergy();
    public double getMaxSpeed() {
        return (throttleEnergy() - breakEnergy()) * efficiency();
    }
}


public class FerrariEngine extends Engine{


    public FerrariEngine(double engineVolume, int cylinderAmount, double engineWeight) {
        super(engineVolume, cylinderAmount, engineWeight);
    }

    public double efficiency(){
        return 0.25;
    }
    public double throttleEnergy(){
        return engineVolume*cylinderAmount*100;
    }
    public double breakEnergy(){
        return engineWeight*2;
    }

}


public class RenaultEnigine extends Engine {
    double extraTurboEnergy;
    public RenaultEnigine(double engineVolume, int cylinderAmount, double engineWeight, double extraTurboEnergy) {
        super(engineVolume, cylinderAmount, engineWeight);
        this.extraTurboEnergy = extraTurboEnergy;
    }
    public double getExtraTurboEnergy() {
        return extraTurboEnergy;
    }
    public void setExtraTurboEnergy(double extraTurboEnergy) {
        this.extraTurboEnergy = extraTurboEnergy;
    }
    public double efficiency() {
        return 0.27;
    }
    public double throttleEnergy() {
        return engineVolume*cylinderAmount*110 + extraTurboEnergy;
    }
    public double breakEnergy() {
        return engineWeight*2.1;
    }
}
