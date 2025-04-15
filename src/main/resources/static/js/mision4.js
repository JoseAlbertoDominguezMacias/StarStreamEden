const gameData = {
    start: {
        text: "Has abordado una nave aparentemente abandonada. El aire es frío y la luz parpadea. ¿Qué harás?",
        imageLarge: "/images/nave-fantasma.jpg",
        choices: [
            { text: "Explorar la sala de máquinas", next: "machineRoom", image: "/images/maquinas.jpg" },
            { text: "Revisar la cabina de control", next: "controlCabin", image: "/images/cabina.jpg" }
        ]
    },
    machineRoom: {
        text: "La sala de máquinas está cubierta de polvo, pero encuentras un extraño dispositivo encendido. Al tocarlo, una alarma suena.",
        imageLarge: "/images/alarma.jpg",
        choices: [
            { text: "Desconectar el dispositivo", next: "disarmDevice", image: "/images/dispositivo.png" },
            { text: "Escapar rápidamente", next: "escape", image: "/images/escapatoria.jpg" }
        ]
    },
    controlCabin: {
        text: "En la cabina de control, descubres que la nave está en piloto automático hacia un destino desconocido. ¿Lo detendrás?",
        imageLarge: "/images/piloto.jpg",
        choices: [
            { text: "Detener el piloto automático", next: "stopAutoPilot", image: "/images/control.jpg" },
            { text: "Dejar que siga su curso", next: "letItGo", image: "/images/espacio.png" }
        ]
    },

};
const missionName = "Misión : La Trampa de la Nave Fantasma";