const gameData = {
    start: {
        text: "Un portal estelar aparece en tu camino mientras viajas por el espacio profundo. Decides investigarlo. ¿Qué harás?",
        imageLarge: "/images/portal.jpg",
        choices: [
            { text: "Entrar en el portal", next: "enterPortal", image: "/images/portal-abierto.jpg" },
            { text: "Esperar y observar el portal", next: "waitAndObserve", image: "/images/esperar.png" }
        ]
    },
    enterPortal: {
        text: "Al atravesar el portal, eres transportado a una galaxia lejana. Las estrellas parecen moverse de manera extraña.",
        imageLarge: "/images/galaxia.jpg",
        choices: [
            { text: "Explorar la galaxia", next: "exploreGalaxy", image: "/images/estrella.jpg" },
            { text: "Volver al portal", next: "returnPortal", image: "/images/volver.png" }
        ]
    },
    waitAndObserve: {
        text: "Al observar el portal durante unos minutos, notas un patrón de distorsión en el espacio-tiempo.",
        imageLarge: "/images/distorsion.jpg",
        choices: [
            { text: "Atravesar el portal", next: "enterPortal", image: "/images/portal-abierto.jpg" },
            { text: "Regresar a tu nave", next: "returnShip", image: "/images/nave.jpg" }
        ]
    },
};
const missionName = "Misión : La Rebelión de los Androides";