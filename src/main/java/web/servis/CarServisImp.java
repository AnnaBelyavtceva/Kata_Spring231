package web.servis;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServisImp implements CarServis {
    private List<Car> carsList;


    {   carsList = new ArrayList<Car>();

        carsList.add(new Car("Lada","red",2001));
        carsList.add(new Car("BMW","blue",2002));
        carsList.add(new Car("Honda","yellow",2003));
        carsList.add(new Car("Toyota","green",2004));
        carsList.add(new Car("Mazda","yellow",2005));
    }

    @Override
    public List<Car> getCars(int count) {

        return carsList.stream().limit(count).toList();
    }
}
