// --------------------------------------------------- Customer Model
const openCusModal = document.getElementById("addNewCustomerBtn");
const closeCusModalButtons = document.querySelectorAll(
  "#closeCusModal, #closeCusModalFooter"
);

const cusModal = document.getElementById("cusModel");

// Open cus modal
openCusModal.addEventListener("click", () => {
  cusModal.style.display = "flex";
});

// Close cus modal
closeCusModalButtons.forEach((btn) => {
  btn.addEventListener("click", () => {
    cusModal.style.display = "none";
  });
});





// -------------------------------------------------------- Item Model
const openItemModal = document.getElementById("addNewItemBtn");
const closeItemModalButtons = document.querySelectorAll(
  "#closeItemModal, #closeItemModalFooter"
);

const itemModal = document.getElementById("itemModel");



// Open item modal
openItemModal.addEventListener("click", () => {
  itemModal.style.display = "flex";
});

// Close item modal
closeItemModalButtons.forEach((btn) => {
  btn.addEventListener("click", () => {
    itemModal.style.display = "none";
  });
});
