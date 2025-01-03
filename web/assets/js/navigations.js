const navigateToPage = (buttonId, pageId) => {
  $(buttonId).on("click", function () {
    $(".page").removeClass("active"); // Hide all pages
    $(pageId).addClass("active"); // Show selected page
  });
};

navigateToPage("#btn-home", "#home");
navigateToPage("#btn-orders", "#orders");
navigateToPage("#btn-store", "#store");
navigateToPage("#btn-cus", "#customers");

