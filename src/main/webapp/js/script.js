const diagram = document.getElementById("diagram");
const image = diagram.getBoundingClientRect();
const x_center = image.left + image.width * 0.5;
const y_center = image.top + image.height * 0.5;

const selected_x_value = document.getElementById("inputForm:selectedXValue");
const x_setter = document.getElementById("inputForm:XSetter");
const selected_y_value = document.getElementById("inputForm:YTextfield");
const selected_r_value = document.getElementById("inputForm:selectedRValue");

diagram.addEventListener('click', async ({clientX, clientY}) => {
    let r_result = selected_r_value.innerHTML;
    let x_click = clientX;
    let y_click = clientY;
    let x_result = Math.round(((x_click - x_center) * r_result / (image.width * 0.25)) * 100) / 100;
    let y_result = Math.round((-(y_click - y_center) * r_result / (image.height * 0.25)) * 100) / 100;
    selected_x_value.innerHTML = x_result;
    x_setter.value = x_result;
    selected_y_value.value = y_result;
    await processClick();
    mark_points();
})

function mark_points() {
    let result_table = document.getElementById("inputForm:resultTable");
    let rows = result_table.rows;
    let r_result = parseFloat(selected_r_value.innerHTML);
    for (let i = 1; i < result_table.rows.length; i++) {
        let cells = rows[i].cells;
        let x_result = parseFloat(cells[0].innerHTML);
        let y_result = parseFloat(cells[1].innerHTML);
        let x_coord = 200 + (x_result * image.width / r_result / 4);
        let y_coord = 200 - (y_result * image.height / r_result / 4);
        let point = document.createElementNS("http://www.w3.org/2000/svg", "circle")
        point.setAttribute("cx", `${x_coord}`);
        point.setAttribute("cy", `${y_coord}`);
        point.setAttribute("r", "2");
        if (cells[3].innerHTML === "true") {
            point.setAttribute("stroke", "green");
            point.setAttribute("fill", "green");
        } else {
            point.setAttribute("stroke", "red");
            point.setAttribute("fill", "red");
        }
        point.setAttribute("strokeWidth", "2px");
        diagram.appendChild(point);
    }
}