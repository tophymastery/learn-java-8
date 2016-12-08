import java.util.*;

class Engine {
	public Engine() {}
	protected Engine(Engine other) {}
		
	public Engine copy() { 
		return new Engine(this);	
	}
	
	public String toString() { return getClass().getName() + ": " + hashCode(); }
}

class TurboEngine extends Engine {
	public TurboEngine() {}
	public TurboEngine(TurboEngine other) { super(other); }
	public String toString() { return getClass().getName() + ": " + hashCode(); }
	public Engine copy() { 
		return new TurboEngine(this);	
	}
}

class PistonEngine extends Engine {
	public PistonEngine() {}
	public PistonEngine(PistonEngine other) { super(other); }
	public Engine copy() { 
		return new PistonEngine(this);	
	}
}

class Car {
	private int year;
	private Engine engine;
	
	public Car(int theYear, Engine theEngine) {
		year = theYear;
		engine = theEngine;
	}
	
	public Car(Car other) {
		year = other.year;
		engine = other.engine.copy();
	}
	
	
	public String toString() {
		return year + " - " + engine;
	}
}

public class Sample {
	public static void main(String[] args) {
		System.out.println("Start");
		
		Car car1 = new Car(2015, new PistonEngine());
		System.out.println(car1);
		
		Car car2 = new Car(car1);
		System.out.println(car2);
	}
}