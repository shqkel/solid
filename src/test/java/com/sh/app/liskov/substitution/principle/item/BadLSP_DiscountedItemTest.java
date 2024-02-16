package com.sh.app.liskov.substitution.principle.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BadLSP_DiscountedItemTest {

    @AllArgsConstructor
    static class Item {
        @Getter
        private double price;
    }


    static class DiscountedItem extends Item{
        private double discountRate;

        public DiscountedItem(double price, double discountRate) {
            super(price);
            this.discountRate = discountRate;
        }

        @Override
        public double getPrice() {
            return super.getPrice() * (1 - discountRate);
        }
    }

    @DisplayName("서브 클래스가 슈퍼 클래스의 책임을 무시하거나 재정의 override 하지 않고 확장만 수행해야 한다. ")
    @Test
    public void test() throws Exception {
        // given
        final double price = 30_000;
        Item item1 = new Item(price);
        Item item2 = new DiscountedItem(price, .1);
        // when
        double price1 = item1.getPrice(); // 30_000
        double price2 = item2.getPrice(); // 27_000
        // then
        assertThat(price1).isNotEqualTo(price2);
    }
}
