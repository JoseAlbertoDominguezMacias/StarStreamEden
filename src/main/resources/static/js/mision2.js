const gameData = {
    start: {
        text: "Te encuentras en un planeta desconocido. ¿Qué haces?",
        imageLarge: "/images/planeta-desconocido.jpg",
        choices: [
            { text: "Investigar la vegetación", next: "explorePlantLife", image: "/images/vegetacion.png" },
            { text: "Buscar recursos", next: "findResources", image: "/images/recursos.png" }
        ]
    },
    explorePlantLife: {
        text: "Exploras la vegetación y encuentras algo extraño. ¿Te acercas?",
        imageLarge: "/images/vegetacion-extrana.jpg",
        choices: [
            { text: "Acercarse", next: "alienLifeForm", image: "/images/alien.png" },
            { text: "Regresar", next: "start", image: "/images/volver.png" }
        ]
    },
    findResources: {
        text: "Encuentras una mina de recursos, pero está custodiada por criaturas. ¿Qué haces?",
        imageLarge: "/images/mina.jpg",
        choices: [
            { text: "Atacar a las criaturas", next: "fightCreatures", image: "/images/atacar.png" },
            { text: "Esperar y observar", next: "observeCreatures", image: "/images/observar.png" }
        ]
    },
    alienLifeForm: {
        text: "Te acercas a la extraña forma de vida alienígena. Se muestra amigable. ¿Hablas con ella?",
        imageLarge: "/images/alien.jpg",
        choices: [
            { text: "Hablar", next: "communicateWithAlien", image: "/images/hablar.png" },
            { text: "Ignorar y continuar explorando", next: "explorePlanet", image: "/images/explorar.png" }
        ]
    },
    communicateWithAlien: {
        text: "El alienígena parece comprenderte y te ofrece una nave para escapar del planeta. ¿La tomas?",
        imageLarge: "/images/nave-alien.jpg",
        choices: [
            { text: "Aceptar la nave", next: "alienShipEscape", image: "/images/nave.png" },
            { text: "Rechazar la nave", next: "stayPlanet", image: "/images/quedarse.jpg" }
        ]
    },
    fightCreatures: {
        text: "Te enfrentas a las criaturas, pero son más fuertes de lo que pensabas. ¿Qué haces?",
        imageLarge: "/images/creaturas.jpg",
        choices: [
            { text: "Usar una granada", next: "useGrenade", image: "/images/granada.png" },
            { text: "Retirarte y buscar otra solución", next: "findAlternative", image: "/images/retirarse.png" }
        ]
    },
    stayPlanet: {
        text: "Decides quedarte en el planeta, pero pronto la atmósfera comienza a volverse peligrosa. ¿Qué haces?",
        imageLarge: "/images/planeta-destrozado.jpg",
        choices: [
            { text: "Construir un refugio", next: "buildShelter", image: "/images/refugio.png" },
            { text: "Salir del planeta", next: "alienShipEscape", image: "/images/salir.png" }
        ]
    }
};
const missionName = "Misión : Un Mar de Oscuridad";