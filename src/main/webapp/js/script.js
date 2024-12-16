const diagram = document.getElementById("diagram");
const image = diagram.getBoundingClientRect();
const x_center = image.left + image.width * 0.5;
const y_center = image.top + image.height * 0.5;

const selected_x_value = document.getElementById("inputForm:selectedXValue");
const shown_selected_x_value = document.getElementById("inputForm:shownSelectedXValue");
const selected_y_value = document.getElementById("inputForm:YTextfield");
const selected_r_value = document.getElementById("inputForm:selectedRValue");

diagram.addEventListener('click', ({clientX, clientY}) => onClick(clientX, clientY))

async function onClick(clientX, clientY){
    let r_result = selected_r_value.value;
    let x_click = clientX;
    let y_click = clientY;
    let x_result = Math.round(((x_click - x_center) * r_result * 4 / image.width) * 100) / 100;
    let y_result = Math.round((-(y_click - y_center) * r_result * 4 / image.height) * 100) / 100;
    selected_x_value.value = x_result;
    shown_selected_x_value.value = x_result;
    selected_y_value.value = y_result;
    await processClick();
}

const r_links = document.querySelectorAll("[name='RLink']");
for (let r_link of r_links) {
    r_link.addEventListener('click', () => mark_points());
}