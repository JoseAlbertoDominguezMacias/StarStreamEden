const gameData = {
    start: {
        text: "Tu nave es atacada por una flota enemiga en el sistema Cósmico. El escudo está fallando. ¿Qué harás?",
        imageLarge: "/images/ataque.jpg",
        choices: [
            { text: "Luchar contra la flota", next: "fightFleet", image: "/images/lucha.jpg" },
            { text: "Escapar hacia el agujero negro", next: "escapeHole", image: "/images/agujero-negro.png" }
        ]
    },
    fightFleet: {
        text: "Te enfrentas a la flota enemiga. Tu nave está siendo dañada, pero tienes un as bajo la manga.",
        imageLarge: "/images/batalla.jpg",
        choices: [
            { text: "Usar el arma secreta", next: "useWeapon", image: "/images/arma.png" },
            { text: "Pedir refuerzos", next: "callReinforcements", image: "/images/refuerzos.png" }
        ]
    },
    escapeHole: {
        text: "Decides huir y te diriges hacia un agujero negro. La nave comienza a ser absorbida por la gravedad.",
        imageLarge: "/images/agujero-negro.jpg",
        choices: [
            { text: "Activar el impulso", next: "activateImpulse", image: "/images/impulso.png" },
            { text: "Intentar estabilizar la nave", next: "stabilizeShip", image: "/images/estabilizar.jpg" }
        ]
    },
};
const missionName = "Misión : El Asedio del Sistema Cósmico";  