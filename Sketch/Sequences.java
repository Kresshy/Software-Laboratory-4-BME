// Pályaépítés

Scene.buildScene() {
    // Pálya betöltése
    // Konfig alapján hangyák, bolyok, raktárak, sünök, akadályok létrehozása
}


// Tick delegálása

Timer.tick() {
    game.getScene().delegateTick()
}

Scene.delegateTick() {
    for (Ant ant : ants)
        ant.tick();
    for (Storage storage : storages)
        storage.tick();
    for (Creature creature : creatures)
        creature.tick();
    for (Effect effect : effects)
        effect.tick();
}

// Hangya tick-kezelése

Ant.tick() {
    if (health <= 0)
        terminateAnt();
    if (poisoned)
        health -= 1;
    // ...
    scene.getStorages();
    // ...
    scene.discoveryNeighborhood(position);
    // ...
    scene.checkForObstacles();
    // ...
    position = newposition;
    scene.placeEffect(newpheromone)
    // ...
}


// Hangyászsün tick-kezelése

AntEater.tick() {
    if (visible) {
        // Előtérben
        scene.getAnts()
        // ...
        // Ha van ennivaló hangya és éhes
        if (hunger > 0) {
            ant.terminateAnt();
            hunger -= 1;
        }
    } else {
        // Háttérben
        if (wait > 0)
            wait -= 1;
        else {
            // Belépési pont meghatározása
            // Megjelenés
        }
    }
}
