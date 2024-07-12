// index.js

// Limpiar el formulario
function cleanForm() {
document.getElementById("email").value = "";
};

// Función para mostrar mensajes
function messageForm(message, className = "alert-danger") {
const messageContainer = document.getElementById("mensajevista");
        const alertDiv = document.createElement("div");
        alertDiv.classList.add("alert", className);
        alertDiv.setAttribute("role", "alert");
        alertDiv.textContent = message;
        messageContainer.appendChild(alertDiv);
        cleanForm();
        setTimeout(() => {
        messageContainer.removeChild(alertDiv);
        }, 4000);
};


// Efecto de tipeo
        function textoTipeo(elementId, text, speed) {
        let index = 0;
                const element = document.getElementById(elementId);
                function type() {
                element.textContent += text[index];
                        index++;
                        if (index < text.length) {
                setTimeout(type, speed);
                } else {
                setTimeout(function () {
                index = 0;
                        element.textContent = "";
                        type();
                }, 2000);
                }
                }
        type();
        }

document.addEventListener("DOMContentLoaded", function () {
textoTipeo("textoTipeo", "Web Developer ", 200);
});
        fetch("https://dolarapi.com/v1/dolares/oficial")
        .then((response) => response.json())
        .then((data) => {
        const compra = data.compra;
                const venta = data.venta;
                const fecha = data.fecha;
                const compraElement = document.getElementById("compra");
                compraElement.textContent = `Valor de compra: $${compra}`;
                const ventaElement = document.getElementById("venta");
                ventaElement.textContent = `Valor de venta: $${venta}`;
                const currentDate = new Date();
                const fechaElemento = document.getElementById("fecha");
                const formattedDate = `${currentDate.getDate()}/${
                currentDate.getMonth() + 1
                }/${currentDate.getFullYear()}`;
                fechaElemento.textContent = `Fecha: ${formattedDate}`;
        })

        .catch((error) => {
        // Si la API falla
        console.error("Error al obtener el tipo de cambio:", error);
        });


