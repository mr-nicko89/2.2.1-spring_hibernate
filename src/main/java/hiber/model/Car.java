package hiber.model;

import javax.persistence.*;

@Entity
//@Table(name = "cars")
public class Car {

//    @Column(name = "car_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
//    @Column(name = "model")
    private String model;
//    @Column(name = "series")
    private int series;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
