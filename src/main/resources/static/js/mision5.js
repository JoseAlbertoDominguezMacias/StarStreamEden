const gameData = {
    start: {
        text: "Tras aterrizar en un planeta desconocido, descubres que algo extraño está ocurriendo. ¿Qué harás?",
        imageLarge: "/images/planeta.jpg",
        choices: [
            { text: "Investigar el campo de energía", next: "energyField", image: "/images/energia.png" },
            { text: "Buscar una ciudad cercana", next: "citySearch", image: "/images/ciudad.jpg" }
        ]
    },
    energyField: {
        text: "Te acercas al campo de energía y sientes una vibración extraña. ¿Qué harás ahora?",
        imageLarge: "/images/campo-energia.jpg",
        choices: [
            { text: "Entrar en el campo", next: "enterField", image: "/images/campo.jpg" },
            { text: "Retroceder y buscar otra pista", next: "retreat", image: "/images/retroceso.png" }
        ]
    },
    citySearch: {
        text: "La ciudad parece vacía, pero al llegar a la plaza central, escuchas unos pasos. ¿Te acercas o te escondes?",
        imageLarge: "/images/plaza.jpg",
        choices: [
            { text: "Acercarte sigilosamente", next: "sneakUp", image: "/images/silencio.jpg" },
            { text: "Ocultarte rápidamente", next: "hide", image: "/images/esconder.png" }
        ]
    },
};
const missionName = "Misión : El Asalto del Planeta Perdido";