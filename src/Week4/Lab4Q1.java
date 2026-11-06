package Week4;

class Record {
    protected final String name;
    public Record(String name){
        this.name =name;
    }
    public String getName(){return this.name;}
}

class Employee extends Record {
    private final int serialNumber;

    public Employee(String fullName, int serialNumber) {
        super(fullName);
        this.serialNumber = serialNumber;
    }

    public String getFullName() { return super.getName(); }
    public int getSerialNumber() { return serialNumber; }
}

class Product extends Record {
    private final int price;

    public Product(String barcode, int price) {
        super(barcode);
        this.price = price;
    }

    public String getBarcode() { return super.getName(); }
    public int getPrice() { return price; }
}

class CsvExporter {
    public static void main(String[] args) {
        var exporter = new CsvExporter();
        exporter.writeCsvLine(new Employee("Garry", 12));
        exporter.writeCsvLine(new Product("00127689", 20));
    }

    public void writeCsvLine(Record record) {
        if (record instanceof Employee) {
            Employee emp = (Employee) record;
            System.out.println("Employ" + "," + emp.getSerialNumber() + "," + emp.getFullName());
        } else if (record instanceof Product) {
            Product prod = (Product) record;
            System.out.println("Product" + "," + prod.getBarcode() + "," + prod.getPrice());
        }
    }
}
