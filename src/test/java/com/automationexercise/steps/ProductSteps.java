package com.automationexercise.steps;

import com.automationexercise.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class ProductSteps {

    List<String> pList = new ArrayList<>();
    @And("Verify that {string} are visible on left side bar")
    public void verifyThatAreVisibleOnLeftSideBar(String expectedText) {
        assertEquals(new ProductPage().getTextBrands(expectedText), expectedText, "Text is not visible");
    }

    @And("Click on brand Name {string}")
    public void clickOnBrandName(String option) {
        new ProductPage().clickOnBrand(option);
    }

    @And("Verify that user is navigated to {string} brand page and verify brand product {string} displayed")
    public void verifyThatUserIsNavigatedToBrandPageAndVerifyBrandProductDisplayed(String expectedURL, String expectedText) {
        Map<String, String> resultHashMap = new ProductPage().getBrandTitleAndURL();
        assertEquals(resultHashMap.get("actualText"), expectedText, "Brand List title is not Matched");
        assertEquals(resultHashMap.get("currentURL"), expectedURL);
    }

    @And("Verify that user is navigated to {string} page successfully")
    public void verifyThatUserIsNavigatedToPageSuccessfully(String expectedText) {
        assertEquals(new ProductPage().getTextAllProducts(expectedText), expectedText);

    }

    @And("Verify that the products list is visible")
    public void verifyThatTheProductsListIsVisible() {
        assertTrue(new ProductPage().getListCount() > 0, "Product list not visible");
    }

    @And("I Click on {string} of first product {string}")
    public void iClickOnOfFirstProduct(String viewProductBtn, String productName) {
        new ProductPage().clickOnRecommendedProductAddToCart(productName, viewProductBtn, "Not Hover");
    }

    @And("User is landed to product detail page")
    public void userIsLandedToProductDetailPage() {
        assertTrue(getCurrentURL().contains("https://automationexercise.com/product_details"), "User not landed to product detail page");
    }

    private Collection<Object> getCurrentURL() {
        return null;
    }

    @Then("Verify that product detail is visible: product name: {string}, category: {string}, price: {string}, availability: {string}, condition: {string} brand: {string}")
    public void verifyThatProductDetailIsVisibleProductNameCategoryPriceAvailabilityConditionBrand(String productName, String category, String price, String availability, String condition, String brand) {
        assertEquals(new ProductDetailsPage().getProductName(), productName);
        assertEquals(new ProductDetailsPage().getProductCategory(), category);
        assertEquals(new ProductDetailsPage().getProductPrice(), price);
        assertEquals(new ProductDetailsPage().getProductAvailability(), availability);
        assertEquals(new ProductDetailsPage().getProductCondition(), condition);
        assertEquals(new ProductDetailsPage().getProductBrand(), brand);
    }

    @And("Enter Product name: {string} in search input and click {string} button")
    public void enterProductNameInSearchInputAndClickSearchButton(String text, String button) {
        new ProductPage().enterProductName(text);
        new ProductPage().clickOnBtn(button);
    }

    @Then("Verify all the products related to search {string} are visible")
    public void verifyAllTheProductsRelatedToSearchAreVisible(String text) {
        assertTrue(new SearchPage().getTextSearchedProductName(text));

    }

    @And("Hover over first product {string} and click {string}")
    public void hoverOverFirstProductAndClick(String productName, String addToCartButton) {
        new ProductPage().clickOnRecommendedProductAddToCart(productName, addToCartButton, "Hover");
    }

    @And("Verify that both products {string} and {string} are added to Cart")
    public void verifyThatBothProductsAndAreAddedToCart(String firstProduct, String secondProduct) {
        assertEquals(new ViewCartPage().getTextProductDisplayed(firstProduct), firstProduct);
        assertEquals(new ViewCartPage().getTextProductDisplayed(secondProduct), secondProduct);

    }

    @Then("Verify that product name: {string} prices: {string}, quantity: {string} and total price: {string}")
    public void verifyThatProductNamePricesQuantityAndTotalPrice(String productName, String price, String quantity, String totalPrice) {
        Map<String, String> productDetails = new ViewCartPage().getTextProductDetails(productName);
        assertEquals(productDetails.get("productName"), productName, "Product Name not matched");
        assertEquals(productDetails.get("Price"), price, "Product Price not matched");
        assertEquals(productDetails.get("Quantity"), quantity, "Product Quantity not matched");
        assertEquals(productDetails.get("TotalPrice"), totalPrice, "Product Total Price not matched");

    }

    @And("Enter description: {string} in comment text area and click {string}")
    public void enterDescriptionInCommentTextAreaAndClick(String description, String placeOrderBtn) {
        new CheckOutPage().enterDescription(description);
        new CheckOutPage().clickOnBtn(placeOrderBtn);

    }

    @And("Enter payment details: Name on Card: {string}, Card Number: {string}, CVC:{string}, Expiration date:{string}")
    public void enterPaymentDetailsNameOnCardCardNumberCVCExpirationDate(String nameOnCard, String cardNumber, String cvc, String expDate) {
        new CheckOutPage().enterPaymentDetails(nameOnCard, cardNumber, cvc, expDate);
    }

    @And("I Click on {string} button")
    public void iClickOnButton(String btnName) {
        if (btnName.equalsIgnoreCase("Pay and Confirm Order") || btnName.equalsIgnoreCase("Continue")) {
            new CheckOutPage().clickOnBtn(btnName);
        }else if (btnName.equalsIgnoreCase("Submit")){
            new ProductDetailsPage().clickOnButton(btnName);
        }
    }

    @Then("Verify success message {string}")
    public void verifySuccessMessage(String msg) {
        assertEquals(new CheckOutPage().getConfirmationMsg(), msg, "order not placed");
    }

    @And("Click {string} on X button corresponding to particular product")
    public void clickOnXButtonCorrespondingToParticularProduct(String pName) {
        new ViewCartPage().deleteProductFromCart(pName);

    }

    @Then("Verify that product is removed from the cart {string}")
    public void verifyThatProductIsRemovedFromTheCart(String productDeletedText) {
        assertEquals(new ViewCartPage().getTextDeletedProduct(), productDeletedText);
    }

    @And("I Click on any category link {string} under {string} category")
    public void iClickOnAnyCategoryLinkUnderCategory(String subCategory, String category) {
        new ProductPage().clickOnCategoryList(category);
        new ProductPage().clickOnSubCategory(subCategory);
    }
    @And("Verify that category page is displayed and confirm text {string}")
    public void verifyThatCategoryPageIsDisplayedAndConfirmText(String categoryText) {
        return assertTrue(Boolean.parseBoolean("https://automationexercise.com/category_products"), ("User not landed to category page"),
                assertEquals(new CategoryPage().getTitleManWomenProduct(categoryText)}
    @And("I Add those products to cart")
    public void iAddThoseProductsToCart() {
        pList = new SearchPage().clickOnRelatedAddToCartBtn();
        assertTrue(pList.stream().count()>0, "Product not add to cart");
    }

    @And("Enter Product name: {string} in search input and click {string} button.")
    public void enterProductNameInSearchInputAndClickButton(String text, String button) {
        new ProductPage().enterProductName(text);
        new ProductPage().clickOnBtn(button);
    }

    @And("Verify that products are visible in cart")
    public void verifyThatProductsAreVisibleInCart() {
        assertTrue(new SearchPage().checkProductInCart(pList), "Product list not show on cart");
    }

    @And("Verify that the {string} is visible")
    public void verifyThatIsVisible(String expactedText) {
        assertEquals(new ProductDetailsPage().getWriteYourReviewText(expactedText), expactedText);

    }

    @And("Enter name: {string}, email: {string} and review: {string}")
    public void enterNameEmailAndReview(String name, String email, String reviewText) {
        new ProductDetailsPage().enterReviewDetails(name, email, reviewText);
    }

    @And("Click {string} button and verify invoice is downloaded successfully")
    public void clickButtonAndVerifyInvoiceIsDownloAdedSuccessfully(String btnNAme) {
        String filePath = "C:/Users/thumm/Downloads/invoice.txt";
//        new CheckOutPage().clickOnBtn(btnNAme);
        assertTrue(new CheckOutPage().checkFileIsDownloaded(filePath));
    }
}
