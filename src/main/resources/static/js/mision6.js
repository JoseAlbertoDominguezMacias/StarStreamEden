const gameData = {
    start: {
        text: "Tu nave ha aterrizado en un mundo gobernado por androides. No parecen ser hostiles, pero algo no anda bien. ¿Qué harás?",
        imageLarge: "/images/androides.jpg",
        choices: [
            { text: "Hablar con el líder de los androides", next: "androidLeader", image: "/images/lider.jpg" },
            { text: "Revisar el sistema de control", next: "controlSystem", image: "/images/sistema.jpg" }
        ]
    },
    androidLeader: {
        text: "El líder de los androides te mira con desconfianza, pero decide hablar contigo. Te ofrece una misión. ¿La aceptarás?",
        imageLarge: "/images/lider-android.jpg",
        choices: [
            { text: "Aceptar la misión", next: "acceptMission", image: "/images/mision.jpg" },
            { text: "Rechazar y huir", next: "runAway", image: "/images/huir.png" }
        ]
    },
    controlSystem: {
        text: "Accedes al sistema de control y descubres que hay un fallo crítico. Si no lo solucionas, los androides comenzarán a actuar de manera violenta.",
        imageLarge: "/images/error-sistema.jpg",
        choices: [
            { text: "Intentar arreglar el fallo", next: "fixError", image: "/images/arreglo.png" },
            { text: "Desconectar el sistema de inmediato", next: "disconnectSystem", image: "/images/desconectar.jpg" }
        ]
    },
};
const missionName = "Misión : La Rebelión de los Androides";