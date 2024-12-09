const diagram = document.getElementById("diagram");
const image = diagram.getBoundingClientRect();
const x_center = image.left + image.width * 0.5;
const y_center = image.top + image.height * 0.5;

diagram.addEventListener('click', async ({clientX, clientY}) => {
    let r_result = $('#selectedRValue').value;
    let x_click = clientX;
    let y_click = clientY;
    let x_result = (x_click - x_center) * r_result / (image.width * 0.25);
    let y_result = - (y_click - y_center) * r_result / (image.height * 0.25);
    await sendForm(x_result, y_result, r_result);
})

async function sendForm(x_result, y_result, r_result) {
    if (x_result === "" || y_result === "" || r_result === undefined) {
        alert("Все поля должны быть заполнены! Пожалуйста, повторите ввод.");
    } else {
        let params = new URLSearchParams();
        params.append("X", x_result);
        params.append("Y", y_result);
        params.append("R", r_result);
        let response = await fetch(`controller-servlet?${params.toString()}`, {
            method: "POST",
        });
        if (response.status === 400) {
            document.getElementById("Y").value="";
            alert("Координаты точки не попадают в ОДЗ! Пожалуйста, повторите ввод.");
        } else if (response.status === 200) {
            window.location.href = response.url;
        }
    }
}