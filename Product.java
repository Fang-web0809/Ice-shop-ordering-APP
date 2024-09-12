abstract class Ice {
    double cost;
    double price;
    Ice (double c, double p) {
        cost = c;
        price = p;
    }
    double getCost() {
        return cost;
    }
    double getPrice() {
        return price;
    }
}

class Apple extends Ice {
    Apple() {
        super(6.0, 10.0);
    }
}
class Banana extends Ice {
    Banana() {
        super(2.0,5.0);
    }
}
class Pudding extends Ice {
    Pudding() {
        super(3.0,5.0);
    }
}
class Strawberry extends Ice {
    Strawberry() {
        super(1.0,5.0);
    }
}
class Mango extends Ice {
    Mango() {
        super(2.0,5.0);
    }
}
class zeo extends Ice {
    zeo() {
        super(0.0,0.0);
    }
}

abstract class Product
{
    abstract double getCost();
    abstract double getPrice();
    double getProfit()
    {  return getPrice() - getCost();  }
}

class A extends Product
{
    Ice i1, i2;
    A (Ice  x, Ice y)
    {
        i1 = x;
        i2 = y;
    }
    double getCost()
    {  return i1.getCost() + i2.getCost();   }
    double getPrice()
    {  return i1.getPrice() + i2.getPrice();  }
}
class B extends Product
{
    Ice i1, i2, i3;
    B(Ice  x, Ice y, Ice z)
    {
        i1 = x;
        i2 = y;
        i3 = z;
    }
    double getCost()
    {  return i1.getCost() + i2.getCost() + i3.getCost();   }
    double getPrice()
    {  return i1.getPrice() + i2.getPrice() + i3.getPrice();  }
}

class C extends A
{
    C(Ice x, Ice y)
    {   super(x, y);  }
    double getCost()
    {  return super.getCost() + 2;  }
    double getPrice()
    {  return super.getPrice() * 1.5;  }
}
class D extends B
{
    D(Ice x, Ice y, Ice z)
    {   super(x, y, z);  }
    double getCost()
    {  return super.getCost() + 2;  }
    double getPrice()
    {  return super.getPrice() * 1.5;  }
}
class E extends Product
{
    Ice ie,ie2,ie3,ie4,ie5;
    E(Ice e,Ice e2,Ice e3,Ice e4,Ice e5)
    {
        ie=e;
        ie2=e2;
        ie3=e3;
        ie4=e4;
        ie5=e5;
    }
    double getCost()
    {
        return ie.getCost() + ie2.getCost()+ie3.getCost()+ie4.getCost();
    }
    double getPrice()
    {  return ie.getPrice() + ie2.getPrice()+ie3.getPrice()+ie4.getPrice();
    }

}
class F extends E
{
    F(Ice e,Ice e2,Ice e3,Ice e4,Ice e5)
    {
        super(e,e2,e3,e4,e5);
    }
    double getCost()
    {
        return super.getCost()+2;
    }
    double getPrice()
    {  return super.getPrice()*1.6;
    }

}
