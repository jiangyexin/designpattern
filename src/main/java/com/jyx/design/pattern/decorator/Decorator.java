package com.jyx.design.pattern.decorator;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2019-06-04 21:39
 **/
public class Decorator {
}

class Food {
    private String foodName;

    public Food() {
    }

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public String make() {
        return foodName;
    }
}

class Bread extends Food {
    private Food basicFood;

    public Bread(Food basicFood) {
        this.basicFood = basicFood;
    }

    @Override
    public String make() {
        return basicFood.make() + "奶油";
    }
}
