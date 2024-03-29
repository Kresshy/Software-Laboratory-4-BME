// Pályaépítés

Scene.buildScene() {
    // Pálya betöltése
    // Konfig alapján hangyák, bolyok, raktárak, sünök, akadályok létrehozása
}

// Tick delegálása és takarítás

Timer.tick() {
    game.getScene().delegateTick()
}

Scene.delegateTick() {
    for (Ant ant : ants)
        ant.handleTick();
    for (Storage storage : storages)
        storage.handleTick();
    for (Creature creature : creatures)
        creature.handleTick();
    for (Obstacle obstacle : obstacles)
        obstacle.handleTick();
    for (Effect effect : effects)
        effect.handleTick();
    // ...
    clearDebris();
}

Scene.clearDebris() {
    for (Obstacle obstacle : obstacles)
        if (obstacle.isDebris())
            // Eltávolítás
    for (Effect effect : effects)
        if (effect.isDebris())
            // Eltávolítás
}

// Hangya tick-kezelése

Ant.handleTick() {
    if (health <= 0)
        terminateAnt();
    if (poisoned)
        health -= 1;
    // ...
    routeAndMove();
    // ...
}

Ant.routeAndMove() {
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

// Méreg tick-kezelése
Poison.handleTick() {
    if (timeout > 0)
        timeout -= 1;
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
    if (source != null)
        source.putItems(cargo);
    // ...
    home.putItems(1);
    // ...
    // Eltávolítás a scene-ből
}

// Hangya megmérgezése

Ant.routeAndMove() {
    obstacles = scene.discoverObstacles()
    // ...
    for (Obstacle obstacle : obstacles)
        obstacle.interact(this);
}

Poison.interact() {
    creature.setPoisoned(true);
}

// Hangyalesővel való interakció

Ant.routeAndMove() {
    obstacles = scene.discoverObstacles()
    // ...
    for (Obstacle obstacle : obstacles)
        obstacle.interact(this);
}

AntSinker.interact() {
    creature.terminate();
}

// Hangyaírtó fújása

Scene.placeObstacle(Poison) // Vhogy jön a felhasználói interakció, létrehoz egy Poison-t és meghívja a függvényt

// Szagtalanító fújása

Scene.clearEffects(Point) // Vhogy jön a felhasználói interakció és meghívja a függvényt egy Pointtal

// Objektumok kirajzolása

ObjectDrawer.drawObjects(Graphics) {
    Scene scene = game.getScene();
    for (Ant ant : scene.getAnts())
        // Kirajzolás
    for (Storage storage : scene.getStorages())
        // Kirajzolás
    for (Creature creature : scene.getCreatures())
        // Kirajzolás
    for (Obstacle obstacle : scene.getObstacles())
        // Kirajzolás
    for (Effect effect : scene.getEffects())
        // Kirajzolás
}
