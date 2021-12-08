package prototype;

public class ConcreteProtoype extends Prototype {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (ConcreteProtoype) super.clone();
    }
}
