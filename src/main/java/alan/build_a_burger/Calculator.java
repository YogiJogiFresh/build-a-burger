package alan.build_a_burger;

/**
 * Created by Alan Kai on 2/9/2016.
 */
public class Calculator {
    double totalPrice = 0;
    double totalCalories = 0;



    public void calculateTotal(double a, double b, double c, double x, double y, double z, double u) {
        totalPrice = x + y + z;
        totalCalories = a + b + c;
        totalPrice = totalPrice * u;
        totalCalories = totalCalories * u;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public double getTotalCalories() {
        return totalCalories;
    }
    public String toString() {
        return "Total Price: " + totalPrice +"\nNumber of Calories: " + totalCalories;
    }
}
