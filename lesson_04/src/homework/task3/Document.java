package homework.task3;

class Document{
    private String name;
    private int pageAmount;

    Document(String name, int pageAmount){
        this.name = name;
        this.pageAmount = pageAmount;
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nДокумент " + name + " " + pageAmount + " страниц";
    }
}
