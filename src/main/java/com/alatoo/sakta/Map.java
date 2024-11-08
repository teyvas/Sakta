package com.alatoo.sakta;
import java.util.ArrayList;
import java.util.List;
class MapService {
    private List<Doctor> doctors;

    public MapService() {
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public Doctor findNearestAvailableDoctor(User user) {
        Doctor nearestDoctor = null;
        double minDistance = Double.MAX_VALUE;

        for (Doctor doctor : doctors) {
            if (doctor.isAvailable()) {
                double distance = Haversine.distance(user.getLatitude(), user.getLongitude(),
                        doctor.getLatitude(), doctor.getLongitude());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestDoctor = doctor;
                }
            }
        }

        return nearestDoctor;
    }

    public void requestHelp(User user) {
        Doctor doctor = findNearestAvailableDoctor(user);
        if (doctor != null) {
            doctor.respondToHelpRequest(user);
            System.out.println("Врач " + doctor.getName() + " отправлен к пользователю " + user.getName());
        } else {
            System.out.println("Нет доступных врачей поблизости для пользователя " + user.getName());
        }
    }
}

class Haversine {
    private static final double EARTH_RADIUS = 6371; // Радиус Земли в километрах

    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }
}


/*// Пример использования
public class Main {
    public static void main(String[] args) {
        MapService mapService = new MapService();

        // Добавление врачей в систему
        mapService.addDoctor(new Doctor("Доктор А", 40.7128, -74.0060, true));
        mapService.addDoctor(new Doctor("Доктор Б", 40.7308, -73.9975, true));
        mapService.addDoctor(new Doctor("Доктор В", 40.7580, -73.9855, false)); // Этот врач занят

        // Пользователь запрашивает помощь
        User user = new User("Пациент", 40.7359, -73.9911);
        mapService.requestHelp(user);
    }
}
*/