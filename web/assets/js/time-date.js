const today = new Date();
const formattedDate = today.toLocaleDateString();
document.getElementById("currentDate").textContent = formattedDate;

function updateTime() {
  const now = new Date();
  const formattedTime = now.toLocaleTimeString();
  document.getElementById("currentTime").textContent = formattedTime;
}

updateTime();

setInterval(updateTime, 1000);
