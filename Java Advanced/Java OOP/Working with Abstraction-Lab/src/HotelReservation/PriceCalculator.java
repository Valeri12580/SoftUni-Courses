package HotelReservation;

public class PriceCalculator {
    double pricePerDay;
    int numberOfDays;
    int season;
    int discount;

    public PriceCalculator(double pricePerDay, int numberOfDays, String season, String discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = Season.valueOf(season).getValue();
        this.discount = DiscountType.valueOf(discount).getValue();
    }

    public  void printTotalSum(){
        double pricesWithoutDiscounts=pricePerDay*numberOfDays*season;
        double finalSum=pricesWithoutDiscounts-(pricesWithoutDiscounts*discount/100);

        System.out.printf("%.2f",finalSum);
    }
}
