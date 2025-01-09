public class RealEstateManagement {
    public static class Property {
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
        public double getPrice() {
            return price;
        }
        public String getPropertyType() {
            return propertyType;
        }
        public int getSize() {
            return size;
        }
        public String toString() {
            return String.format("Property(Address: %s, Price: %.2f, Type: %s, Size: %d sqft)", address, price, propertyType, size);
        }
    }
    public static class Agent {
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
        public String getPhone() {
            return phone;
        }
        public int getExperience() {
            return experience;
        }
        public String toString() {
            return String.format("Agent(Name: %s, Phone: %s, Experience: %d years)", name, phone, experience);
        }
    }
    public static class RealEstateAgency {
        private String name;
        private String address;
        public RealEstateAgency(String name, String address) {
            this.name = name;
            this.address = address;
        }
        public String getName() {
            return name;
        }
        public String getAddress() {
            return address;
        }
        public String toString() {
            return String.format("RealEstateAgency(Name: %s, Address: %s)", name, address);
        }
    }
    public static void main(String[] args) {
        Property house = new Property("123 Elm Street", 25000000, "House", 1800);
        Property apartment = new Property("456 Oak Avenue", 17500000, "Apartment", 1200);
        Agent agent1 = new Agent("John Doe", "5555555", 5);
        RealEstateAgency agency = new RealEstateAgency("Dream Homes", "123 Main Street");
        System.out.println(agency);
        System.out.println(agent1);
        System.out.println(house);
        System.out.println(apartment);
    }
}
