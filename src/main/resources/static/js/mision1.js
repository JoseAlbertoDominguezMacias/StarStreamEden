	const gameData = {
	    start: {
	        text: "Te despiertas en una nave espacial en medio del vacío cósmico. Al observar a tu alrededor, ves dos rutas: una hacia la estación de comunicación y otra hacia la sala de control. ¿Qué haces?",
	        imageLarge: "/images/nave-espacial.jpg", // Imagen de la nave espacial
	        choices: [
	            { text: "Dirigirse a la estación de comunicación", next: "communicationStation", image: "/images/comunicacion.jpg" },
	            { text: "Ir a la sala de control", next: "controlRoom", image: "/images/control.jpg" }
	        ]
	    },
	    communicationStation: {
	        text: "Llegas a la estación de comunicación, pero está en silencio. El sistema muestra una señal de socorro. ¿Te atreves a responderla?",
	        imageLarge: "/images/estacion-comunicacion.jpg", // Imagen de estación de comunicación
	        choices: [
	            { text: "Responde a la señal de socorro", next: "rescueMission", image: "/images/socorro.png" },
	            { text: "Ignorar la señal y regresar", next: "start", image: "/images/volver.png" }
	        ]
	    },
	    controlRoom: {
	        text: "En la sala de control, encuentras que algo está mal. Las luces parpadean y el sistema de navegación está fallando. ¿Qué haces?",
	        imageLarge: "/images/sala-control.jpg", // Imagen de la sala de control
	        choices: [
	            { text: "Reparar el sistema de navegación", next: "repairNavigation", image: "/images/reparar.png" },
	            { text: "Verificar los sensores de emergencia", next: "checkSensors", image: "/images/sensores.png" }
	        ]
	    },
	    rescueMission: {
	        text: "Respondes a la señal de socorro y te diriges a un planeta desconocido. Al aterrizar, te encuentras con una nave alienígena. ¿Qué haces?",
	        imageLarge: "/images/nave-alienigena.jpg", // Imagen de nave alienígena
	        choices: [
	            { text: "Investigar la nave alienígena", next: "alienShip", image: "/images/investigar.png" },
	            { text: "Volver a la nave", next: "start", image: "/images/volver.png" }
	        ]
	    },
	    repairNavigation: {
	        text: "Logras reparar el sistema de navegación, pero detectas una anomalía en el espacio-tiempo. ¿Te atreves a investigarla?",
	        imageLarge: "/images/anomalia.jpg", // Imagen de anomalía en el espacio
	        choices: [
	            { text: "Investigar la anomalía", next: "investigateAnomaly", image: "/images/anomalia-investigar.png" },
	            { text: "Ignorarla y continuar el viaje", next: "continueJourney", image: "/images/continuar.png" }
	        ]
	    },
	    alienShip: {
	        text: "Al investigar la nave alienígena, descubres un artefacto que podría cambiar la historia de la humanidad. ¿Lo llevas contigo?",
	        imageLarge: "/images/artefacto.jpg", // Imagen del artefacto alienígena
	        choices: [
	            { text: "Llevar el artefacto", next: "artifactStolen", image: "/images/artefacto-llevar.jpg" },
	            { text: "Dejar el artefacto y salir de la nave", next: "leaveAlienShip", image: "/images/salir.png" }
	        ]
	    },
	    checkSensors: {
	        text: "Verificas los sensores de emergencia y detectas una flota de naves enemigas acercándose. ¿Qué haces?",
	        imageLarge: "/images/flota-enemiga.jpg", // Imagen de la flota enemiga
	        choices: [
	            { text: "Activar el escudo de defensa", next: "activateShields", image: "/images/escudo.png" },
	            { text: "Prepararse para un enfrentamiento", next: "prepareBattle", image: "/images/batalla.png" }
	        ]
	    },
	    continueJourney: {
	        text: "Decides ignorar la anomalía y continuar con el viaje, pero pronto te das cuenta de que algo no está bien. La nave comienza a perder energía.",
	        imageLarge: "/images/nave-destrozada.jpg", // Imagen de la nave en mal estado
	        choices: [
	            { text: "Reparar la nave", next: "repairShip", image: "/images/reparar-nave.jpg" },
	            { text: "Desembarcar y explorar el planeta", next: "explorePlanet", image: "/images/planeta.png" }
	        ]
	    },
	    artifactStolen: {
	        text: "Al llevar el artefacto, una alerta suena. La nave alienígena comienza a autodestruirse. ¿Cómo escapas?",
	        imageLarge: "/images/nave-destrozada.jpg", // Imagen de la nave alienígena autodestruyéndose
	        choices: [
	            { text: "Escapar en una cápsula de escape", next: "escapePod", image: "/images/capsula.png" },
	            { text: "Luchar contra los alienígenas", next: "fightAliens", image: "/images/luchar-alien.png" }
	        ]
	    }
	};
	const missionName = "Misión : Un Problema Estelar";