$(document).ready(function () {
  const navigateToPage = (buttonId, pageId, url) => {
    $(buttonId).on("click", function () {
      $.ajax({
        url: url,
        type: 'GET',
        success: (res) => {
          $(".page").removeClass("active"); // Hide all pages
          $(pageId).addClass("active"); // Show selected page
        },
        error: (err) => {
          console.error(err);
          alert("Failed to load the page. Please try again.");
        }
      });
    });
  };

  navigateToPage("#btn-home", "#home", "http://localhost:8080/JavaEEPOS/home");
  navigateToPage("#btn-orders", "#orders", "http://localhost:8080/JavaEEPOS/orders");
  navigateToPage("#btn-store", "#store", "http://localhost:8080/JavaEEPOS/store");
  navigateToPage("#btn-cus", "#customers", "http://localhost:8080/JavaEEPOS/customer");
});
