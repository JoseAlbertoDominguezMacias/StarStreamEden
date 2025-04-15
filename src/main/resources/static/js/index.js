document.getElementById('actionButton').addEventListener('click', function() {
    document.getElementById('message').innerText = "¡Prepárate para un viaje estelar!";
});

document.addEventListener("DOMContentLoaded", function () {
    const userIcon = document.getElementById("userIcon");
    const userModal = document.getElementById("userModal");

    userIcon.addEventListener("mouseenter", function () {
        userModal.style.display = "block";
    });

    userIcon.addEventListener("mouseleave", function () {
        userModal.style.display = "none";
    });
});

