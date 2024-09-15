import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;


class УчебнаяГруппа {
    private String название;

    public УчебнаяГруппа(String название) {
        this.название = название;
    }

    public String getНазвание() {
        return название;
    }

    @Override
    public String toString() {
        return название;
    }
}

class Поток implements Iterable<УчебнаяГруппа> {
    private List<УчебнаяГруппа> группы;

    public Поток(List<УчебнаяГруппа> группы) {
        this.группы = группы;
    }

    public List<УчебнаяГруппа> getГруппы() {
        return группы;
    }

    @Override
    public Iterator<УчебнаяГруппа> iterator() {
        return группы.iterator();
    }

    @Override
    public String toString() {
        return "Поток с " + группы.size() + " группами: " + группы;
    }
}

class StreamComparator implements Comparator<Поток> {
    @Override
    public int compare(Поток поток1, Поток поток2) {
        return Integer.compare(поток1.getГруппы().size(), поток2.getГруппы().size());
    }
}

class ПотокСервис {
    public void сортироватьПотоки(List<Поток> потоки) {
        Collections.sort(потоки, new StreamComparator());
    }
}

class Контроллер {
    private ПотокСервис потокСервис;

    public Контроллер(ПотокСервис потокСервис) {
        this.потокСервис = потокСервис;
    }

    public void сортироватьПотоки(List<Поток> потоки) {
        потокСервис.сортироватьПотоки(потоки);
    }

    public void вывестиПотоки(List<Поток> потоки) {
        for (Поток поток : потоки) {
            System.out.println(поток);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем учебные группы
        УчебнаяГруппа группа1 = new УчебнаяГруппа("Группа A");
        УчебнаяГруппа группа2 = new УчебнаяГруппа("Группа B");
        УчебнаяГруппа группа3 = new УчебнаяГруппа("Группа C");

        // Создаем потоки
        Поток поток1 = new Поток(new ArrayList<>(List.of(группа1, группа2))); // 2 группы
        Поток поток2 = new Поток(new ArrayList<>(List.of(группа1))); // 1 группа
        Поток поток3 = new Поток(new ArrayList<>(List.of(группа1, группа2, группа3))); // 3 группы

        // Создаем список потоков
        List<Поток> потоки = new ArrayList<>();
        потоки.add(поток1);
        потоки.add(поток2);
        потоки.add(поток3);

        // Создаем сервис и контроллер
        ПотокСервис потокСервис = new ПотокСервис();
        Контроллер контроллер = new Контроллер(потокСервис);

        // Выводим исходные потоки
        System.out.println("Исходные потоки:");
        контроллер.вывестиПотоки(потоки);

        // Сортируем потоки
        контроллер.сортироватьПотоки(потоки);

        // Выводим отсортированные потоки
        System.out.println("\nОтсортированные потоки:");
        контроллер.вывестиПотоки(потоки);
    }
}
