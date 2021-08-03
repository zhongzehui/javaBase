package com.zehui.base.enums;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza {

    private Integer id;
    private BigDecimal price;
    private PizzaSize size;
    private String pizzaName;
    private String pizzaCode;

    public Pizza() {
    }

    public Pizza(Integer id, BigDecimal price, PizzaSize size, String pizzaName, String pizzaCode) {
        this.id = id;
        this.price = price;
        this.size = size;
        this.pizzaName = pizzaName;
        this.pizzaCode = pizzaCode;
    }


    /**
     * 获取4人份的pizza，也就是m号披萨
     * @param pizzas
     * @return
     */
    public List<Pizza> get4ManPizza(List<Pizza> pizzas) {
        return pizzas.stream().filter(pizza -> PizzaSize.MEDIUM.equals(pizza.getSize()))
                .collect(Collectors.toList());
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaCode() {
        return pizzaCode;
    }

    public void setPizzaCode(String pizzaCode) {
        this.pizzaCode = pizzaCode;
    }


}
