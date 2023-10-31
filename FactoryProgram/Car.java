public class Car {
    String carType;
    int year;
    String color;
    int miles;

    public Car(String carType, int year, String color, int miles){
        this.carType = carType;
        this.year = year;
        this.color = color;
        this.miles = miles;
    }

    public String getCarType(){
        return carType;
    }

    public int getYear(){
        return year;
    }

    public String getColor(){
        return color;
    }

    public int getMiles(){
        return miles;
    }

}
