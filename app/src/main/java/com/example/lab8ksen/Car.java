package com.example.lab8ksen;



import java.util.ArrayList;
import java.util.List;

public class Car {

    private String name;
    private byte price;
    private String description;
    private String fullDescription;
    private int logo;



    public Car(String name, byte price, String description, String fullDescription,  int logo) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.fullDescription = fullDescription;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public byte getPrice() {
        return price;
    }

    public String getDescribtion() {
        return description;
    }

    public String getFullDescribtion() {
        return fullDescription;
    }

    public int getLogo() {
        return logo;
    }

    private static List<Car> cars = new ArrayList<>();

    public static List<Car> getCars() {

        if (cars.isEmpty()) {
            cars.add(new Car("Car 1", (byte) 100, "Хорошая и компактная", "«ВАЗ», «Волжский автомобильный завод» (VAZ), российская компания, специализирующаяся на производстве легковых автомобилей марки «Жигули», «Лада» и «Нива» (повышенной проходимости). Штаб-квартира находится в г. Тольятти (Самарская область).\n" + "Строительство завода началось в 1967. Совет Министров СССР назначил зам. министра автомобильной промышленности Полякова В.Н. генеральным директором строящегося завода, а главным конструктором ВАЗа В.С.Соловьева. Первая очередь, рассчитанная на выпуск 220 тыс. автомашин в год, вступила в строй в 1971.\n" + "\n" + "За основу при выпуске малолитражного с пятиместным кузовом «ВАЗ-2101» был взят «ФИАТ-124». Мощность четырехцилиндрового двигателя составляла 60 л. с., максимальная скорость — 140 км/ч. «Жигули» задумывались как народный автомобиль, который при сравнительно невысокой цене мог бы насытить «ненасытный» советский рынок. Но конструкторы и заводские инженеры и механики в дальнейшем столкнулись с массой проблем, которые помешали эффективно решать поставленные задачи. Сразу же пришлось отказаться от мысли о доступности автомобиля для рядового человека. С каждой новой моделью цена на «Жигули» значительно росла. Однако задача насыщения рынка в какой-то степени решалась, поскольку товар «ВАЗа» отнюдь не залеживался (в конце 70-х годов появились «Жигули» с кузовом «универсал»). Кроме того в 1977 появилась новая полноприводная модель «Нива» — ВАЗ-2121.", R.drawable.ic_launcher_background));



        }
        return cars;
    }
}