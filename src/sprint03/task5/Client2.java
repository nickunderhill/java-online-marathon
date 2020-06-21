package sprint03.task5;

class Client2 {
    enum ClientType {
        NEW(0) {
            @Override
            public double discount() {
                return (100 - this.getMonths() * 0.35) / 100;
            }
        },
        SILVER(12) {
            @Override
            public double discount() {
                return (100 - this.getMonths() * 0.35) / 100;
            }
        },
        GOLD(30) {
            @Override
            public double discount() {
                return (100 - this.getMonths() * 0.35) / 100;
            }
        },
        PLATINUM(60){
            @Override
            public double discount() {
                return (100 - this.getMonths() * 0.35) / 100;
            }
        };

        private int months;

        ClientType(int months) {
            this.months = months;
        }

        public double discount() {
            return 1.0;
        }

        public int getMonths() {
            return months;
        }
    }


    public static void main(String[] args) {
        System.out.println((ClientType.NEW.discount()));
        System.out.println((ClientType.SILVER.discount()));
        System.out.println((ClientType.GOLD.discount()));
        System.out.println((ClientType.PLATINUM.discount()));

    }
}
