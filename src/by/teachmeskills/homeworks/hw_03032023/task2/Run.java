package by.teachmeskills.homeworks.hw_03032023.task2;

public class Run {
    public static void main(String[] args) {
        Transport car = new PassengerTransport(400, 180, 2000, 4, 9, 4, PassengerTransport.carType.SEDAN, Transport.Type.BMW);
        Transport airplainCitizen = new CitizenTransport(1000, 500, 10000, 2, 100, 300, false, Transport.Type.AIRBUS);
        Transport militaryTransport = new MilitaryTransport(1300, 600, 15000, 2, 100, false, 6, Transport.Type.BOING);
        Transport truck = new TruckTransport(500, 180, 4000, 6, 15, 4000, Transport.Type.AUDI);
        Transport[] arrayTransport = {car, airplainCitizen, militaryTransport, truck};
        for (int i = 0; i < arrayTransport.length; ++i) {
            arrayTransport[i].printAll();
        }
        ((PassengerTransport) car).howLongDrivePrint(100);
        ((CitizenTransport) airplainCitizen).checkForCapacity(500);
        ((MilitaryTransport) militaryTransport).checkForCatapultSystem();
        ((MilitaryTransport) militaryTransport).checkForShoot();
        ((TruckTransport) truck).checkForCapacity(1000);
    }
}
