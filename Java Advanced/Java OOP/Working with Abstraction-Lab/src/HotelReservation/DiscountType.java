package HotelReservation;

public enum DiscountType {
    VIP(20),SECONDVISIT(10),NONE(0);

    private int value;

    DiscountType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
