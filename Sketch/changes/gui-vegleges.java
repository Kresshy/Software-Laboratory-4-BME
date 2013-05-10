// Grafikus objektumok interfésze
public interface GraphicsObject {

    public void paintObject(Graphics graphics);

}


// BaseObject leszármazottak közös grafikus őse
public abstract class GraphicsBase<T extends BaseObject> implements GraphicsObject {

    protected T wrappedObject;

    public GraphicsBase(T wrappedObject);

    public T getWrappedObject();
    public void setWrappedObject(T wrappedObject);

}

// Egyes BaseObject leszármazottak grafikus osztálya
public class GAnt extends GraphicsBase<Ant> {

    public GAnt(Ant wrappedObject) {
        super(wrappedObject);
    }

    @Override
    public void paintObject(Graphics graphics) {
        // ...
    }

}

public class GAntEater extends GraphicsBase<AntEater> {

    public GAntEater(AntEater wrappedObject) {
        super(wrappedObject);
    }

    @Override
    public void paintObject(Graphics graphics) {
        // ...
    }

}

// Stb...

// Effektek grafikus gyűjtősztálya (az Effect nem BaseObject leszármazott!)
public GEffects implements GraphicsObject {

    protected Map<Point, Effect> wrappedObjects;

    @Override
    public void paintObject(Graphics graphics) {
        // ...
    }

}
