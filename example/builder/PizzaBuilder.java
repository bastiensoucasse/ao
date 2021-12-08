package builder;

public class PizzaBuilder {
    private Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createPizza() {
        pizza = new Pizza();
    }

    public void setDough(final String dough) {
        pizza.setDough(dough);
    }

    public void setBase(final String base) {
        pizza.setBase(base);
    }

    public void setTopping(final String topping) {
        pizza.setTopping(topping);
    }
}
