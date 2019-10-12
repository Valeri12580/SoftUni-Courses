package parkingSystem;


import org.junit.Assert;
import org.junit.Test;

public class SoftParkTest {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS SoftPark
    @Test
    public void validateConstructorImplementation() {
                SoftPark park=new SoftPark();
        Assert.assertEquals(12,park.getParking().size());
    }
    @Test(expected = UnsupportedOperationException.class)
    public void validateGetParkingMethodShouldThrowExceptionIfChanged() {
        SoftPark park=new SoftPark();
        park.getParking().remove("A1");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfThrowExceptionIfThereIsNoSpot() {
        SoftPark park=new SoftPark();
        park.parkCar("dsada",new Car("bvw","dsad"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfAlreadyTakenSpot() {
        SoftPark park=new SoftPark();
        park.parkCar("A1",new Car("dsa","dasds"));
        park.parkCar("A1",new Car("dsadsasda","dsdadasds"));
    }
    @Test(expected = IllegalStateException.class)
    public void testIfCarIsAlreadyInTheParking() {
        SoftPark park=new SoftPark();
        park.parkCar("A1",new Car("dsa","dasds"));
        park.parkCar("A2",new Car("dsa","dasds"));

    }
    @Test()
    public void testIfAddMethodWorkCorrect() {
        SoftPark park=new SoftPark();
        park.parkCar("A1", new Car("Audi", "0069"));
        Assert.assertEquals("0069",park.getParking().get("A1").getRegistrationNumber());




    }
    public void testMessageIfAddMethodWorkCorrect() {
        SoftPark park = new SoftPark();
        String result = park.parkCar("A1", new Car("Audi", "0069"));


        Assert.assertEquals("Car:0069 parked successfully!", result);
    }
        @Test(expected = IllegalArgumentException.class)
    public void CheckIfThrowExceptionIfCarDoesntExitInThatSpot(){
        SoftPark park=new SoftPark();
        park.parkCar("A1",new Car("dsa","dasds"));
        park.removeCar("A1",new Car("sdasd","dsad"));
    }


}