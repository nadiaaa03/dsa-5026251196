public abstract class WashService implements Billable {

    private String id;
    private int days;
    private int units;

    protected WashService(String id, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.days = days;
        this.units = 1;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    public int calculateCharge(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException();
        }

        this.units = units;
        return units * calculateCharge();
    }

    protected int getUnits() {
        return units;
    }

    @Override
    public abstract int calculateCharge();

    public String label() {
        return "Service";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
