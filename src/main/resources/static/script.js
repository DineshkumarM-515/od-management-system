const API_URL = "/od";

if(!localStorage.getItem("role")) {

    window.location.href = "login.html";
}

const role = localStorage.getItem("role");

document.getElementById("userRole").innerText =
    role;

async function applyOD() {

    const data = {
        studentName: document.getElementById("name").value,
        registerNumber: document.getElementById("reg").value,
        reason: document.getElementById("reason").value,
        proofFile: "proof.pdf"
    };

    await fetch(`${API_URL}/apply`, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(data)

    });

    alert("OD Applied Successfully");

    loadRequests();
}

async function loadRequests() {

    const response = await fetch(`${API_URL}/all`);

    const requests = await response.json();

    let rows = "";

    document.getElementById("totalCount").innerText = requests.length;

    const approved = requests.filter(r =>
        r.status === "APPROVED"
    ).length;

    document.getElementById("approvedCount").innerText = approved;

    const rejected = requests.filter(r =>
        r.status.includes("REJECTED")
    ).length;

    document.getElementById("rejectedCount").innerText = rejected;

    requests.forEach(request => {

        rows += `
            <tr>
                <td>${request.id}</td>
                <td>${request.studentName}</td>
                <td>${request.registerNumber}</td>
                <td>${request.reason}</td>
    
                <td>
                    <span class="${getStatusClass(request.status)}">
                        ${request.status}
                    </span>
                </td>
    
                <td>
                    ${getActionButtons(request)}
                </td>
            </tr>
        `;
    });

    document.getElementById("tableBody").innerHTML = rows;
}

function getActionButtons(request) {

    const role = localStorage.getItem("role");

    // PROCTOR
    if(role === "PROCTOR" &&
       request.status === "PENDING_PROCTOR") {

        return `
            <button
                class="btn btn-success btn-sm"
                onclick="approveRequest(${request.id}, '${request.status}')">
                Approve
            </button>

            <button
                class="btn btn-danger btn-sm"
                onclick="rejectRequest(${request.id}, '${request.status}')">
                Reject
            </button>
        `;
    }

    // AC
    if(role === "AC" &&
       request.status === "PENDING_AC") {

        return `
            <button
                class="btn btn-success btn-sm"
                onclick="approveRequest(${request.id}, '${request.status}')">
                Approve
            </button>

            <button
                class="btn btn-danger btn-sm"
                onclick="rejectRequest(${request.id}, '${request.status}')">
                Reject
            </button>
        `;
    }

    // HOD
    if(role === "HOD" &&
       request.status === "PENDING_HOD") {

        return `
            <button
                class="btn btn-success btn-sm"
                onclick="approveRequest(${request.id}, '${request.status}')">
                Approve
            </button>

            <button
                class="btn btn-danger btn-sm"
                onclick="rejectRequest(${request.id}, '${request.status}')">
                Reject
            </button>
        `;
    }

    return "-";
}

function getStatusClass(status) {

    if (status.includes("APPROVED"))
        return "badge bg-success";

    if (status.includes("REJECTED"))
        return "badge bg-danger";

    return "badge bg-warning text-dark";
}

loadRequests();

async function approveRequest(id, status) {

    let url = "";

    if (status === "PENDING_PROCTOR") {
        url = `${API_URL}/proctor/approve/${id}`;
    }

    else if (status === "PENDING_AC") {
        url = `${API_URL}/ac/approve/${id}`;
    }

    else if (status === "PENDING_HOD") {
        url = `${API_URL}/hod/approve/${id}`;
    }

    await fetch(url, {
        method: "PUT"
    });

    loadRequests();
}

async function rejectRequest(id, status) {

    const reason = prompt("Enter rejection reason:");

    let url = "";

    if (status === "PENDING_PROCTOR") {
        url = `${API_URL}/proctor/reject/${id}?reason=${reason}`;
    }

    else if (status === "PENDING_AC") {
        url = `${API_URL}/ac/reject/${id}?reason=${reason}`;
    }

    else if (status === "PENDING_HOD") {
        url = `${API_URL}/hod/reject/${id}?reason=${reason}`;
    }

    await fetch(url, {
        method: "PUT"
    });

    loadRequests();
}

window.onload = function() {

    const role = localStorage.getItem("role");

    if(role !== "STUDENT") {

        document.getElementById("applyForm").style.display = "none";
    }

    document.getElementById("userRole").innerText = role;

    loadRequests();
};

function logout() {

    localStorage.clear();

    window.location.href = "login.html";
}
