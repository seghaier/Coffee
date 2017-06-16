package com.example.formation.coffee;

/**
 * Created by Formation on 14/06/2017.
 */

public class Order {

    private int id;
    private String qteCoffee, qteCoffeeChantilly, qteChocolat, qteChocolatChantilly, total ;


    public Order(String qteCoffee, String qteCoffeeChantilly, String qteChocolat, String qteChocolatChantilly, String total) {
        this.qteCoffee = qteCoffee;
        this.qteCoffeeChantilly = qteCoffeeChantilly;
        this.qteChocolat = qteChocolat;
        this.qteChocolatChantilly = qteChocolatChantilly;
        this.total = total;
    }

    public Order() {
    }


    public Order(int id, String qteCoffee, String qteCoffeeChantilly, String qteChocolat, String qteChocolatChantilly, String total) {
        this.id = id;
        this.qteCoffee = qteCoffee;
        this.qteCoffeeChantilly = qteCoffeeChantilly;
        this.qteChocolat = qteChocolat;
        this.qteChocolatChantilly = qteChocolatChantilly;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQteCoffee() {
        return qteCoffee;
    }

    public void setQteCoffee(String qteCoffee) {
        this.qteCoffee = qteCoffee;
    }

    public String getQteCoffeeChantilly() {
        return qteCoffeeChantilly;
    }

    public void setQteCoffeeChantilly(String qteCoffeeChantilly) {
        this.qteCoffeeChantilly = qteCoffeeChantilly;
    }

    public String getQteChocolat() {
        return qteChocolat;
    }

    public void setQteChocolat(String qteChocolat) {
        this.qteChocolat = qteChocolat;
    }

    public String getQteChocolatChantilly() {
        return qteChocolatChantilly;
    }

    public void setQteChocolatChantilly(String qteChocolatChantilly) {
        this.qteChocolatChantilly = qteChocolatChantilly;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
