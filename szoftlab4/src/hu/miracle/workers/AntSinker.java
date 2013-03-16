package hu.miracle.workers;

public class AntSinker extends Obstacle {

	// Ezzel hogyan nyírjuk ki a hangyát ha belelép? Kéne referencia az összes
	// hangyára ami közül meg tudjuk keresni azt amelyik belelépett ebbe
	@Override
	public void interact(Creature creature) {
		System.out.println(getClass().getCanonicalName() + ".interact()");
	}
}
