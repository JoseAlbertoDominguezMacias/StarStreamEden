const gameData = {
    start: {
        text: "Te despiertas en un planeta helado. ¿Cómo reaccionas?",
        imageLarge: "/images/planeta-helado.jpg",
        choices: [
            { text: "Buscar refugio", next: "findShelter", image: "/images/refugio.png" },
            { text: "Explorar el área", next: "exploreArea", image: "/images/explorar.png" }
        ]
    },
    findShelter: {
        text: "Encuentras una cueva, pero dentro hay criaturas. ¿Qué haces?",
        imageLarge: "/images/cueva.jpg",
        choices: [
            { text: "Atacar a las criaturas", next: "fightCreatures", image: "/images/atacar.png" },
            { text: "Intentar negociar con ellas", next: "negotiateCreatures", image: "/images/negociar.png" }
        ]
    },
    exploreArea: {
        text: "Exploras la superficie del planeta y encuentras una base abandonada. ¿Entresas?",
        imageLarge: "/images/base-abandonada.jpg",
        choices: [
            { text: "Entrar en la base", next: "enterBase", image: "/images/entrar.png" },
            { text: "Buscar más recursos", next: "findResources", image: "/images/recursos.png" }
        ]
    },
    enterBase: {
        text: "Dentro de la base, encuentras un mapa antiguo de planetas cercanos. ¿Te lo llevas?",
        imageLarge: "/images/mapa.jpg",
        choices: [
            { text: "Tomar el mapa", next: "takeMap", image: "/images/mapa.png" },
            { text: "Dejar el mapa y salir", next: "leaveBase", image: "/images/salir.png" }
        ]
    },
    negotiateCreatures: {
        text: "Las criaturas te escuchan y te permiten descansar en su cueva. ¿Qué haces a continuación?",
        imageLarge: "/images/criaturas.jpg",
        choices: [
            { text: "Alimentarte", next: "eatWithCreatures", image: "/images/comer.png" },
            { text: "Salir y continuar explorando", next: "explorePlanet", image: "/images/explorar.png" }
        ]
    }
};
const missionName = "Misión : El Planeta Helado";