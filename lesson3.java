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
