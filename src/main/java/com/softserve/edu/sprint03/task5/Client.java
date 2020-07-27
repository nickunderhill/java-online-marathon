package sprint03.task5;

class Client {
    enum ClientType {
        NEW(0),
        SILVER(12),
        GOLD(30),
        PLATINUM(60);

        private int months;

        ClientType(int months) {
            this.months = months;
        }

        public double discount() {
            double result;
            double coefficient = 0.35;
            result = (100 - this.months * coefficient) / 100;
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println((ClientType.NEW.discount()));
        System.out.println((ClientType.SILVER.discount()));
        System.out.println((ClientType.GOLD.discount()));
        System.out.println((ClientType.PLATINUM.discount()));

    }
}
