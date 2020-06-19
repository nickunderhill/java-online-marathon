package sprint03.task2;

class NameList {
    public String[] names;

    private NameList() {
    }

    public Iterator getIterator() {
        return new Iterator();
    }

    public class Iterator {

        private Iterator(){
        }

        private NameList nameList = new NameList();
        int counter = 0;



        public boolean hasNext(){
            if (counter < 5) {
                return true;
            } else return false;

        }

        public String next(){
            if (hasNext()) {
                return names[counter++];
            } else throw new IndexOutOfBoundsException();
        }
    }

    public static void main(String[] args) {

    }

}