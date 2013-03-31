package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "creature")
@XmlSeeAlso({ Ant.class })
public abstract class Creature extends BaseObject {

	protected Scene scene;

	public Creature() {

	}

	public Creature(Point position, Color color, int radius, Scene scene) {
		super(position, color, radius);
		this.scene = scene;
	}

	@XmlTransient()
	public void setScene(Scene scene) {
		CallLogger.getLogger().entering(this, "setScene");

		// Pálya beállítása
		this.scene = scene;

		CallLogger.getLogger().exiting();
	}

	public void terminate() {
		CallLogger.getLogger().entering(this, "terminate");

		// Dummy default implementáció

		CallLogger.getLogger().exiting();
	}

}
