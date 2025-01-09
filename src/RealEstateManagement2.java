import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
abstract class AbstractEntity {
    public abstract String getDescription();
    public String toString() {
        return getDescription();
    }
}
class Property extends AbstractEntity {
    private String address;
    private double price;
    private String propertyType;
    private int size;
    public Property(String address, double price, String propertyType, int size) {
        this.address = address;
        this.price = price;
        this.propertyType = propertyType;
        this.size = size;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getPropertyType() {
        return propertyType;
    }
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String getDescription() {
        return String.format("Property(Address: %s, Price: %.2f, Type: %s, Size: %d sqft)", address, price, propertyType, size);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(property.price, price) == 0 &&
                size == property.size &&
                Objects.equals(address, property.address) &&
                Objects.equals(propertyType, property.propertyType);
    }
    public int hashCode() {
        return Objects.hash(address, price, propertyType, size);
    }
}
class Agent extends AbstractEntity {
    private String name;
    private String phone;
    private int experience;
    public Agent(String name, String phone, int experience) {
        this.name = name;
        this.phone = phone;
        this.experience = experience;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public String getDescription() {
        return String.format("Agent(Name: %s, Phone: %s, Experience: %d years)", name, phone, experience);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return experience == agent.experience &&
                Objects.equals(name, agent.name) &&
                Objects.equals(phone, agent.phone);
    }
    public int hashCode() {
        return Objects.hash(name, phone, experience);
    }
}
class RealEstateAgency {
    private String name;
    private String address;
    private List<Property> properties;
    public RealEstateAgency(String name, String address) {
        this.name = name;
        this.address = address;
        this.properties = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public List<Property> getProperties() {
        return properties;
    }
    public void addProperty(Property property) {
        properties.add(property);
    }
    public List<Property> filterByPrice(double minPrice, double maxPrice) {
        List<Property> filtered = new ArrayList<>();
        for (Property property : properties) {
            if (property.getPrice() >= minPrice && property.getPrice() <= maxPrice) {
                filtered.add(property);
            }
        }
        return filtered;
    }
    public void sortByPrice() {
        properties.sort(Comparator.comparingDouble(Property::getPrice));
    }
    public String toString() {
        return String.format("RealEstateAgency(Name: %s, Address: %s, Properties: %d)", name, address, properties.size());
    }
}
public class RealEstateManagement2 {
    public static void main(String[] args) {
        Property house = new Property("123 Elm Street", 25000000, "House", 1800);
        Property apartment = new Property("456 Oak Avenue", 17500000, "Apartment", 1200);
        Property villa = new Property("789 Pine Road", 50000000, "Villa", 3500);
        Agent agent1 = new Agent("John Doe", "5555555", 5);
        RealEstateAgency agency = new RealEstateAgency("Dream Homes", "123 Main Street");
        agency.addProperty(house);
        agency.addProperty(apartment);
        agency.addProperty(villa);
        System.out.println(agency);
        System.out.println(agent1);
        System.out.println("\nAll Properties:");
        for (Property property : agency.getProperties()) {
            System.out.println(property);
        }
        System.out.println("\nProperties priced between 1,800,000 and 3,000,000:");
        List<Property> filtered = agency.filterByPrice(1800000, 3000000);
        for (Property property : filtered) {
            System.out.println(property);
        }
        System.out.println("\nProperties sorted by price:");
        agency.sortByPrice();
        for (Property property : agency.getProperties()) {
            System.out.println(property);
        }
    }
}
