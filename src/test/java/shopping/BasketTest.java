package shopping;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stock.StockItems;
import util.ExceptionHandling;
import util.Utility;
import wholesale.SpecialOffers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Constants.ITEM_NOTFOND;
import static util.Constants.NULLFOUND;

class BasketTest {
    Basket basket;
    StockItems stockItems;
    SpecialOffers specialOffers;
    static Utility utility;

    @BeforeEach()
    public void setUp() throws ExceptionHandling {
        //given
        utility = new Utility();
        stockItems = new StockItems();
        specialOffers = new SpecialOffers();
        utility.initialise(stockItems, specialOffers);
        basket = new Basket(stockItems);
    }
    @AfterEach
    public void cleanUp() {
        stockItems = new StockItems();
        specialOffers = new SpecialOffers();
    }

    @Test
    public void validate_addItemToBasket() throws ExceptionHandling {
        //when
        basket.addItemToBasket("AAAABBBBBBBBBBBB");

        //then
        assertEquals(2, basket.getShoppingBasket().size());
        assertEquals(2, basket.getItemsTotal().size());
    }

    @Test
    public void validate_nullItemInBasket(){

        try {
            //when
            basket.addItemToBasket(null);
        } catch (ExceptionHandling e) {
            //then
            assertEquals(NULLFOUND, e.getMessage());
            assertEquals(0, basket.getShoppingBasket().size());
            assertEquals(0, basket.getItemsTotal().size());
        }

    }

    @Test
    public void validate_UnknownItemInBasket(){
        try {
            //when
            basket.addItemToBasket("AABCCCZZZZZ");
        } catch (ExceptionHandling e) {
            //then
            assertEquals(ITEM_NOTFOND + ": Z", e.getMessage());
            assertEquals(3, basket.getShoppingBasket().size());
            assertEquals(3, basket.getItemsTotal().size());
        }

    }

}