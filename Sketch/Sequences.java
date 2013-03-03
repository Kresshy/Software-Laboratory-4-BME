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

Ant.handleTick() {
    if (health <= 0)
        terminateAnt();
    if (poisoned)
        health -= 1;
    // ...
    scene.getStorages();
    // ...
    scene.discoverEffects(getPosition());
    // ...
    scene.discoverObstacles(getPosition());
    // ...
    setPosition(Point);
    scene.placeEffect(Point, Pheromone);
    // ...
}


// Hangyászsün tick-kezelése

AntEater.handleTick() {
    if (visible) {
        // Előtérben
        ants = scene.getAnts()
        // ...
        // Ha van ennivaló hangya és éhes
        if (hunger > 0) {
            for (Ant ant : ants) {
                if (pointInRange(ant.getPosition())) {
                    ant.terminate();
                    hunger -= 1;
                }
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

// Hangyaboly tick-kezelése

AntHill.handleTick() {
    if (amount < capacity) {
        // Hangya létrehozása
        amount += 1;
    }
}

// Effekt tick-kezelése

Effect.handleTick() {
    if (timeout > 0)
        timeout -= 1;
}

// Hangya ételfelvétele

{
    cargo = FoodStorage.getItems();
    // ...
    setSource(FoodStorage);
}

// Hangya halála

Ant.terminate() {
    source.putItems(cargo);
    // ...
    home.putItems(1);
    // ...
    // Eltávolítás a scene-ből
}


