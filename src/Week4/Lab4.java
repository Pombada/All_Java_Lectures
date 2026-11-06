package Week4;

/*DO NOT CHANGE THIS CLASS*/
class Item {
    private String description;
    private float cost;

    public Item(String description, float cost) {
        this.description = description;
        this.cost = cost;
    }

    public float getCost(){
        return cost;
    }
    public String getDescription(){
        return description;
    }
}


/*ADD YOUR CODE HERE*/


class Phone extends Item {
    private int manufactureYear;
    public Phone(String description, float cost, int manufactureYear){
        super(description,cost);
        this.manufactureYear = manufactureYear;
    }

}
class RefurbishedPhone extends Phone {
    private int discountPercent ;
    public RefurbishedPhone(String description, float cost, int manufactureYear , int discountPercent){
        super(description,cost,manufactureYear);
        this.discountPercent = discountPercent;
    }


    @Override
    public String getDescription(){
        return super.getDescription() + "Refurbished";
    }
    public float getCost(){
        return super.getCost()/discountPercent;
    }
}
class Accessory extends Item {
    private String model;
    public Accessory(String description, float cost,String model){
        super(description,cost);
        this.model = model;
    }
    public String getModel(){return this.model;}
    public String getDescription(){return super.getDescription() + model;}
}
class Cart {
    private Item[] items= new Item[100];
    private int index = 0;
    public Cart(){}

    public Cart(Item[] items){
        for(Item i : items){
            this.items[index] = items[index];
            index++;
        }

    }
    public float getCost(){
        int result = 0;
        for(Item i : this.items){
            result += i.getCost();
        }
        return result;
    }
    public float getShippingFee(){
        int result = 0;
        if (this.getCost() >= 1000)
            return 0;
        for (Item i : items)
            result++;

        return result;
    }
    public void addItem(Item item){
        items[index] = item;
    }
    public Item[] getItems() {
        Item[] copy = this.items;
        return copy;
    }

}
